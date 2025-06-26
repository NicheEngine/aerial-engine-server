package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.model.hmsinfo.HmsInfo;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

@Slf4j
public abstract class HmsService {

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_HMS)
    public void hmsInfo(EventsTopicRequest<HmsInfo> request, MessageHeaders headers) throws RestException {
        log.error("the service of [hmsInfo] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("hmsInfo not implemented.");
    }
}
