package io.github.nicheengine.aerial.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.DebugMethod;
import io.github.nicheengine.aerial.enums.method.LiveStreamMethod;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.debug.RemoteDebugResponse;
import io.github.nicheengine.aerial.model.device.drone.DroneLiveCapacity;
import io.github.nicheengine.aerial.model.livestream.LiveLensChangeRequest;
import io.github.nicheengine.aerial.model.livestream.LiveSetQualityRequest;
import io.github.nicheengine.aerial.model.livestream.LiveStartPushRequest;
import io.github.nicheengine.aerial.model.livestream.LiveStopPushRequest;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.StateChannels;
import io.github.nicheengine.aerial.mqtt.services.ServicesPublish;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nicheengine.aerial.mqtt.state.StateTopicRequest;
import io.github.nicheengine.aerial.mqtt.state.StateTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

@Slf4j
public abstract class LivestreamService {

    @Resource
    private ServicesPublish servicesPublish;

    private static final long DEFAULT_TIMEOUT = 20_000;

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_LIVE_CAPACITY)
    public StateTopicResponse<MqttReplyResult<?>> droneLiveCapacity(StateTopicRequest<DroneLiveCapacity> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneLiveCapacity] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("droneLiveCapacity not implemented.");
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<RemoteDebugResponse>> debugModeOpen(GatewayManager gateway) throws RestException {
        return servicesPublish.publish(new TypeReference<RemoteDebugResponse>() {}, gateway.getGatewaySn(), DebugMethod.DEBUG_MODE_OPEN.getMethod());
    }

    public ServicesTopicResponse<MqttErrorRequest<String>> liveStartPush(GatewayManager gateway, LiveStartPushRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<String>() {}, gateway.getGatewaySn(), LiveStreamMethod.LIVE_START_PUSH.getMethod(), request, DEFAULT_TIMEOUT);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> liveStopPush(GatewayManager gateway, LiveStopPushRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), LiveStreamMethod.LIVE_STOP_PUSH.getMethod(), request, DEFAULT_TIMEOUT);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> liveSetQuality(GatewayManager gateway, LiveSetQualityRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), LiveStreamMethod.LIVE_SET_QUALITY.getMethod(), request, DEFAULT_TIMEOUT);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> liveLensChange(GatewayManager gateway, LiveLensChangeRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), LiveStreamMethod.LIVE_LENS_CHANGE.getMethod(), request, DEFAULT_TIMEOUT);
    }
}
