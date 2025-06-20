package io.github.nicheengine.aerial.mqtt.status;

import io.github.nicheengine.aerial.manager.DjisdkManager;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.MqttTopicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StatusTopicService {

    public static final String TOPIC_FORMAT = MqttTopicConstants.BASIC_PRE + MqttTopicConstants.PRODUCT + "%s" + MqttTopicConstants.STATUS_SUF;

    @Resource
    private MqttTopicService topicService;

    public void subscribe(GatewayManager gateway) {
        DjisdkManager.registerDevice(gateway);
        topicService.subscribe(String.format(TOPIC_FORMAT, gateway.getGatewaySn()));
    }

    public void subscribeWildcardsStatus() {
        topicService.subscribe(String.format(TOPIC_FORMAT, "+"));
    }

    public void unsubscribe(GatewayManager gateway) {
        DjisdkManager.logoutDevice(gateway.getGatewaySn());
        topicService.unsubscribe(String.format(TOPIC_FORMAT, gateway.getGatewaySn()));
    }
}
