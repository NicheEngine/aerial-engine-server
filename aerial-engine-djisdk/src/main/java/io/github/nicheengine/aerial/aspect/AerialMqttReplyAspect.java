package io.github.nicheengine.aerial.aspect;

import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.MqttTopicRequest;
import io.github.nicheengine.aerial.mqtt.MqttTopicResponse;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicRequest;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicResponse;
import io.github.nicheengine.aerial.mqtt.state.StateTopicRequest;
import io.github.nicheengine.aerial.mqtt.state.StateTopicResponse;
import io.github.nichetoolkit.rest.RestException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class AerialMqttReplyAspect {

    @SuppressWarnings("unchecked")
    @AfterReturning(value = "execution(public io.github.nicheengine.aerial.mqtt.MqttTopicResponse+ io.github.nicheengine.aerial.service.*.*(io.github.nicheengine.aerial.mqtt.MqttTopicRequest+, org.springframework.messaging.MessageHeaders))", returning = "result")
    public Object afterOfMqttReplyResult(JoinPoint point, MqttTopicResponse<?> result) throws RestException {
        if (Objects.isNull(result)) {
            return null;
        }
        MqttTopicRequest<?> request = (MqttTopicRequest<?>) point.getArgs()[0];
        request.ofResponse(result);
        if (result instanceof EventsTopicResponse && request instanceof EventsTopicRequest) {
            verifyOfEvents((EventsTopicResponse<Object>) result, (EventsTopicRequest<?>) request);
        } else if (result instanceof RequestsTopicResponse && request instanceof RequestsTopicRequest) {
            verifyOfRequests((RequestsTopicResponse<?>) result, (RequestsTopicRequest<?>) request);
        } else if (result instanceof StateTopicResponse && request instanceof StateTopicRequest) {
            verifyOfState((StateTopicResponse<Object>) result, (StateTopicRequest<?>) request);
        }
        return result;
    }


    private void verifyOfEvents(EventsTopicResponse<Object> response, EventsTopicRequest<?> request) {
        if (!request.isNeedReply()) {
            response.setData(null);
            return;
        }
        response.setMethod(request.getMethod());
        response.setData(MqttReplyResult.success());
    }

    private void verifyOfRequests(RequestsTopicResponse<?> response, RequestsTopicRequest<?> request) throws RestException {
        response.setMethod(request.getMethod());
        Object result = response.getData();
        if (result instanceof MqttReplyResult) {
            MqttReplyResult<?> replyResult = (MqttReplyResult<?>) result;
            if (MqttReplyResult.CODE_SUCCESS != replyResult.getResult()) {
                return;
            }
            result = replyResult.getOutput();
        }
        if (result instanceof AerialDjisdkModel) {
            AerialDjisdkModel djisdkModel = (AerialDjisdkModel) result;
            AerialDjisdkModel.ofVerify(djisdkModel);
        }
    }

    private void verifyOfState(StateTopicResponse<Object> response, StateTopicRequest<?> request) {
        response.setData(request.isNeedReply() ? MqttReplyResult.success() : null);
    }
}
