package io.github.nicheengine.aerial.mqtt.drc;

import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.AerialTopicConstants;
import io.github.nicheengine.aerial.mqtt.AerialTopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class DrcUpService {

    @Resource
    private AerialTopicService topicService;

    public void subscribe(GatewayManager gateway) {
        String drcTopic = AerialTopicConstants.THING_MODEL_PRE + AerialTopicConstants.PRODUCT + "%s" + AerialTopicConstants.DRC + AerialTopicConstants.UP;
        topicService.subscribe(String.format(drcTopic, gateway.getGatewaySn()));
    }
}
