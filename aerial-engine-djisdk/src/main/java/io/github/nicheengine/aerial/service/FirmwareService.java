package io.github.nicheengine.aerial.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.enums.method.FirmwareMethod;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.firmware.OtaCreateRequest;
import io.github.nicheengine.aerial.model.firmware.OtaCreateResponse;
import io.github.nicheengine.aerial.model.firmware.OtaProgress;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.mqtt.services.ServicesPublish;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

@Slf4j
public abstract class FirmwareService {
    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_OTA_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> otaProgress(EventsTopicRequest<MqttErrorRequest<OtaProgress>> request, MessageHeaders headers) throws RestException {
        log.error("the service of [otaProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("otaProgress not implemented.");
    }

    public ServicesTopicResponse<MqttErrorRequest<OtaCreateResponse>> otaCreate(GatewayManager gateway, OtaCreateRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<OtaCreateResponse>() {}, gateway.getGatewaySn(), FirmwareMethod.OTA_CREATE.getMethod(), request);
    }
}
