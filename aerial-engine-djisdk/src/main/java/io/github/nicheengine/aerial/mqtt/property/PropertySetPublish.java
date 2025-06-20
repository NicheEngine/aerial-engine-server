package io.github.nicheengine.aerial.mqtt.property;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.enums.method.PropertySetResult;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.mqtt.MqttGatewayPublish;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

@Component
public class PropertySetPublish {

    @Resource
    private MqttGatewayPublish gatewayPublish;

    public PropertySetResult publish(String sn, Object data) throws AerialMqttErrorException {
        return this.publish(sn, data, MqttGatewayPublish.DEFAULT_RETRY_COUNT);
    }

    public PropertySetResult publish(String sn, Object data, int retryCount) throws AerialMqttErrorException {
        return this.publish(sn, data, retryCount, MqttGatewayPublish.DEFAULT_RETRY_TIMEOUT);
    }

    public PropertySetResult publish(String sn, Object data, int retryCount, long timeout) throws AerialMqttErrorException {
        String topic = MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT + Objects.requireNonNull(sn) + MqttTopicConstants.PROPERTY_SUF + MqttTopicConstants.SET_SUF;
        return gatewayPublish.publishWithReply(new TypeReference<PropertySetResult>() {},topic, PropertySetTopicRequest.builder()
                        .tid(UUID.randomUUID().toString())
                        .bid(null)
                        .timestamp(System.currentTimeMillis())
                        .data(Objects.requireNonNull(data)).build(), retryCount, timeout).getData();
    }

}
