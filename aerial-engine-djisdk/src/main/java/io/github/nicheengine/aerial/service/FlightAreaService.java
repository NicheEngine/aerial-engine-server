package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.FlightareaMethod;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.flightarea.FlightAreasDroneLocation;
import io.github.nicheengine.aerial.model.flightarea.FlightAreasGetRequest;
import io.github.nicheengine.aerial.model.flightarea.FlightAreasGetResponse;
import io.github.nicheengine.aerial.model.flightarea.FlightAreasSyncProgress;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.channel.RequestsChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicRequest;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicResponse;
import io.github.nicheengine.aerial.mqtt.services.ServicesPublish;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

@Slf4j
public abstract class FlightAreaService {
    @Resource
    private ServicesPublish servicesPublish;

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL, include = {GatewayThing.DOCK, GatewayThing.DOCK2,GatewayThing.DOCK3})
    public ServicesTopicResponse<MqttErrorRequest<?>> flightAreasUpdate(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), FlightareaMethod.FLIGHT_AREAS_UPDATE.getMethod());
    }
    
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FLIGHT_AREAS_SYNC_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> flightAreasSyncProgress(EventsTopicRequest<FlightAreasSyncProgress> request, MessageHeaders headers) throws RestException {
        log.error("the service of [flightAreasSyncProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("flightAreasSyncProgress not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FLIGHT_AREAS_DRONE_LOCATION, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> flightAreasDroneLocation(EventsTopicRequest<FlightAreasDroneLocation> request, MessageHeaders headers) throws RestException {
        log.error("the service of [flightAreasDroneLocation] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("flightAreasDroneLocation not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_FLIGHT_AREAS_GET, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<MqttReplyResult<FlightAreasGetResponse>> flightAreasGet(RequestsTopicRequest<FlightAreasGetRequest> request, MessageHeaders headers) throws RestException {
        log.error("the service of [flightAreasGet] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("flightAreasGet not implemented.");
    }
}
