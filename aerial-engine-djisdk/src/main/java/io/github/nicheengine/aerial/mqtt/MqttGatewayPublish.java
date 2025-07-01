package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.github.nicheengine.aerial.error.AerialErrorConstants;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.error.status.EngineErrorStatus;
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
public class MqttGatewayPublish {

    private static final int DEFAULT_QOS = 0;

    public static final int DEFAULT_RETRY_COUNT = 2;
    public static final int DEFAULT_RETRY_TIMEOUT = 3000;

    @Resource
    private MqttMessageGateway messageGateway;

    public void publish(String topic, int qos, MqttTopicRequest<?> request) {
        byte[] payload = JsonUtils.parseJsonAsBytes(request);
        if (GeneralUtils.isNotEmpty(payload)) {
            messageGateway.publish(topic, payload, qos);
            log.debug("The gateway publish the message of request successfully, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(request));
        } else {
            log.error(" The gateway publish the message of request failed, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(request));
        }
    }

    public void publish(String topic, int qos, MqttTopicResponse<?> response) {
        byte[] payload = JsonUtils.parseJsonAsBytes(response);
        if (GeneralUtils.isNotEmpty(payload)) {
            messageGateway.publish(topic, payload, qos);
            log.debug("The gateway publish the message of response successfully, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(response));
        } else {
            log.error(" The gateway publish the message of response failed, topic: {}, payload: {}", topic, JsonPurityUtils.parseJson(response));
        }
    }

    public void publish(String topic, MqttTopicRequest<?> request, int publishCount) {
        AtomicInteger time = new AtomicInteger(0);
        while (time.getAndIncrement() < publishCount) {
            this.publish(topic, DEFAULT_QOS, request);
        }
    }

    public void publish(String topic, MqttTopicRequest<?> request) {
        this.publish(topic, DEFAULT_QOS, request);
    }

    public void publishReply(MqttTopicResponse<?> response, MessageHeaders headers) {
        this.publish(headers.get(MqttHeaders.RECEIVED_TOPIC) + MqttTopicConstants._REPLY_SUF, 2, response);
    }
    public <T> MqttTopicResponse<T> publishWithReply(TypeReference<T> dataReference, String topic, MqttTopicRequest<?> request, int retryCount, long timeout) throws AerialMqttErrorException {
        return publishWithReply(new TypeReference<MqttTopicResponse<T>>() {}, dataReference, topic, request, retryCount, timeout);
    }

    public <P extends MqttTopicResponse<T>,T> P publishWithReply(TypeReference<P> responseReference, TypeReference<T> dataReference, String topic, MqttTopicRequest<?> request, int retryCount, long timeout) throws AerialMqttErrorException {
        AtomicInteger time = new AtomicInteger(0);
        RestOptional.ofEmptyable(request.getBid()).ofEmptyGet(() -> request.setBid(UUID.randomUUID().toString()));
        /* 重试 */
        while (time.getAndIncrement() <= retryCount) {
            this.publish(topic, request);
            // If the message is not received in 3 seconds then resend it again.
            MqttMessage<?> message = MqttChannelFactory.instance(request.getTid(), true).get(request.getTid(), timeout);
            // Need to match tid and bid.
            if (GeneralUtils.isNotEmpty(message) && message.ofEquals(request)) {
                Class<?> messageDataType = message.getData().getClass();
                JavaType dataType = TypeFactory.defaultInstance().constructType(dataReference);
                OptionalUtils.ofFalse(messageDataType.isAssignableFrom(dataType.getRawClass()), () -> new AerialMqttErrorException(EngineErrorStatus.AERIAL_DATA_ERROR, dataType.getRawClass().getSimpleName(), JsonPurityUtils.parseJson(message.getData())));
                return JsonUtils.parseConvert(message,responseReference);
            }
            // It must be guaranteed that the tid and bid of each message are different.
            RestOptional.ofEmptyable(request.getBid()).ofEmptyGet(() -> request.setBid(UUID.randomUUID().toString()));
            request.setTid(UUID.randomUUID().toString());
        }
        throw new AerialMqttErrorException(EngineErrorStatus.AERIAL_MQTT_PUBLIC_ERROR, I18nUtils.message(AerialErrorConstants.AERIAL_MQTT_NO_REPLY_MESSAGE_ERROR));
    }


}