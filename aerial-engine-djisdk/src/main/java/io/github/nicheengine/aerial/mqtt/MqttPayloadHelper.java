package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nichetoolkit.rest.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

@Slf4j
public class MqttPayloadHelper {

    public static <T extends MqttMessage<?>> T parsePayload(Message<?> source, AerialMqttProperties mqttProperties,TypeReference<T> typeReference) {
        Boolean payloadAsBytes = mqttProperties.getMessage().getPayloadAsBytes();
        T topicResponse;
        if (payloadAsBytes) {
            byte[] payloadBytes = (byte[]) source.getPayload();
            log.debug("\n ===> message byte payload: {}", new String(payloadBytes));
            topicResponse = JsonUtils.parseBean(payloadBytes, typeReference);
        } else {
            String payloadJson = source.getPayload().toString();
            log.debug("\n ===> message json payload: {}",  payloadJson);
            topicResponse = JsonUtils.parseBean(payloadJson, typeReference);
        }
        return topicResponse;
    }
}
