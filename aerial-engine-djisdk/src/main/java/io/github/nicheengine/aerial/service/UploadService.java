package io.github.nicheengine.aerial.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.enums.upload.LoggingMethod;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.model.upload.*;
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
public abstract class UploadService {

    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = EventsChannels.INBOUND_EVENTS_FILEUPLOAD_PROGRESS, outputChannel = DjisdkChannels.OUTBOUND_EVENTS)
    public EventsTopicResponse<MqttReplyResult<?>> fileUploadProgress(EventsTopicRequest<MqttErrorRequest<UploadProgress>> request, MessageHeaders headers) throws RestException {
        log.error("the service of [fileUploadProgress] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("fileUploadProgress not implemented.");
    }

    public ServicesTopicResponse<MqttErrorRequest<UploadListResponse>> fileUploadList(GatewayManager gateway, UploadListRequest request) throws RestException {
        return servicesPublish.publish(new TypeReference<UploadListResponse>() {}, gateway.getGatewaySn(), LoggingMethod.FILE_UPLOAD_LIST.getMethod(), request);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> fileUploadStart(GatewayManager gateway, UploadStartRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), LoggingMethod.FILE_UPLOAD_START.getMethod(), request);
    }

    public ServicesTopicResponse<MqttErrorRequest<?>> fileUploadUpdate(GatewayManager gateway, UploadUpdateRequest request) throws RestException {
        return servicesPublish.publish(gateway.getGatewaySn(), LoggingMethod.FILE_UPLOAD_UPDATE.getMethod(), request);
    }
}
