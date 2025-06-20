package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nichetoolkit.rest.util.JsonUtils;
import org.springframework.messaging.Message;

public class MqttPayloadHelper {

    public static <T extends MqttMessage<?>> T parsePayload(Message<?> source, AerialMqttProperties mqttProperties,TypeReference<T> typeReference) {
        Boolean payloadAsBytes = mqttProperties.getMessage().getPayloadAsBytes();
        T topicResponse;
        if (payloadAsBytes) {
            byte[] payloadBytes = (byte[]) source.getPayload();
            topicResponse = JsonUtils.parseBean(payloadBytes, typeReference);
        } else {
            String payloadJson = source.getPayload().toString();
            topicResponse = JsonUtils.parseBean(payloadJson, typeReference);
        }
        return topicResponse;
    }
}
