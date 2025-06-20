package io.github.nicheengine.aerial.aspect;

import io.github.nicheengine.aerial.mqtt.MqttTopicRequest;
import io.github.nicheengine.aerial.mqtt.MqttTopicResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class AerialMqttReplyAspect {
    @AfterReturning(value = "execution(public io.github.nicheengine.aerial.mqtt.MqttTopicResponse+ io.github.nicheengine.aerial.service.*.*(io.github.nicheengine.aerial.mqtt.MqttTopicRequest+, org.springframework.messaging.MessageHeaders))", returning = "result")
    public Object afterOfMqttReplyResult(JoinPoint point, MqttTopicResponse<?> result) {
        if (Objects.isNull(result)) {
            return null;
        }
        MqttTopicRequest<?> request = (MqttTopicRequest<?>) point.getArgs()[0];
        request.ofResponse(result);
        if (result instanceof TopicEventsResponse) {
            fillEvents((TopicEventsResponse) result, (TopicEventsRequest) request);
        } else if (result instanceof TopicRequestsResponse) {
            validateRequests((TopicRequestsResponse) result, (TopicRequestsRequest) request);
        } else if (result instanceof TopicStateResponse) {
            fillState((TopicStateResponse) result, (TopicStateRequest) request);
        }
        return response;
    }


    private void fillEvents(TopicEventsResponse response, TopicEventsRequest request) {
        if (!request.isNeedReply()) {
            response.setData(null);
            return;
        }
        response.setMethod(request.getMethod()).setData(MqttReply.success());
    }

    private void validateRequests(TopicRequestsResponse response, TopicRequestsRequest request) {
        response.setMethod(request.getMethod());
        Object data = response.getData();
        if (data instanceof MqttReply) {
            MqttReply mqttData = (MqttReply) data;
            if (MqttReply.CODE_SUCCESS != mqttData.getResult()) {
                return;
            }
            data = mqttData.getOutput();
        }
        Common.validateModel((BaseModel) data);
    }

    private void fillState(TopicStateResponse response, TopicStateRequest request) {
        response.setData(request.isNeedReply() ? MqttReply.success() : null);
    }
}
