package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.OfflineMapMethod;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.device.drone.DroneOfflineMapEnable;
import io.github.nicheengine.aerial.model.offlinemap.OfflineMapGetRequest;
import io.github.nicheengine.aerial.model.offlinemap.OfflineMapGetResponse;
import io.github.nicheengine.aerial.model.offlinemap.OfflineMapSyncProgress;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.channel.RequestsChannels;
import io.github.nicheengine.aerial.mqtt.channel.StateChannels;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicRequest;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicResponse;
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
public abstract class OfflineMapService {

    @Resource
    private ServicesPublish servicesPublish;

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2, GatewayThing.DOCK3})
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_OFFLINE_MAP_ENABLE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneOfflineMapEnable(StateTopicRequest<DroneOfflineMapEnable> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneOfflineMapEnable] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("droneOfflineMapEnable not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2, GatewayThing.DOCK3})
    public ServicesTopicResponse<MqttErrorRequest<?>> offlineMapUpdate(GatewayManager gateway) throws RestException  {
        return servicesPublish.publish(gateway.getGatewaySn(), OfflineMapMethod.OFFLINE_MAP_UPDATE.getMethod());
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2, GatewayThing.DOCK3})
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_OFFLINE_MAP_SYNC_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public RequestsTopicResponse<MqttReplyResult<?>> offlineMapSyncProgress(RequestsTopicRequest<OfflineMapSyncProgress> request, MessageHeaders headers) throws RestException {
        log.error("the service of [offlineMapSyncProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("offlineMapSyncProgress not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2, GatewayThing.DOCK3})
    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_OFFLINE_MAP_GET, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<MqttReplyResult<OfflineMapGetResponse>> offlineMapGet(RequestsTopicRequest<OfflineMapGetRequest> request, MessageHeaders headers) throws RestException {
        log.error("the service of [offlineMapGet] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("offlineMapGet not implemented.");
    }
}
