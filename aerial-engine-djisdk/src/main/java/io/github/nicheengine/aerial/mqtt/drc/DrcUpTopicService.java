package io.github.nicheengine.aerial.mqtt.drc;

import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.MqttTopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class DrcUpTopicService {

    public static final String TOPIC_FORMAT = MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT + "%s" + MqttTopicConstants.DRC + MqttTopicConstants.UP;

    @Resource
    private MqttTopicService topicService;

    public void subscribe(GatewayManager gateway) {
        topicService.subscribe(String.format(TOPIC_FORMAT, gateway.getGatewaySn()));
    }
}
