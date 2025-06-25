package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.StateMethod;
import io.github.nicheengine.aerial.manager.DjisdkManager;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.MqttDeviceState;
import io.github.nicheengine.aerial.mqtt.MqttGatewayPublish;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.state.StateTopicRequest;
import io.github.nicheengine.aerial.mqtt.state.StateTopicResponse;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Configuration
public class MqttStateRouter {

    private final MqttGatewayPublish gatewayPublish;

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttStateRouter(AerialMqttProperties mqttProperties, MqttGatewayPublish gatewayPublish) {
        this.mqttProperties = mqttProperties;
        this.gatewayPublish = gatewayPublish;
        log.debug("The mqtt state router for [router@/state] initiated");
    }

    @Bean
    public IntegrationFlow flowOfStateRouter() {
        IntegrationFlowBuilder flowBuilder = IntegrationFlows.from(DjisdkChannels.INBOUND_STATE);
        flowBuilder.transform(Message.class, this::handleOfRequest, null);
        flowBuilder.<StateTopicRequest<?>, StateMethod>route(response -> StateMethod.parseValue(response.getData().getClass()),
                mapping -> Arrays.stream(StateMethod.values()).forEach(method -> mapping.channelMapping(method, method.getChannel())));
        return flowBuilder.get();
    }

    @Bean
    public IntegrationFlow flowOfStateReplySuccessRouter() {
        return IntegrationFlows.from(DjisdkChannels.OUTBOUND_STATE)
                .handle(this::handleOfPublish).nullChannel();

    }

    private StateTopicResponse<?> handleOfPublish(StateTopicResponse<?> response, MessageHeaders headers) {
        if (GeneralUtils.isNotEmpty(response) && GeneralUtils.isNotEmpty(response.getData())) {
            gatewayPublish.publishReply(response, headers);
        }
        return response;
    }

    private <T> StateTopicRequest<T> handleOfRequest(Message<?> source) {
        StateTopicRequest<T> topicRequest = MqttPayloadHelper.parsePayload(source, mqttProperties, new TypeReference<StateTopicRequest<T>>() {
        });
        if (GeneralUtils.isNotEmpty(topicRequest)) {
            String topic = String.valueOf(source.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
            topicRequest.setFrom(topic.substring((MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT).length(), topic.indexOf(MqttTopicConstants.STATE_SUF)));
            Object requestData = topicRequest.getData();
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Object.class);
            Map<String, Object> requestMapData = JsonUtils.parseConvert(requestData, mapType);
            String gateway = topicRequest.getGateway();
            GatewayManager gatewayManager = DjisdkManager.deviceSdk(gateway);
            if (GeneralUtils.isEmpty(gatewayManager)) {
                log.warn("The device [{}] has not been registered, please call the 'SDKManager.registerDevice()' method to register the device first.", gateway);
                return topicRequest;
            }
            GatewayThing gatewayThing = gatewayManager.getGatewayThing();
            Class<T> stateModelType = typeOfGatewayThing(gatewayThing, requestMapData.keySet());
            if (GeneralUtils.isEmpty(stateModelType)) {
                log.error("The gateway thing [{}] is unknown, Can not to parse as state bean!, gateway：{}", gatewayThing.name(), gateway);
                return topicRequest;
            }
            T topicData = JsonUtils.parseConvert(requestData, stateModelType);
            topicRequest.setData(topicData);
        }
        return topicRequest;
    }

    private <T> Class<T> typeOfGatewayThing(GatewayThing gatewayThing, Set<String> keys) {
        switch (gatewayThing) {
            case REMOTER_CONTROL:
                return MqttDeviceState.parseRcState(keys).getJavaType();
            case DOCK:
            case DOCK2:
            case DOCK3:
                return MqttDeviceState.parseDockState(keys).getJavaType();
            case UNKNOWN:
            default:
                return null;
        }
    }
}
