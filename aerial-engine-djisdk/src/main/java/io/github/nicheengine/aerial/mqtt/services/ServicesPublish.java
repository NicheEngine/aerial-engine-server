package io.github.nicheengine.aerial.mqtt.services;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttGatewayPublish;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class ServicesPublish {

    @Resource
    private MqttGatewayPublish gatewayPublish;


    public <T> ServicesTopicResponse<MqttErrorRequest<T>> publish(TypeReference<T> typeReference, String sn, String method) throws AerialMqttErrorException {
        return this.publish(typeReference, sn, method, null);
    }

    public <T> ServicesTopicResponse<MqttErrorRequest<T>> publish(TypeReference<T> typeReference, String sn, String method, Object data) throws AerialMqttErrorException {
        return this.publish(typeReference, sn, method, data, MqttGatewayPublish.DEFAULT_RETRY_COUNT);
    }

    public <T> ServicesTopicResponse<MqttErrorRequest<T>> publish(TypeReference<T> typeReference, String sn, String method, Object data, int retryCount) throws AerialMqttErrorException {
        return this.publish(typeReference, sn, method, data, retryCount, MqttGatewayPublish.DEFAULT_RETRY_TIMEOUT);
    }

    public <T> ServicesTopicResponse<MqttErrorRequest<T>> publish(TypeReference<T> typeReference, String sn, String method, Object data, long timeout) throws AerialMqttErrorException {
        return this.publish(typeReference, sn, method, data, MqttGatewayPublish.DEFAULT_RETRY_COUNT, timeout);
    }

    public <T> ServicesTopicResponse<MqttErrorRequest<T>> publish(TypeReference<T> typeReference, String sn, String method, Object data, int retryCount, long timeout) throws AerialMqttErrorException {
        return this.publish(typeReference, sn, method, data, null, retryCount, timeout);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method) throws AerialMqttErrorException {
        return this.publish(sn, method, null, null);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data) throws AerialMqttErrorException {
        return this.publish(sn, method, data, null);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data, int retryCount) throws AerialMqttErrorException {
        return this.publish(sn, method, data, null, retryCount);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data, long timeout) throws AerialMqttErrorException {
        return this.publish(sn, method, data, null, timeout);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data, int retryCount, long timeout) throws AerialMqttErrorException {
        return this.publish(sn, method, data, null, retryCount, timeout);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data, String bid) throws AerialMqttErrorException {
        return this.publish(sn, method, data, bid, MqttGatewayPublish.DEFAULT_RETRY_COUNT);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data, String bid, int retryCount) throws AerialMqttErrorException {
        return this.publish(sn, method, data, bid, retryCount, MqttGatewayPublish.DEFAULT_RETRY_TIMEOUT);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data, String bid, long timeout) throws AerialMqttErrorException {
        return this.publish(sn, method, data, bid, MqttGatewayPublish.DEFAULT_RETRY_COUNT, timeout);
    }

    public <T> ServicesTopicResponse<MqttErrorRequest<?>> publish(String sn, String method, Object data, String bid, int retryCount, long timeout) throws AerialMqttErrorException {
        ServicesTopicResponse<ServicesReceiver<?>> topicResponse = publishOfReceiver(sn, method, data, bid, retryCount, timeout);
        ServicesReceiver<?> receiver = topicResponse.getData();
        MqttErrorRequest<Object> reply = new MqttErrorRequest<>();
        reply.setResult(receiver.getResult());
        ServicesTopicResponse<MqttErrorRequest<?>> replyResponse = ServicesTopicResponse.ofResponse(topicResponse);
        Object output = GeneralUtils.isNotEmpty(receiver.getOutput()) ? receiver.getOutput() : GeneralUtils.isNotEmpty(receiver.getInfo()) ? receiver.getInfo() : null;
        reply.setOutput(output);
        replyResponse.setData(reply);
        return replyResponse;
    }

    public <T> ServicesTopicResponse<MqttErrorRequest<T>> publish(TypeReference<T> typeReference, String sn, String method, Object data, String bid, int retryCount, long timeout) throws AerialMqttErrorException {
        ServicesTopicResponse<ServicesReceiver<?>> topicResponse = publishOfReceiver(sn, method, data, bid, retryCount, timeout);
        ServicesReceiver<?> receiver = topicResponse.getData();
        MqttErrorRequest<T> reply = new MqttErrorRequest<>();
        reply.setResult(receiver.getResult());
        ServicesTopicResponse<MqttErrorRequest<T>> replyResponse = ServicesTopicResponse.ofResponse(topicResponse);
        if (GeneralUtils.isNotEmpty(receiver.getInfo())) {
            reply.setOutput(JsonUtils.parseConvert(receiver.getInfo(), typeReference));
        }
        if (GeneralUtils.isNotEmpty(receiver.getOutput())) {
            reply.setOutput(JsonUtils.parseConvert(receiver.getOutput(), typeReference));
        }
        replyResponse.setData(reply);
        return replyResponse;
    }

    private ServicesTopicResponse<ServicesReceiver<?>> publishOfReceiver(String sn, String method, Object data, String bid, int retryCount, long timeout) throws AerialMqttErrorException {
        String topic = MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT + Objects.requireNonNull(sn) + MqttTopicConstants.SERVICES_SUF;
        return gatewayPublish.publishWithReply(
                new TypeReference<ServicesTopicResponse<ServicesReceiver<?>>>() {}, new TypeReference<ServicesReceiver<?>>() {}, topic,
                ServicesTopicRequest.builder()
                        .tid(UUID.randomUUID().toString())
                        .bid(bid).method(method)
                        .timestamp(System.currentTimeMillis())
                        .data(Optional.ofNullable(data).orElse("")).build(), retryCount, timeout);
    }

}
