package io.github.nicheengine.aerial.mqtt;

import io.github.nicheengine.aerial.error.AerialErrorConstants;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class AerialGatewayPublish {

    private static final int DEFAULT_QOS = 0;

    public static final int DEFAULT_RETRY_COUNT = 2;
    public static final int DEFAULT_RETRY_TIMEOUT = 3000;

    @Resource
    private AerialMessageGateway messageGateway;

    public void publish(String topic, int qos, AerialTopicRequest<?> request) {
        byte[] payload = JsonUtils.parseJsonAsBytes(request);
        if (GeneralUtils.isNotEmpty(payload)) {
            messageGateway.publish(topic, payload, qos);
            log.debug("The gateway publish the message of request successfully, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(request));
        } else {
            log.error(" The gateway publish the message of request failed, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(request));
        }
    }

    public void publish(String topic, int qos, AerialTopicResponse<?> response) {
        byte[] payload = JsonUtils.parseJsonAsBytes(response);
        if (GeneralUtils.isNotEmpty(payload)) {
            messageGateway.publish(topic, payload, qos);
            log.debug("The gateway publish the message of response successfully, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(response));
        } else {
            log.error(" The gateway publish the message of response failed, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(response));
        }
    }

    public void publish(String topic, AerialTopicRequest<?> request, int publishCount) {
        AtomicInteger time = new AtomicInteger(0);
        while (time.getAndIncrement() < publishCount) {
            this.publish(topic, DEFAULT_QOS, request);
        }
    }

    public void publish(String topic, AerialTopicRequest<?> request) {
        this.publish(topic, DEFAULT_QOS, request);
    }

    public void publishReply(AerialTopicResponse<?> response, MessageHeaders headers) {
        this.publish(headers.get(MqttHeaders.RECEIVED_TOPIC) + AerialTopicConstants._REPLY_SUF, 2, response);
    }

    @SuppressWarnings("unchecked")
    public <T> AerialTopicResponse<T> publishWithReply(Class<T> clazz, String topic, AerialTopicRequest<?> request, int retryCount, long timeout) throws AerialMqttErrorException {
        AtomicInteger time = new AtomicInteger(0);
        RestOptional.ofEmptyable(request.getBid()).ofEmptyGet(() -> request.setBid(UUID.randomUUID().toString()));
        /* 重试 */
        while (time.getAndIncrement() <= retryCount) {
            this.publish(topic, request);
            // If the message is not received in 3 seconds then resend it again.
            AerialTopicResponse<?> receiver = AerialChannelFactory.instance(request.getTid(), true).get(request.getTid(), timeout);
            // Need to match tid and bid.
            if (GeneralUtils.isNotEmpty(receiver) && receiver.equalsOfRequest(request)) {
                Class<?> dataType = receiver.getData().getClass();
                OptionalUtils.ofFalse(clazz.isAssignableFrom(dataType), () -> new AerialMqttErrorException(AerialErrorStatus.AERIAL_DATA_ERROR, clazz.getSimpleName(), JsonPurityUtils.parseJson(receiver.getData())));
                return (AerialTopicResponse<T>) receiver;
            }
            // It must be guaranteed that the tid and bid of each message are different.
            RestOptional.ofEmptyable(request.getBid()).ofEmptyGet(() -> request.setBid(UUID.randomUUID().toString()));
            request.setTid(UUID.randomUUID().toString());
        }
        throw new AerialMqttErrorException(AerialErrorStatus.AERIAL_MQTT_PUBLIC_ERROR, I18nUtils.message(AerialErrorConstants.AERIAL_MQTT_NO_REPLY_MESSAGE_ERROR));
    }


}