package io.github.nicheengine.aerial.mqtt;

import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * <code>AerialMessageGateway</code>
 * <p>The aerial message gateway interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see org.springframework.stereotype.Component
 * @see org.springframework.integration.annotation.MessagingGateway
 * @since Jdk1.8
 */
@Component
@MessagingGateway(defaultRequestChannel = MqttChannels.OUTBOUND)
public interface MqttMessageGateway {

    /**
     * <code>publish</code>
     * <p>The publish method.</p>
     * @param topic   {@link java.lang.String} <p>The topic parameter is <code>String</code> type.</p>
     * @param payload byte <p>The payload parameter is <code>byte</code> type.</p>
     * @see java.lang.String
     * @see org.springframework.messaging.handler.annotation.Header
     */
    void publish(@Header(MqttHeaders.TOPIC) String topic, byte[] payload);

    /**
     * <code>publish</code>
     * <p>The publish method.</p>
     * @param topic   {@link java.lang.String} <p>The topic parameter is <code>String</code> type.</p>
     * @param payload byte <p>The payload parameter is <code>byte</code> type.</p>
     * @param qos     int <p>The qos parameter is <code>int</code> type.</p>
     * @see java.lang.String
     * @see org.springframework.messaging.handler.annotation.Header
     */
    void publish(@Header(MqttHeaders.TOPIC) String topic, byte[] payload, @Header(MqttHeaders.QOS) int qos);
}
