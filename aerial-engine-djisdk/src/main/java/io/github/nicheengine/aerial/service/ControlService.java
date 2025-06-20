package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.control.ControlMethod;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.control.camera.CameraAimRequest;
import io.github.nicheengine.aerial.mqtt.MqttErrorReply;
import io.github.nicheengine.aerial.mqtt.MqttResultReply;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.DrcUpChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.drc.DrcDownPublish;
import io.github.nicheengine.aerial.mqtt.drc.DrcUpData;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.mqtt.services.ServicesPublish;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public abstract class ControlService {

    @Resource
    private ServicesPublish servicesPublish;

    @Resource
    private DrcDownPublish drcDownPublish;
   
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FLY_TO_POINT_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttResultReply<?>> flyToPointProgress(EventsTopicRequest<FlyToPointProgress> request, MessageHeaders headers) {
        log.error("the service of [flyToPointProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("flyToPointProgress not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_TAKEOFF_TO_POINT_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttResultReply<?>> takeoffToPointProgress(EventsTopicRequest<TakeoffToPointProgress> request, MessageHeaders headers) {
        log.error("the service of [takeoffToPointProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("takeoffToPointProgress not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_DRC_STATUS_NOTIFY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttResultReply<?>> drcStatusNotify(EventsTopicRequest<DrcStatusNotify> request, MessageHeaders headers) {
        log.error("the service of [drcStatusNotify] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("drcStatusNotify not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_JOYSTICK_INVALID_NOTIFY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttResultReply<?>> joystickInvalidNotify(EventsTopicRequest<JoystickInvalidNotify> request, MessageHeaders headers) {
        log.error("the service of [joystickInvalidNotify] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("joystickInvalidNotify not implemented.");
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> flightAuthorityGrab(GatewayManager gateway) throws AerialMqttErrorException {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.FLIGHT_AUTHORITY_GRAB.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> payloadAuthorityGrab(GatewayManager gateway, PayloadAuthorityGrabRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.PAYLOAD_AUTHORITY_GRAB.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> drcModeEnter(GatewayManager gateway, DrcModeEnterRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.DRC_MODE_ENTER.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> drcModeExit(GatewayManager gateway) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.DRC_MODE_EXIT.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> takeoffToPoint(GatewayManager gateway, TakeoffToPointRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.TAKEOFF_TO_POINT.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> flyToPoint(GatewayManager gateway, FlyToPointRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.FLY_TO_POINT.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> flyToPointUpdate(GatewayManager gateway, FlyToPointUpdateRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.FLY_TO_POINT_UPDATE.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> flyToPointStop(GatewayManager gateway) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.FLY_TO_POINT_STOP.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraModeSwitch(GatewayManager gateway, CameraModeSwitchRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_MODE_SWITCH.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraPhotoTake(GatewayManager gateway, CameraPhotoTakeRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_PHOTO_TAKE.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraPhotoStop(GatewayManager gateway, CameraPhotoStopRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_PHOTO_STOP.getMethod(),
                request);
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_CAMERA_PHOTO_TAKE_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttResultReply<?>> cameraPhotoTakeProgress(EventsTopicRequest<EventsDataRequest<CameraPhotoTakeProgress>> request, MessageHeaders headers) {
        log.error("the service of [cameraPhotoTakeProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("cameraPhotoTakeProgress not implemented.");
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraRecordingStart(GatewayManager gateway, CameraRecordingStartRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_RECORDING_START.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraRecordingStop(GatewayManager gateway, CameraRecordingStopRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_RECORDING_STOP.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraAim(GatewayManager gateway, CameraAimRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_AIM.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraFocalLengthSet(GatewayManager gateway, CameraFocalLengthSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_FOCAL_LENGTH_SET.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraScreenDrag(GatewayManager gateway, CameraScreenDragRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_SCREEN_DRAG.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> gimbalReset(GatewayManager gateway, GimbalResetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.GIMBAL_RESET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraLookAt(GatewayManager gateway, CameraLookAtRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_LOOK_AT.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraScreenSplit(GatewayManager gateway, CameraScreenSplitRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_SCREEN_SPLIT.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> photoStorageSet(GatewayManager gateway, PhotoStorageSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.PHOTO_STORAGE_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorReply<?>> videoStorageSet(GatewayManager gateway, VideoStorageSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.VIDEO_STORAGE_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraExposureSet(GatewayManager gateway, CameraExposureSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_EXPOSURE_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraExposureModeSet(GatewayManager gateway, CameraExposureModeSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_EXPOSURE_MODE_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraFocusModeSet(GatewayManager gateway, CameraFocusModeSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_FOCUS_MODE_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraFocusValueSet(GatewayManager gateway, CameraFocusValueSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_FOCUS_VALUE_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> irMeteringModeSet(GatewayManager gateway, IrMeteringModeSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.IR_METERING_MODE_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> irMeteringPointSet(GatewayManager gateway, IrMeteringPointSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.IR_METERING_POINT_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> irMeteringAreaSet(GatewayManager gateway, IrMeteringAreaSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.IR_METERING_AREA_SET.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> cameraPointFocusAction(GatewayManager gateway, CameraPointFocusActionRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.CAMERA_POINT_FOCUS_ACTION.getMethod(),
                request);
    }

    public ServicesTopicResponse<MqttErrorReply<?>> payloadControl(GatewayManager gateway, PayloadControlMethod methodEnum, BaseModel request) {
        try {
            AbstractControlService abstractControlService = SpringBeanUtils.getBean(this.getClass());
            Method method = abstractControlService.getClass().getDeclaredMethod(
                    Common.convertSnake(methodEnum.getPayloadMethod().getMethod()),GatewayManager.class, methodEnum.getClazz());
            return (ServicesTopicResponse<MqttErrorReply<?>>) method.invoke(abstractControlService, gateway, request);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new CloudSDKException(e);
        } catch (InvocationTargetException e) {
            throw new CloudSDKException(e.getTargetException());
        }
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_POI_STATUS_NOTIFY, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public EventsTopicResponse<MqttResultReply<?>> poiStatusNotify(EventsTopicRequest<PoiStatusNotify> request, MessageHeaders headers) {
        log.error("the service of [poiStatusNotify] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("poiStatusNotify not implemented.");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> poiModeEnter(GatewayManager gateway, PoiModeEnterRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.POI_MODE_ENTER.getMethod(),
                request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> poiModeExit(GatewayManager gateway) throws AerialMqttErrorException {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.POI_MODE_EXIT.getMethod());
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorReply<?>> poiCircleSpeedSet(GatewayManager gateway, PoiCircleSpeedSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.POI_CIRCLE_SPEED_SET.getMethod(),
                request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    protected void droneControlDown(GatewayManager gateway, DroneControlRequest request) {
        drcDownPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.DRONE_CONTROL.getMethod(),
                request);
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_DRONE_CONTROL)
    public void droneControlUp(TopicDrcRequest<DrcUpData<DroneControlResponse>> request, MessageHeaders headers) {
        log.error("the service of [droneControlUp] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("droneControlUp not implemented.");
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public void droneEmergencyStopDown(GatewayManager gateway) {
        drcDownPublish.publish(gateway.getGatewaySn(), ControlMethod.DRONE_EMERGENCY_STOP.getMethod());
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_DRONE_EMERGENCY_STOP)
    public void droneEmergencyStopUp(TopicDrcRequest<DrcUpData> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("droneEmergencyStopUp not implemented");
    }


    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public void heartBeatDown(GatewayManager gateway, HeartBeatRequest request) {
        drcDownPublish.publish(
                gateway.getGatewaySn(),
                ControlMethod.HEART_BEAT.getMethod(),
                request);
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_HEART_BEAT)
    public void heartBeatUp(DrcTopicRequest<HeartBeatRequest> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("heartBeatUp not implemented");
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_HSI_INFO_PUSH)
    public void hsiInfoPush(DrcTopicRequest<HsiInfoPush> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("hsiInfoPush not implemented");
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_DELAY_INFO_PUSH)
    public void delayInfoPush(DrcTopicRequest<DelayInfoPush> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("delayInfoPush not implemented");
    }

    @ServiceActivator(inputChannel = DrcUpChannels.INBOUND_DRC_UP_OSD_INFO_PUSH)
    public void osdInfoPush(DrcTopicRequest<OsdInfoPush> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("osdInfoPush not implemented");
    }

}
