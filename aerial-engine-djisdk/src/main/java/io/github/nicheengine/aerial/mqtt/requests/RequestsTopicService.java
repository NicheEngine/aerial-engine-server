package io.github.nicheengine.aerial.mqtt.requests;

import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.MqttTopicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RequestsTopicService {
    public static final String TOPIC_FORMAT = MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT + "%s" + MqttTopicConstants.REQUESTS_SUF;

    @Resource
    private MqttTopicService topicService;

    public void subscribe(GatewayManager gateway) {
        topicService.subscribe(String.format(TOPIC_FORMAT, gateway.getGatewaySn()));
    }

    public void unsubscribe(GatewayManager gateway) {
        topicService.unsubscribe(String.format(TOPIC_FORMAT, gateway.getGatewaySn()));
    }

    public void subscribeWildcardsRequests() {
        topicService.subscribe(MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT + "+" + MqttTopicConstants.REQUESTS_SUF);
    }
}
