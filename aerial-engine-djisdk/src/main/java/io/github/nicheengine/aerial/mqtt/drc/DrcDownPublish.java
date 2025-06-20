package io.github.nicheengine.aerial.mqtt.drc;

import io.github.nicheengine.aerial.mqtt.MqttGatewayPublish;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class DrcDownPublish {

    @Resource
    private MqttGatewayPublish gatewayPublish;

    public static final int DEFAULT_PUBLISH_COUNT = 5;

    public void publish(String sn, String method) {
        this.publish(sn, method, null);
    }

    public void publish(String sn, String method, Object data) {
        this.publish(sn, method, data, DEFAULT_PUBLISH_COUNT);
    }

    public void publish(String sn, String method, Object data, int publishCount) {
        String topic = MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT + Objects.requireNonNull(sn) + MqttTopicConstants.DRC + MqttTopicConstants.DOWN;

        gatewayPublish.publish(topic,
                DrcTopicRequest.builder().method(method)
                        .data(GeneralUtils.isNotEmpty(data) ? data : "")
                        .build(), publishCount);
    }

}
