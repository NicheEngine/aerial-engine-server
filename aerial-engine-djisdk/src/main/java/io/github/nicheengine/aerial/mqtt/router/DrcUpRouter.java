package io.github.nicheengine.aerial.mqtt.router;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.drc.DrcTopicRequest;
import io.github.nicheengine.aerial.mqtt.method.DrcUpMethod;
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
public class DrcUpRouter {

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public DrcUpRouter(AerialMqttProperties mqttProperties) {
        this.mqttProperties = mqttProperties;
        log.debug("The mqtt flow router for [router@/drc/up] initiated");
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
        AerialMqttProperties.Message message = mqttProperties.getMessage();
        Boolean payloadAsBytes = message.getPayloadAsBytes();
        DrcTopicRequest<T> drcTopicRequest;
        if (payloadAsBytes) {
            byte[] payloadBytes = (byte[]) source.getPayload();
            drcTopicRequest = JsonUtils.parseBean(payloadBytes, new TypeReference<DrcTopicRequest<T>>() {
            });
        } else {
            String payloadJson = source.getPayload().toString();
            drcTopicRequest = JsonUtils.parseBean(payloadJson, new TypeReference<DrcTopicRequest<T>>() {
            });
        }
        if (GeneralUtils.isNotEmpty(drcTopicRequest)) {
            Object requestData = drcTopicRequest.getData();
            String requestMethod = drcTopicRequest.getMethod();
            DrcUpMethod drcUpMethod = DrcUpMethod.parseKey(requestMethod);
            if (DrcUpMethod.UNKNOWN != drcUpMethod) {
                TypeReference<T> typeReference = drcUpMethod.getTypeReference();
                T convertData = JsonUtils.parseConvert(requestData, typeReference);
                drcTopicRequest.setData(convertData);
            }
        }
        return drcTopicRequest;
    }
}
