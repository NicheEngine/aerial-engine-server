package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.enums.PropertySetResult;
import io.github.nicheengine.aerial.mqtt.MqttChannelFactory;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.property.PropertySetTopicResponse;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqttPropertySetReply {

    private static final String RESULT_KEY = "result";

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttPropertySetReply(AerialMqttProperties mqttProperties) {
        this.mqttProperties = mqttProperties;
        log.debug("The mqtt property set router for [router@/propertySet/reply] initiated");
    }

    @ServiceActivator(inputChannel = DjisdkChannels.INBOUND_PROPERTY_SET_REPLY)
    public void propertySetReply(Message<?> source) {
        PropertySetTopicResponse<Object> topicResponse = MqttPayloadHelper.parsePayload(source,mqttProperties,new TypeReference<PropertySetTopicResponse<Object>>(){});
        JsonNode resultValue = JsonUtils.parseConvert(topicResponse.getData(), JsonNode.class).findValue(RESULT_KEY);
        MqttChannelFactory channelFactory = MqttChannelFactory.instance(topicResponse.getTid(), false);
        if (GeneralUtils.isNotEmpty(resultValue) && GeneralUtils.isNotEmpty(channelFactory)) {
            PropertySetResult propertySetResult = PropertySetResult.parseKey(resultValue.intValue());
            if (PropertySetResult.UNKNOWN == propertySetResult) {
                log.error("The result value [{}] is unknown, Can not to parse as property set result!", resultValue.intValue());
                return;
            }
            topicResponse.setData(propertySetResult);
            channelFactory.put(topicResponse);
        }
    }
}
