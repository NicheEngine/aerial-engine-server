package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.model.airsense.AirsenseWarning;
import io.github.nicheengine.aerial.mqtt.MqttResultReply;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import java.util.List;

@Slf4j
public abstract class AirsenseService {

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_AIRSENSE_WARNING, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    public EventsTopicResponse<MqttResultReply<?>> airsenseWarning(EventsTopicRequest<List<AirsenseWarning>> request, MessageHeaders headers) {
        log.error("the service of [airsenseWarning] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("airsenseWarning not implemented.");
    }
}
