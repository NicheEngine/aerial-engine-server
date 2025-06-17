package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>DeviceDock</code>
 * <p>The device dock enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nicheengine.aerial.AerialDeviceType
 * @since Jdk1.8
 */
public enum DeviceDock implements AerialDeviceType {

    /**
     * <code>DOCK</code>
     * <p>The dock device dock field.</p>
     */
    DOCK(1),

    /**
     * <code>DOCK2</code>
     * <p>The dock 2 device dock field.</p>
     */
    DOCK2(2),

    /**
     * <code>DOCK3</code>
     * <p>The dock 3 device dock field.</p>
     */
    DOCK3(3),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown device dock field.</p>
     */
    UNKNOWN(99999),
    ;

    /**
     * <code>key</code>
     * {@link java.lang.Integer} <p>The <code>key</code> field.</p>
     * @see java.lang.Integer
     */
    private final Integer key;

    /**
     * <code>DeviceDock</code>
     * <p>Instantiates a new device dock.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    DeviceDock(Integer key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.key;
    }

    /**
     * <code>parseKey</code>
     * <p>The parse key method.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceDock} <p>The parse key return object is <code>DeviceDock</code> type.</p>
     * @see java.lang.Integer
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static DeviceDock parseKey(Integer key) {
        DeviceDock parsedKey = RestKey.parseKey(DeviceDock.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceDock.UNKNOWN);
    }
}
