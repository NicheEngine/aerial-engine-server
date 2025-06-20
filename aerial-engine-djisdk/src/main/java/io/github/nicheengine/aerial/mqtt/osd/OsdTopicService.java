package io.github.nicheengine.aerial.mqtt.osd;

import io.github.nicheengine.aerial.manager.DjisdkManager;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.MqttTopicService;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OsdTopicService {

    public static final String TOPIC_FORMAT = MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT + "%s" + MqttTopicConstants.OSD_SUF;

    @Resource
    private MqttTopicService topicService;

    public void subscribe(GatewayManager gateway, boolean unsubscribeSubDevice) {
        DjisdkManager.registerDevice(gateway);
        topicService.subscribe(String.format(TOPIC_FORMAT, gateway.getGatewaySn()));
        if (unsubscribeSubDevice) {
            topicService.unsubscribe(String.format(TOPIC_FORMAT, gateway.getDroneSn()));
            return;
        }
        if (GeneralUtils.isNotEmpty(gateway.getDroneSn())) {
            topicService.subscribe(String.format(TOPIC_FORMAT, gateway.getDroneSn()));
        }
    }

    public void unsubscribe(GatewayManager gateway) {
        DjisdkManager.logoutDevice(gateway.getGatewaySn());
        topicService.unsubscribe(String.format(TOPIC_FORMAT, gateway.getGatewaySn()));
        if (GeneralUtils.isNotEmpty(gateway.getDroneSn())) {
            topicService.unsubscribe(String.format(TOPIC_FORMAT, gateway.getDroneSn()));
        }
    }
}
