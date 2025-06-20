package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.model.device.UpdateTopo;
import io.github.nicheengine.aerial.mqtt.MqttGatewayPublish;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.StatusChannels;
import io.github.nicheengine.aerial.mqtt.status.StatusTopicRequest;
import io.github.nicheengine.aerial.mqtt.status.StatusTopicResponse;
import io.github.nichetoolkit.rest.util.GeneralUtils;
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
import org.springframework.util.CollectionUtils;

import java.util.Optional;

@Slf4j
@Configuration
public class MqttStatusRouter {

    private final MqttGatewayPublish gatewayPublish;

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttStatusRouter(AerialMqttProperties mqttProperties, MqttGatewayPublish gatewayPublish) {
        this.mqttProperties = mqttProperties;
        this.gatewayPublish = gatewayPublish;
        log.debug("The mqtt flow router for [router@/status] initiated");
    }

    @Bean
    public IntegrationFlow flowOfStatusRouter() {
        IntegrationFlowBuilder flowBuilder = IntegrationFlows.from(DjisdkChannels.INBOUND_STATUS);
        flowBuilder.transform(Message.class, this::handleOfRequest, null);
        flowBuilder.<StatusTopicRequest<UpdateTopo>, Boolean>route(response -> Optional.ofNullable(response.getData()).map(UpdateTopo::getSubDevices).map(CollectionUtils::isEmpty).orElse(true),
                mapping -> mapping.channelMapping(true, StatusChannels.INBOUND_STATUS_OFFLINE)
                        .channelMapping(false, StatusChannels.INBOUND_STATUS_ONLINE));
        return flowBuilder.get();
    }

    @Bean
    public IntegrationFlow flowOfStatusReplySuccessRouter() {
        return IntegrationFlows.from(DjisdkChannels.OUTBOUND_STATUS)
                .handle(this::handleOfPublish).nullChannel();

    }

    private StatusTopicResponse<?> handleOfPublish(StatusTopicResponse<?> response, MessageHeaders headers) {
        if (GeneralUtils.isNotEmpty(response)) {
            gatewayPublish.publishReply(response, headers);
        }
        return response;
    }

    private StatusTopicRequest<UpdateTopo> handleOfRequest(Message<?> source) {
        StatusTopicRequest<UpdateTopo> topicRequest = MqttPayloadHelper.parsePayload(source,mqttProperties,new TypeReference<StatusTopicRequest<UpdateTopo>>(){});
        if (GeneralUtils.isNotEmpty(topicRequest)) {
            String topic = String.valueOf(source.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
            topicRequest.setFrom(topic.substring((MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT).length(), topic.indexOf(MqttTopicConstants.STATUS_SUF)));
        }
        return topicRequest;
    }
}
