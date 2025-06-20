package io.github.nicheengine.aerial;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;

/**
 * <code>AerialDeviceType</code>
 * <p>The aerial device type interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestKey
 * @since Jdk1.8
 */
public interface AerialDeviceType extends RestKey<Integer> {

    @JsonValue
    @Override
    default Integer getKey() {
        return getType();
    }

    /**
     * <code>getType</code>
     * <p>The get type getter method.</p>
     * @return {@link java.lang.Integer} <p>The get type return object is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    Integer getType();

}
