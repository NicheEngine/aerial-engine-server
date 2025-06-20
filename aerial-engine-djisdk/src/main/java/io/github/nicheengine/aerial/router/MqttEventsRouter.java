package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.enums.method.EventsMethod;
import io.github.nicheengine.aerial.mqtt.MqttGatewayPublish;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.drc.DrcTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.Arrays;

@Slf4j
@Configuration
public class MqttEventsRouter {

    private final MqttGatewayPublish gatewayPublish;

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttEventsRouter(AerialMqttProperties mqttProperties, MqttGatewayPublish gatewayPublish) {
        this.mqttProperties = mqttProperties;
        this.gatewayPublish = gatewayPublish;
        log.debug("The mqtt flow router for [router@/events] initiated");
    }

    @Bean
    public IntegrationFlow flowOfEventsRouter() {
        IntegrationFlowBuilder flowBuilder = IntegrationFlows.from(DjisdkChannels.INBOUND_EVENTS);
        flowBuilder.transform(Message.class, this::handleOfRequest, null);
        flowBuilder.<EventsTopicRequest<?>, EventsMethod>route(response -> EventsMethod.parseKey(response.getMethod()),
                mapping -> Arrays.stream(EventsMethod.values()).forEach(method -> mapping.channelMapping(method, method.getChannel())));
        return flowBuilder.get();
    }

    @Bean
    public IntegrationFlow flowOfEventsReplySuccessRouter() {
        return IntegrationFlows.from(DjisdkChannels.OUTBOUND_EVENTS)
                .handle(this::handleOfPublish).nullChannel();

    }

    private EventsTopicResponse<?> handleOfPublish(EventsTopicResponse<?> response, MessageHeaders headers) {
        if (GeneralUtils.isNotEmpty(response) && GeneralUtils.isNotEmpty(response.getData())) {
            gatewayPublish.publishReply(response, headers);
        }
        return response;
    }

    private <T> EventsTopicRequest<T> handleOfRequest(Message<?> source) {
        EventsTopicRequest<T> topicRequest = MqttPayloadHelper.parsePayload(source,mqttProperties,new TypeReference<EventsTopicRequest<T>>(){});
        if (GeneralUtils.isNotEmpty(topicRequest)) {
            String topic = String.valueOf(source.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
            topicRequest.setFrom(topic.substring((MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT).length(), topic.indexOf(MqttTopicConstants.EVENTS_SUF)));
            Object requestData = topicRequest.getData();
            String requestMethod = topicRequest.getMethod();
            EventsMethod eventsMethod = EventsMethod.parseKey(requestMethod);
            if (EventsMethod.UNKNOWN == eventsMethod) {
                log.error("The method [{}] is unknown, Can not to parse as events method!", requestMethod);
                return topicRequest;
            }
            T topicData = JsonUtils.parseConvert(requestData, eventsMethod.getTypeReference());
            topicRequest.setData(topicData);
        }
        return topicRequest;
    }
}
