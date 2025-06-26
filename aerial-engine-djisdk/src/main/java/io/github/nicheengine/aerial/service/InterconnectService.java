package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.InterconnectMethod;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.interconnect.CustomDataTransmissionFromEsdk;
import io.github.nicheengine.aerial.model.interconnect.CustomDataTransmissionToEsdkRequest;
import io.github.nicheengine.aerial.model.interconnect.CustomDataTransmissionToPsdkRequest;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.mqtt.services.ServicesPublish;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

@Slf4j
public abstract class InterconnectService {

    @Resource
    private ServicesPublish servicesPublish;

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_CUSTOM_DATA_TRANSMISSION_FROM_ESDK, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> customDataTransmissionFromEsdk(EventsTopicRequest<CustomDataTransmissionFromEsdk> request, MessageHeaders headers) throws RestException {
        log.error("the service of [customDataTransmissionFromEsdk] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("customDataTransmissionFromEsdk not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_CUSTOM_DATA_TRANSMISSION_FROM_PSDK, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> customDataTransmissionFromPsdk(EventsTopicRequest<CustomDataTransmissionFromEsdk> request, MessageHeaders headers) throws RestException {
        log.error("the service of [customDataTransmissionFromPsdk] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("customDataTransmissionFromPsdk not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> customDataTransmissionToEsdk(GatewayManager gateway, CustomDataTransmissionToEsdkRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), InterconnectMethod.CUSTOM_DATA_TRANSMISSION_TO_ESDK.getMethod(), request);
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0, exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> customDataTransmissionToPsdk(GatewayManager gateway, CustomDataTransmissionToPsdkRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), InterconnectMethod.CUSTOM_DATA_TRANSMISSION_TO_PSDK.getMethod(), request);
    }
}
