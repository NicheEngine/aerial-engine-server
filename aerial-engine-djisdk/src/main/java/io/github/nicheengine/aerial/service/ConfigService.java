package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.model.config.ProductConfigResponse;
import io.github.nicheengine.aerial.model.config.RequestsConfigRequest;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.RequestsChannels;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicRequest;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicResponse;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

@Slf4j
public abstract class ConfigService {

    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_CONFIG, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<ProductConfigResponse> requestsConfig(RequestsTopicRequest<RequestsConfigRequest> request, MessageHeaders headers) throws RestException {
        log.error("the service of [requestsConfig] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("requestsConfig not implemented.");
    }
}
