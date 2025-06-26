package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.method.MediaMethod;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.OssfileCredentialsResponse;
import io.github.nicheengine.aerial.model.media.FileUploadCallback;
import io.github.nicheengine.aerial.model.media.HighestPriorityUploadFlightTaskMedia;
import io.github.nicheengine.aerial.model.media.StorageConfigGet;
import io.github.nicheengine.aerial.model.media.UploadFlighttaskMediaPrioritize;
import io.github.nicheengine.aerial.mqtt.MqttErrorRequest;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.EventsChannels;
import io.github.nicheengine.aerial.mqtt.channel.RequestsChannels;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicRequest;
import io.github.nicheengine.aerial.mqtt.events.EventsTopicResponse;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicRequest;
import io.github.nicheengine.aerial.mqtt.requests.RequestsTopicResponse;
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
public abstract class MediaService {

    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FILE_UPLOAD_CALLBACK, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> fileUploadCallback(EventsTopicRequest<FileUploadCallback> request, MessageHeaders headers) throws RestException {
        log.error("the service of [fileUploadCallback] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("fileUploadCallback not implemented.");
    }

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_HIGHEST_PRIORITY_UPLOAD_FLIGHT_TASK_MEDIA, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> highestPriorityUploadFlightTaskMedia(EventsTopicRequest<HighestPriorityUploadFlightTaskMedia> request, MessageHeaders headers) throws RestException  {
        log.error("the service of [highestPriorityUploadFlightTaskMedia] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("highestPriorityUploadFlightTaskMedia not implemented.");
    }

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public ServicesTopicResponse<MqttErrorRequest<?>> uploadFlighttaskMediaPrioritize(GatewayManager gateway, UploadFlighttaskMediaPrioritize request) throws RestException  {
        return servicesPublish.publish(gateway.getGatewaySn(), MediaMethod.UPLOAD_FLIGHTTASK_MEDIA_PRIORITIZE.getMethod(), request);
    }

    @ServiceActivator(inputChannel = RequestsChannels.INBOUND_REQUESTS_STORAGE_CONFIG_GET, outputChannel = DjisdkChannels.OUTBOUND_REQUESTS)
    public RequestsTopicResponse<MqttReplyResult<OssfileCredentialsResponse>> storageConfigGet(RequestsTopicRequest<StorageConfigGet> request, MessageHeaders headers) throws RestException  {
        log.error("the service of [storageConfigGet] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JsonPurityUtils.parseJson(request), JsonPurityUtils.parseJson(headers));
        throw new MethodLackError("storageConfigGet not implemented.");
    }
}
