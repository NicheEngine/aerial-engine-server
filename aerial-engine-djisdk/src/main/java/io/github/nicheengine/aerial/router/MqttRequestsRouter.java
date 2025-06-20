package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.enums.method.RequestsMethod;
import io.github.nicheengine.aerial.mqtt.MqttGatewayPublish;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.property.PropertySetTopicResponse;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicRequest;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicResponse;
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
import org.springframework.messaging.MessageHeaders;

import java.util.Arrays;


@Slf4j
@Configuration
public class MqttRequestsRouter {

    private final MqttGatewayPublish gatewayPublish;

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttRequestsRouter(AerialMqttProperties mqttProperties, MqttGatewayPublish gatewayPublish) {
        this.mqttProperties = mqttProperties;
        this.gatewayPublish = gatewayPublish;
        log.debug("The mqtt requests router for [router@/requests] initiated");
    }

    @Bean
    public IntegrationFlow flowOfRequestsRouter() {
        IntegrationFlowBuilder flowBuilder = IntegrationFlows.from(DjisdkChannels.INBOUND_REQUESTS);
        flowBuilder.transform(Message.class, this::handleOfRequest, null);
        flowBuilder.<RequestsTopicRequest<?>, RequestsMethod>route(response -> RequestsMethod.parseKey(response.getMethod()),
                mapping -> Arrays.stream(RequestsMethod.values()).forEach(method -> mapping.channelMapping(method, method.getChannel())));
        return flowBuilder.get();
    }

    @Bean
    public IntegrationFlow flowOfRequestsReplyRouter() {
        return IntegrationFlows.from(DjisdkChannels.OUTBOUND_REQUESTS)
                .handle(this::handleOfPublish).nullChannel();
    }

    private RequestsTopicResponse<?> handleOfPublish(RequestsTopicResponse<?> response, MessageHeaders headers) {
        if (GeneralUtils.isNotEmpty(response)) {
            gatewayPublish.publishReply(response, headers);
        } else {
            log.error("The requests topic response is empty, Can not to publish reply message!");
        }
        return response;
    }

    private <T> RequestsTopicRequest<T> handleOfRequest(Message<?> source) {
        RequestsTopicRequest<T> topicRequest = MqttPayloadHelper.parsePayload(source,mqttProperties,new TypeReference<RequestsTopicRequest<T>>(){});
        if (GeneralUtils.isNotEmpty(topicRequest)) {
            Object requestData = topicRequest.getData();
            String requestMethod = topicRequest.getMethod();
            RequestsMethod requestsMethod = RequestsMethod.parseKey(requestMethod);
            if (RequestsMethod.UNKNOWN == requestsMethod) {
                log.error("The method [{}] is unknown, Can not to parse as requests method!", requestMethod);
                return topicRequest;
            }
            T topicData = JsonUtils.parseConvert(requestData, requestsMethod.getType());
            topicRequest.setData(topicData);
        }
        return topicRequest;
    }
}
