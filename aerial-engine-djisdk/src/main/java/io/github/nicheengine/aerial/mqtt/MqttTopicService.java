package io.github.nicheengine.aerial.mqtt;

import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Set;

/**
 * <code>AerialTopicService</code>
 * <p>The aerial topic service interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @since Jdk1.8
 */
public interface MqttTopicService {

    /**
     * <code>subscribe</code>
     * <p>The subscribe method.</p>
     * @param topics {@link java.lang.String} <p>The topics parameter is <code>String</code> type.</p>
     * @see java.lang.String
     * @see org.springframework.messaging.handler.annotation.Header
     */
    void subscribe(@Header(MqttHeaders.TOPIC) String... topics);

    /**
     * <code>subscribe</code>
     * <p>The subscribe method.</p>
     * @param topic {@link java.lang.String} <p>The topic parameter is <code>String</code> type.</p>
     * @param qos   int <p>The qos parameter is <code>int</code> type.</p>
     * @see java.lang.String
     * @see org.springframework.messaging.handler.annotation.Header
     */
    void subscribe(@Header(MqttHeaders.TOPIC) String topic, int qos);

    /**
     * <code>unsubscribe</code>
     * <p>The unsubscribe method.</p>
     * @param topics {@link java.lang.String} <p>The topics parameter is <code>String</code> type.</p>
     * @see java.lang.String
     * @see org.springframework.messaging.handler.annotation.Header
     */
    void unsubscribe(@Header(MqttHeaders.TOPIC) String... topics);

    /**
     * <code>subscribedTopics</code>
     * <p>The subscribed topics method.</p>
     * @return {@link java.util.Set} <p>The subscribed topics return object is <code>Set</code> type.</p>
     * @see java.util.Set
     */
    Set<String> subscribedTopics();



}
