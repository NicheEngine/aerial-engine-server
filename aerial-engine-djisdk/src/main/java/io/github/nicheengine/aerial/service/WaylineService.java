package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.WaylineMethod;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.enums.wayline.TaskType;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.wayline.*;
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
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

@Slf4j
public abstract class WaylineService {

    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_DEVICE_EXIT_HOMING_NOTIFY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> deviceExitHomingNotify(EventsTopicRequest<DeviceExitHomingNotify> request, MessageHeaders headers) throws RestException {
        log.error("the service of [deviceExitHomingNotify] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("deviceExitHomingNotify not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FLIGHTTASK_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>>  flighttaskProgress(EventsTopicRequest<MqttErrorRequest<FlighttaskProgress>> request, MessageHeaders headers) throws RestException {
        log.error("the service of [flighttaskProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("flighttaskProgress not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FLIGHTTASK_READY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>>  flighttaskReady(EventsTopicRequest<FlighttaskReady> request, MessageHeaders headers) throws RestException {
        log.error("the service of [flighttaskReady] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("flighttaskReady not implemented.");
    }

    @DjisdkVersion(deprecated = CloudsdkVersion.V0_0_1, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flighttaskCreate(GatewayManager gateway, FlighttaskCreateRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.FLIGHTTASK_CREATE.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flighttaskPrepare(GatewayManager gateway, FlighttaskPrepareRequest request) throws RestException {
        validPrepareParam(request);
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.FLIGHTTASK_PREPARE.getMethod(), request, request.getFlightId());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flighttaskExecute(GatewayManager gateway, FlighttaskExecuteRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.FLIGHTTASK_EXECUTE.getMethod(), request, request.getFlightId());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flighttaskUndo(GatewayManager gateway, FlighttaskUndoRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.FLIGHTTASK_UNDO.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flighttaskPause(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.FLIGHTTASK_PAUSE.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flighttaskRecovery(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.FLIGHTTASK_RECOVERY.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> returnHome(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.RETURN_HOME.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> returnHomeCancel(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), WaylineMethod.RETURN_HOME_CANCEL.getMethod());
    }

    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_FLIGHTTASK_RESOURCE_GET, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<MqttReplyResult<FlighttaskResourceGetResponse>> flighttaskResourceGet(RequestsTopicRequest<FlighttaskResourceGetRequest> request, MessageHeaders headers) throws RestException {
        log.error("the service of [flighttaskResourceGet] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("flighttaskResourceGet not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_RETURN_HOME_INFO, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public RequestsTopicResponse<MqttReplyResult<?>> returnHomeInfo(RequestsTopicRequest<ReturnHomeInfo> request, MessageHeaders headers) throws RestException {
        log.error("the service of [returnHomeInfo] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("returnHomeInfo not implemented.");
    }

    private void validPrepareParam(FlighttaskPrepareRequest request) throws RestException {
        if (GeneralUtils.isNotEmpty(request.getExecuteTime()) && (TaskType.IMMEDIATE == request.getTaskType() || TaskType.TIMED == request.getTaskType())) {
            throw new AerialServerErrorException(DjisdkErrorStatus.AERIAL_PARAM_ERROR,"executeTime");
        }
        if (TaskType.CONDITIONAL == request.getTaskType()) {
            AerialDjisdkModel.ofVerify(request.getReadyConditions());
        }
    }

}
