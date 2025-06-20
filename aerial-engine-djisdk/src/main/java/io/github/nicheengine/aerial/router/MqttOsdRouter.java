package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nicheengine.aerial.enums.method.OsdDeviceThing;
import io.github.nicheengine.aerial.manager.DjisdkManager;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.MqttTopicConstants;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.osd.OsdTopicRequest;
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

import java.util.*;

@Slf4j
@Configuration
public class MqttOsdRouter {

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttOsdRouter(AerialMqttProperties mqttProperties) {
        this.mqttProperties = mqttProperties;
        log.debug("The mqtt osd router for [router@/osd] initiated");
    }

    @Bean
    public IntegrationFlow flowOfOsdRouter() {
        IntegrationFlowBuilder flowBuilder = IntegrationFlows.from(DjisdkChannels.INBOUND_OSD);
        flowBuilder.transform(Message.class, this::handleOfRequest, null);
        flowBuilder.<OsdTopicRequest<?>, OsdDeviceThing>route(response -> OsdDeviceThing.parseKey(response.getData().getClass()),
                mapping -> Arrays.stream(OsdDeviceThing.values()).forEach(thing -> mapping.channelMapping(thing, thing.getChannel())));
        return flowBuilder.get();
    }

    private <T> OsdTopicRequest<T> handleOfRequest(Message<?> source) {
        OsdTopicRequest<T> topicRequest = MqttPayloadHelper.parsePayload(source,mqttProperties,new TypeReference<OsdTopicRequest<T>>(){});
        if (GeneralUtils.isNotEmpty(topicRequest)) {
            String topic = String.valueOf(source.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
            topicRequest.setFrom(topic.substring((MqttTopicConstants.THING_MODEL_PRE + MqttTopicConstants.PRODUCT).length(), topic.indexOf(MqttTopicConstants.OSD_SUF)));
            Object requestData = topicRequest.getData();
            String gateway = topicRequest.getGateway();
            GatewayManager gatewayManager = DjisdkManager.deviceSdk(gateway);
            if (GeneralUtils.isEmpty(gatewayManager)) {
                log.warn("The device [{}] has not been registered, please call the 'SDKManager.registerDevice()' method to register the device first.", gateway);
                return topicRequest;
            }
            GatewayThing gatewayThing = gatewayManager.getGatewayThing();
            OsdDeviceThing deviceThing = OsdDeviceThing.parseDevice(gatewayThing, topicRequest.getFrom().equals(gateway));
            if (OsdDeviceThing.UNKNOWN == deviceThing) {
                log.error("The thing [{}] is unknown, Can not to parse as osd device thing!, gateway: {}, from: {}", gatewayThing, gateway, topicRequest.getFrom());
                return topicRequest;
            }
            if (!deviceThing.isGateway()) {
                TypeFactory typeFactory = TypeFactory.defaultInstance();
                MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Object.class);
                Map<String, Object> requestMapData = JsonUtils.parseConvert(requestData, mapType);
                Object payloadData = requestMapData.getOrDefault(PayloadPosition.PAYLOAD_KEY, new ArrayList<>());
                CollectionType listType = typeFactory.constructCollectionType(ArrayList.class, Object.class);
                List<Object> payloadListData = JsonUtils.parseConvert(payloadData, listType);
                PayloadPosition.positionOfIndex().stream().filter(requestMapData::containsKey)
                        .map(requestMapData::get).forEach(payloadListData::add);
                requestMapData.put(PayloadPosition.PAYLOAD_KEY, payloadListData);
                requestData = requestMapData;
            }
            T topicData = JsonUtils.parseConvert(requestData, deviceThing.getType());
            topicRequest.setData(topicData);
        }
        return topicRequest;
    }
}
