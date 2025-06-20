package io.github.nicheengine.aerial.router;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.configure.AerialMqttProperties;
import io.github.nicheengine.aerial.enums.logging.LoggingMethod;
import io.github.nicheengine.aerial.model.FileUploadListResponse;
import io.github.nicheengine.aerial.mqtt.MqttChannelFactory;
import io.github.nicheengine.aerial.mqtt.MqttPayloadHelper;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.services.ServicesReceiver;
import io.github.nicheengine.aerial.mqtt.services.ServicesTopicResponse;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqttServicesReply {

    private final AerialMqttProperties mqttProperties;

    @Autowired
    public MqttServicesReply(AerialMqttProperties mqttProperties) {
        this.mqttProperties = mqttProperties;
        log.debug("The mqtt flow router for [router@/services/reply] initiated");
    }

    @ServiceActivator(inputChannel = DjisdkChannels.INBOUND_PROPERTY_SET_REPLY)
    public void propertySetReply(Message<?> source) {
        ServicesTopicResponse<ServicesReceiver<Object>> topicResponse = MqttPayloadHelper.parsePayload(source,mqttProperties,new TypeReference<ServicesTopicResponse<ServicesReceiver<Object>>>() {
        });
        MqttChannelFactory channelFactory = MqttChannelFactory.instance(topicResponse.getTid(), false);
        if (GeneralUtils.isNotEmpty(channelFactory) ) {
            if (LoggingMethod.FILE_UPLOAD_LIST.getMethod().equals(topicResponse.getMethod())) {
                ServicesReceiver<Object> receiver = topicResponse.getData();
                FileUploadListResponse response = JsonUtils.parseConvert(topicResponse.getData(), new TypeReference<FileUploadListResponse>(){});
                receiver.setOutput(response);
            }
            channelFactory.put(topicResponse);
        }
    }
}
