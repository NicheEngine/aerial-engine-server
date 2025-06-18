package io.github.nicheengine.aerial.mqtt.drc;

import io.github.nicheengine.aerial.mqtt.AerialGatewayPublish;
import io.github.nicheengine.aerial.mqtt.AerialTopicConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class DrcDownPublish {

    @Resource
    private AerialGatewayPublish gatewayPublish;

    public static final int DEFAULT_PUBLISH_COUNT = 5;

    public void publish(String sn, String method) {
        this.publish(sn, method, null);
    }

    public void publish(String sn, String method, Object data) {
        this.publish(sn, method, data, DEFAULT_PUBLISH_COUNT);
    }

    public void publish(String sn, String method, Object data, int publishCount) {
        String topic = AerialTopicConstants.THING_MODEL_PRE + AerialTopicConstants.PRODUCT + Objects.requireNonNull(sn) + AerialTopicConstants.DRC + AerialTopicConstants.DOWN;

        gatewayPublish.publish(topic,
                new TopicDrcRequest<>()
                        .setMethod(method)
                        .setData(Objects.requireNonNullElse(data, "")),
                publishCount);
    }

}
