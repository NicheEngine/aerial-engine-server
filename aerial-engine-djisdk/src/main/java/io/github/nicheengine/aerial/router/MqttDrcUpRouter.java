package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.drc.DrcTopicRequest;
import io.github.nicheengine.aerial.enums.method.DrcUpMethod;
import io.github.nicheengine.aerial.mqtt.property.PropertySetTopicResponse;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;

import java.util.Arrays;

@Slf4j
@Configuration
public class MqttDrcUpRouter {

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttDrcUpRouter(AerialMqttProperties mqttProperties) {
        this.mqttProperties = mqttProperties;
        log.debug("The mqtt drc-up router for [router@/drc/up] initiated");
    }

    @Bean
    public IntegrationFlow flowOfDrcUpRouter() {
        IntegrationFlowBuilder flowBuilder = IntegrationFlows.from(DjisdkChannels.INBOUND_DRC_UP);
        flowBuilder.transform(Message.class, this::handleOfRequest, null);
        flowBuilder.<DrcTopicRequest<?>, DrcUpMethod>route(response -> DrcUpMethod.parseKey(response.getMethod()),
                mapping -> Arrays.stream(DrcUpMethod.values()).forEach(method -> mapping.channelMapping(method, method.getChannel())));
        return flowBuilder.get();
    }

    private <T> DrcTopicRequest<T> handleOfRequest(Message<?> source) {
        DrcTopicRequest<T> topicRequest = MqttPayloadHelper.parsePayload(source,mqttProperties,new TypeReference<DrcTopicRequest<T>>(){});
        if (GeneralUtils.isNotEmpty(topicRequest)) {
            Object requestData = topicRequest.getData();
            String requestMethod = topicRequest.getMethod();
            DrcUpMethod drcUpMethod = DrcUpMethod.parseKey(requestMethod);
            if (DrcUpMethod.UNKNOWN == drcUpMethod) {
                log.error("The method [{}] is unknown, Can not to parse as drc up method!", requestMethod);
                return topicRequest;
            }
            T topicData = JsonUtils.parseConvert(requestData, drcUpMethod.getTypeReference());
            topicRequest.setData(topicData);
        }
        return topicRequest;
    }
}
