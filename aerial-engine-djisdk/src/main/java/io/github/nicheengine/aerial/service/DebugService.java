package io.github.nicheengine.aerial.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.DebugMethod;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.status.EngineErrorStatus;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.debug.*;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.mqtt.services.ServicesPublish;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.error.lack.BeanLackError;
import io.github.nichetoolkit.rest.error.lack.ClassLackError;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class DebugService {

    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_CONTROL_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> remoteDebugProgress(EventsTopicRequest<MqttErrorRequest<RemoteDebugProgress>> request, MessageHeaders headers) throws RestException {
        log.error("the service of [remoteDebugProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("remoteDebugProgress not implemented.");
    }

    @SuppressWarnings("unchecked")
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> remoteDebug(GatewayManager gateway, DebugMethod debugMethod, AerialDjisdkModel djisdkModel) throws AerialServerErrorException, AerialMqttErrorException {
        DebugService debugService = BeanUtils.beanOfType(this.getClass());
        if (GeneralUtils.isEmpty(debugService)) {
            log.error("the debug service of [{}] is no found.", this.getClass().getSimpleName());
            throw new BeanLackError("debugService not found.");
        }
        if (DebugMethod.UNKNOWN == debugMethod) {
            log.error("the method of debug is unknown.");
            throw new MethodLackError("debugMethod is unknown.");
        }
        String parsedMethod = MqttPayloadHelper.parseMethod(debugMethod.getMethod());
        Class<? extends AerialDjisdkModel> methodType = debugMethod.getType();
        Class<? extends AerialDjisdkModel> modelType = djisdkModel.getClass();
        if (GeneralUtils.isNotEmpty(debugMethod) && !methodType.isAssignableFrom(modelType)) {
            log.error("the class type of [{}] is not required type. expected: {}, provided: {}", parsedMethod, methodType.getSimpleName(), modelType.getSimpleName());
            throw new ClassLackError("modelType is not required.");
        }
        List<Class<?>> argsTypes = new ArrayList<>();
        argsTypes.add(GatewayManager.class);
        List<Object> argParams = new ArrayList<>();
        argParams.add(gateway);
        RestOptional.ofNullable(djisdkModel).ifNotNull((body) -> {
            argsTypes.add(body.getClass());
            argParams.add(body);
        });
        try {
            Method method = debugService.getClass().getDeclaredMethod(parsedMethod, argsTypes.toArray(new Class[0]));
            return (ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>>) method.invoke(debugService, argParams);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            log.error("the method of [{}] invoke with error, error: {}, \n===> request: {}", parsedMethod, exception.getMessage(), JacksonUtils.parseJson(djisdkModel));
            throw new AerialServerErrorException(EngineErrorStatus.AERIAL_UNSUPPORTED_ERROR,exception);
        }
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> debugModeOpen(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DEBUG_MODE_OPEN.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> debugModeClose(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DEBUG_MODE_CLOSE.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> supplementLightOpen(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.SUPPLEMENT_LIGHT_OPEN.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> supplementLightClose(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.SUPPLEMENT_LIGHT_CLOSE.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> batteryMaintenanceSwitch(GatewayManager gateway, BatteryMaintenanceSwitchRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.BATTERY_MAINTENANCE_SWITCH.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> airConditionerModeSwitch(GatewayManager gateway, AirConditionerModeSwitchRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.AIR_CONDITIONER_MODE_SWITCH.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> alarmStateSwitch(GatewayManager gateway, AlarmStateSwitchRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.ALARM_STATE_SWITCH.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> batteryStoreModeSwitch(GatewayManager gateway, BatteryStoreModeSwitchRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.BATTERY_STORE_MODE_SWITCH.getMethod(), request);
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> deviceReboot(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DEVICE_REBOOT.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> droneOpen(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DRONE_OPEN.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> droneClose(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DRONE_CLOSE.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> deviceFormat(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DEVICE_FORMAT.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> droneFormat(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DRONE_FORMAT.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> coverOpen(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.COVER_OPEN.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> coverClose(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.COVER_CLOSE.getMethod());
    }

    @DjisdkVersion(exclude = {GatewayThing.REMOTER_CONTROL, GatewayThing.DOCK2, GatewayThing.DOCK3})
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> putterOpen(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.PUTTER_OPEN.getMethod());
    }

    @DjisdkVersion(exclude = {GatewayThing.REMOTER_CONTROL, GatewayThing.DOCK2, GatewayThing.DOCK3})
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> putterClose(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.PUTTER_CLOSE.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> chargeOpen(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.CHARGE_OPEN.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> chargeClose(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.CHARGE_CLOSE.getMethod());
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> sdrWorkmodeSwitch(GatewayManager gateway, SdrWorkmodeSwitchRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.SDR_WORKMODE_SWITCH.getMethod(), request);
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2, GatewayThing.DOCK3})
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> esimActivate(GatewayManager gateway, EsimActivateRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.ESIM_ACTIVATE.getMethod(), request);
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2, GatewayThing.DOCK3})
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> simSlotSwitch(GatewayManager gateway, SimSlotSwitchRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.SIM_SLOT_SWITCH.getMethod(), request);
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2, GatewayThing.DOCK3})
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> esimOperatorSwitch(GatewayManager gateway, EsimOperatorSwitchRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.ESIM_OPERATOR_SWITCH.getMethod(), request);
    }
}
