package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.model.organization.*;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.RequestsChannels;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicRequest;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicResponse;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

@Slf4j
public abstract class OrganizationService {

    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_AIRPORT_BIND_STATUS, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<MqttReplyResult<AirportBindStatusResponse>> airportBindStatus(
            RequestsTopicRequest<AirportBindStatusRequest> request, MessageHeaders headers) throws RestException {
        log.error("the service of [airportBindStatus] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("airportBindStatus not implemented.");
    }

    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_AIRPORT_ORGANIZATION_GET, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<MqttReplyResult<AirportOrganizationGetResponse>> airportOrganizationGet(
            RequestsTopicRequest<AirportOrganizationGetRequest> request, MessageHeaders headers) throws RestException {
        log.error("the service of [airportOrganizationGet] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("airportOrganizationGet not implemented.");
    }

    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_AIRPORT_ORGANIZATION_BIND, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<MqttReplyResult<AirportOrganizationBindResponse>> airportOrganizationBind (
            RequestsTopicRequest<AirportOrganizationBindRequest> request, MessageHeaders headers) throws RestException  {
        log.error("the service of [airportOrganizationBind] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("airportOrganizationBind not implemented.");
    }
}
