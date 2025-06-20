package io.github.nicheengine.aerial.router;

import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.enums.DjisdkTopic;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@Component
public class MqttMessageRouter extends AbstractMessageRouter {

    private final AerialMqttProperties mqttProperties;

    public MqttMessageRouter(AerialMqttProperties mqttProperties) {
        this.mqttProperties = mqttProperties;
        log.debug("The mqtt message router for [router@/message] initiated");
    }

    @Override
    @Router(inputChannel = MqttChannels.INBOUND)
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        MessageHeaders headers = message.getHeaders();
        Object receivedTopic = headers.get(MqttHeaders.RECEIVED_TOPIC);
        assert receivedTopic != null;
        String topic = receivedTopic.toString();
        Boolean payloadAsBytes = mqttProperties.getMessage().getPayloadAsBytes();
        String payload;
        if (payloadAsBytes) {
            payload = new String((byte[]) message.getPayload());
        } else {
            payload = message.getPayload().toString();
        }
        if (!topic.contains("osd")) {
            log.info("received topic: {} \t payload =>{}", topic, payload);
        } else {
            log.debug("received topic: {} \t payload =>{}", topic, payload);
        }
        DjisdkTopic djisdkTopic = DjisdkTopic.parseTopic(topic);
        if (DjisdkTopic.UNKNOWN == djisdkTopic) {
            log.error("The topic [{}] is unknown, Can not to parse as dji sdk topic!", topic);
            return Collections.emptyList();
        }
        String beanName = djisdkTopic.getBeanName();
        Object beanOfName = BeanUtils.beanOfName(beanName);
        if (GeneralUtils.isEmpty(beanOfName)) {
            log.error("The bean is no found, you need to inject the bean of named '{}'!", beanName);
            return Collections.emptyList();
        }
        if (beanOfName instanceof MessageChannel) {
            MessageChannel messageChannel = (MessageChannel) beanOfName;
            return Collections.singleton(messageChannel);
        } else {
            log.error("The bean type is not 'MessageChannel', you need to inject the mqtt [MessageChannel] bean of named '{}'!", beanName);
            return Collections.emptyList();
        }
    }
}