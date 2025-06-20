package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestValue;

/**
 * <code>AerialMqttMethod</code>
 * <p>The aerial mqtt method interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestValue
 * @since Jdk1.8
 */
public interface MqttMethod extends RestValue<String, String> {

    /**
     * <code>getMethod</code>
     * <p>The get method getter method.</p>
     * @return {@link java.lang.String} <p>The get method return object is <code>String</code> type.</p>
     * @see java.lang.String
     * @see com.fasterxml.jackson.annotation.JsonValue
     */
    @JsonValue
    String getMethod();

    /**
     * <code>getChannel</code>
     * <p>The get channel getter method.</p>
     * @return {@link java.lang.String} <p>The get channel return object is <code>String</code> type.</p>
     * @see java.lang.String
     */
    String getChannel();

    @Override
    default String getValue() {
        return this.getChannel();
    }

    @Override
    default String getKey() {
        return this.getMethod();
    }
}
