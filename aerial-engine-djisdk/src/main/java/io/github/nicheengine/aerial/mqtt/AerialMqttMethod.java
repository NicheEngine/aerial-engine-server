package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nichetoolkit.rest.RestItem;

/**
 * <code>AerialMqttMethod</code>
 * <p>The aerial mqtt method interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestItem
 * @since Jdk1.8
 */
public interface AerialMqttMethod extends RestItem<String, String, TypeReference<?>> {

    /**
     * <code>getMethod</code>
     * <p>The get method getter method.</p>
     * @return {@link java.lang.String} <p>The get method return object is <code>String</code> type.</p>
     * @see java.lang.String
     * @see com.fasterxml.jackson.annotation.JsonValue
     */
    @JsonValue
    default String getMethod() {
        return getKey();
    }

    /**
     * <code>getChannel</code>
     * <p>The get channel getter method.</p>
     * @return {@link java.lang.String} <p>The get channel return object is <code>String</code> type.</p>
     * @see java.lang.String
     */
    default String getChannel() {
        return getValue();
    }

    /**
     * <code>getTypeReference</code>
     * <p>The get type reference getter method.</p>
     * @param <T> {@link java.lang.Object} <p>The parameter can be of any type.</p>
     * @return {@link com.fasterxml.jackson.core.type.TypeReference} <p>The get type reference return object is <code>TypeReference</code> type.</p>
     * @see com.fasterxml.jackson.core.type.TypeReference
     * @see java.lang.SuppressWarnings
     */
    @SuppressWarnings("unchecked")
    default <T> TypeReference<T> getTypeReference() {
        return (TypeReference<T>) getItem();
    }

}
