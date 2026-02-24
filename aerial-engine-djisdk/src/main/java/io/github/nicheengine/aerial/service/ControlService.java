package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.ControlMethod;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.control.*;
import io.github.nicheengine.aerial.model.control.camera.*;
import io.github.nicheengine.aerial.model.control.flyto.FlyToPointProgress;
import io.github.nicheengine.aerial.model.control.flyto.FlyToPointRequest;
import io.github.nicheengine.aerial.model.control.flyto.FlyToPointUpdateRequest;
import io.github.nicheengine.aerial.model.control.info.DelayInfoPush;
import io.github.nicheengine.aerial.model.control.info.HsiInfoPush;
import io.github.nicheengine.aerial.model.control.info.OsdInfoPush;
import io.github.nicheengine.aerial.model.control.point.PoiCircleSpeedSetRequest;
import io.github.nicheengine.aerial.model.control.point.PoiModeEnterRequest;
import io.github.nicheengine.aerial.model.control.point.PoiStatusNotify;
import io.github.nicheengine.aerial.model.control.takeoff.TakeoffToPointProgress;
import io.github.nicheengine.aerial.model.control.takeoff.TakeoffToPointRequest;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.DrcUpChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.drc.DrcDownPublish;
import io.github.nicheengine.aerial.mqtt.drc.DrcTopicRequest;
import io.github.nicheengine.aerial.mqtt.drc.DrcUpData;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
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
public abstract class ControlService {

    @Resource
    private ServicesPublish servicesPublish;

    @Resource
    private DrcDownPublish drcDownPublish;
   
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FLY_TO_POINT_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> flyToPointProgress(EventsTopicRequest<FlyToPointProgress> request, MessageHeaders headers) throws RestException {
        log.error("the service of [flyToPointProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("flyToPointProgress not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_TAKEOFF_TO_POINT_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> takeoffToPointProgress(EventsTopicRequest<TakeoffToPointProgress> request, MessageHeaders headers) throws RestException {
        log.error("the service of [takeoffToPointProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("takeoffToPointProgress not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_DRC_STATUS_NOTIFY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> drcStatusNotify(EventsTopicRequest<DrcStatusNotify> request, MessageHeaders headers) throws RestException {
        log.error("the service of [drcStatusNotify] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("drcStatusNotify not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_JOYSTICK_INVALID_NOTIFY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> joystickInvalidNotify(EventsTopicRequest<JoystickInvalidNotify> request, MessageHeaders headers) throws RestException {
        log.error("the service of [joystickInvalidNotify] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("joystickInvalidNotify not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_CAMERA_PHOTO_TAKE_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> cameraPhotoTakeProgress(EventsTopicRequest<MqttErrorRequest<CameraPhotoTakeProgress>> request, MessageHeaders headers) throws RestException {
        log.error("the service of [cameraPhotoTakeProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("cameraPhotoTakeProgress not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_POI_STATUS_NOTIFY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    @DjisdkVersion(since = CloudsdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public EventsTopicResponse<MqttReplyResult<?>> poiStatusNotify(EventsTopicRequest<PoiStatusNotify> request, MessageHeaders headers) throws RestException {
        log.error("the service of [poiStatusNotify] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("poiStatusNotify not implemented.");
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flightAuthorityGrab(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.FLIGHT_AUTHORITY_GRAB.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> payloadAuthorityGrab(GatewayManager gateway, PayloadAuthorityGrabRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.PAYLOAD_AUTHORITY_GRAB.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> drcModeEnter(GatewayManager gateway, DrcEnterRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.DRC_MODE_ENTER.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> drcModeExit(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.DRC_MODE_EXIT.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> takeoffToPoint(GatewayManager gateway, TakeoffToPointRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.TAKEOFF_TO_POINT.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flyToPoint(GatewayManager gateway, FlyToPointRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.FLY_TO_POINT.getMethod(), request);
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> flyToPointUpdate(GatewayManager gateway, FlyToPointUpdateRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.FLY_TO_POINT_UPDATE.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> flyToPointStop(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.FLY_TO_POINT_STOP.getMethod());
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> poiModeEnter(GatewayManager gateway, PoiModeEnterRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.POI_MODE_ENTER.getMethod(), request);
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> poiModeExit(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.POI_MODE_EXIT.getMethod());
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> poiCircleSpeedSet(GatewayManager gateway, PoiCircleSpeedSetRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.POI_CIRCLE_SPEED_SET.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    protected void droneControlDown(GatewayManager gateway, DroneControlRequest request) throws RestException {
        drcDownPublish.publish(gateway.getGatewaySn(), ControlMethod.DRONE_CONTROL.getMethod(), request);
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_DRONE_CONTROL)
    public void droneControlUp(DrcTopicRequest<DrcUpData<DroneControlResponse>> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneControlUp] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneControlUp not implemented.");
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public void droneEmergencyStopDown(GatewayManager gateway) throws RestException {
        drcDownPublish.publish(gateway.getGatewaySn(), ControlMethod.DRONE_EMERGENCY_STOP.getMethod());
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_DRONE_EMERGENCY_STOP)
    public void droneEmergencyStopUp(DrcTopicRequest<DrcUpData<?>> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneEmergencyStopUp] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneEmergencyStopUp not implemented.");
    }


    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public void heartBeatDown(GatewayManager gateway, HeartBeatRequest request) throws RestException {
        drcDownPublish.publish(gateway.getGatewaySn(), ControlMethod.HEART_BEAT.getMethod(), request);
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_HEART_BEAT)
    public void heartBeatUp(DrcTopicRequest<HeartBeatRequest> request, MessageHeaders headers) throws RestException {
        log.error("the service of [heartBeatUp] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("heartBeatUp not implemented.");
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_HSI_INFO_PUSH)
    public void hsiInfoPush(DrcTopicRequest<HsiInfoPush> request, MessageHeaders headers) throws RestException {
        log.error("the service of [hsiInfoPush] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("hsiInfoPush not implemented.");
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_DELAY_INFO_PUSH)
    public void delayInfoPush(DrcTopicRequest<DelayInfoPush> request, MessageHeaders headers) throws RestException {
        log.error("the service of [delayInfoPush] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("delayInfoPush not implemented.");
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_OSD_INFO_PUSH)
    public void osdInfoPush(DrcTopicRequest<OsdInfoPush> request, MessageHeaders headers) throws RestException {
        log.error("the service of [osdInfoPush] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("osdInfoPush not implemented.");
    }

}
