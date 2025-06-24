package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.ControlMethod;
import io.github.nicheengine.aerial.enums.method.PayloadMethod;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.control.GimbalResetRequest;
import io.github.nicheengine.aerial.model.control.VideoStorageSetRequest;
import io.github.nicheengine.aerial.model.control.camera.*;
import io.github.nicheengine.aerial.model.control.irmetering.IrMeteringAreaSetRequest;
import io.github.nicheengine.aerial.model.control.irmetering.IrMeteringModeSetRequest;
import io.github.nicheengine.aerial.model.control.irmetering.IrMeteringPointSetRequest;
import io.github.nicheengine.aerial.model.control.photo.PhotoStorageSetRequest;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.services.ServicesPublish;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.error.lack.BeanLackError;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@Slf4j
public abstract class PayloadService {

    @Resource
    private ServicesPublish servicesPublish;

    @SuppressWarnings("unchecked")
    public ServicesTopicResponse<MqttErrorRequest<?>> payloadControl(GatewayManager gateway, PayloadMethod payloadMethod, AerialDjisdkModel request) throws AerialServerErrorException, AerialMqttErrorException {
        PayloadService payloadService = BeanUtils.beanOfType(this.getClass());
        if (GeneralUtils.isEmpty(payloadService)) {
            log.error("the payload control service of [{}] is no found.", this.getClass().getSimpleName());
            throw new BeanLackError("payloadService not found.");
        }
        if (PayloadMethod.UNKNOWN == payloadMethod) {
            log.error("the method of payload control is unknown.");
            throw new MethodLackError("payloadMethod is unknown.");
        }
        String parsedMethod = MqttPayloadHelper.parseMethod(payloadMethod.getPayloadMethod().getMethod());
        try {
            Method method = payloadService.getClass().getDeclaredMethod(parsedMethod, GatewayManager.class, payloadMethod.getType());
            return (ServicesTopicResponse<MqttErrorRequest<?>>) method.invoke(payloadService, gateway, request);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            log.error("the method of [{}] invoke with error, error: {}, \n===> request: {}", parsedMethod, exception.getMessage(), JsonPurityUtils.parseJson(request));
            throw new AerialServerErrorException(DjisdkErrorStatus.AERIAL_UNSUPPORTED_ERROR,exception);
        }
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraModeSwitch(GatewayManager gateway, CameraModeSwitchRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_MODE_SWITCH.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraPhotoTake(GatewayManager gateway, CameraPhotoTakeRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_PHOTO_TAKE.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, exclude = GatewayThing.REMOTER_CONTROL, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraPhotoStop(GatewayManager gateway, CameraPhotoStopRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_PHOTO_STOP.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraRecordingStart(GatewayManager gateway, CameraRecordingStartRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_RECORDING_START.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraRecordingStop(GatewayManager gateway, CameraRecordingStopRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_RECORDING_STOP.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraAim(GatewayManager gateway, CameraAimRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_AIM.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraFocalLengthSet(GatewayManager gateway, CameraFocalLengthSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_FOCAL_LENGTH_SET.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraScreenDrag(GatewayManager gateway, CameraScreenDragRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_SCREEN_DRAG.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> gimbalReset(GatewayManager gateway, GimbalResetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.GIMBAL_RESET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraLookAt(GatewayManager gateway, CameraLookAtRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_LOOK_AT.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraScreenSplit(GatewayManager gateway, CameraScreenSplitRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_SCREEN_SPLIT.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> photoStorageSet(GatewayManager gateway, PhotoStorageSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.PHOTO_STORAGE_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> videoStorageSet(GatewayManager gateway, VideoStorageSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.VIDEO_STORAGE_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraExposureSet(GatewayManager gateway, CameraExposureSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_EXPOSURE_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraExposureModeSet(GatewayManager gateway, CameraExposureModeSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_EXPOSURE_MODE_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraFocusModeSet(GatewayManager gateway, CameraFocusModeSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_FOCUS_MODE_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraFocusValueSet(GatewayManager gateway, CameraFocusValueSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_FOCUS_VALUE_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> irMeteringModeSet(GatewayManager gateway, IrMeteringModeSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.IR_METERING_MODE_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> irMeteringPointSet(GatewayManager gateway, IrMeteringPointSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.IR_METERING_POINT_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> irMeteringAreaSet(GatewayManager gateway, IrMeteringAreaSetRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.IR_METERING_AREA_SET.getMethod(), request);
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    public ServicesTopicResponse<MqttErrorRequest<?>> cameraPointFocusAction(GatewayManager gateway, CameraPointFocusActionRequest request) throws AerialMqttErrorException {
        return servicesPublish.publish(gateway.getGatewaySn(), ControlMethod.CAMERA_POINT_FOCUS_ACTION.getMethod(), request);
    }

}
