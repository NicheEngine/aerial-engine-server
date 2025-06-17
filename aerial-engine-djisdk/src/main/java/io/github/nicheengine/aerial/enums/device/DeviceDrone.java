package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>DeviceDrone</code>
 * <p>The device drone enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nicheengine.aerial.AerialDeviceType
 * @since Jdk1.8
 */
public enum DeviceDrone implements AerialDeviceType {
    /**
     * <code>M400</code>
     * <p>The m 400 device drone field.</p>
     */
    M400(181),
    /**
     * <code>M350</code>
     * <p>The m 350 device drone field.</p>
     */
    M350(89),
    /**
     * <code>M300</code>
     * <p>The m 300 device drone field.</p>
     */
    M300(60),
    /**
     * <code>M30</code>
     * <p>The m 30 device drone field.</p>
     */
    M30(67),
    /**
     * <code>M30T</code>
     * <p>The m 30 t device drone field.</p>
     */
    M30T(67),
    /**
     * <code>M3E</code>
     * <p>The m 3 e device drone field.</p>
     */
    M3E(77),
    /**
     * <code>M3T</code>
     * <p>The m 3 t device drone field.</p>
     */
    M3T(77),
    /**
     * <code>M3M</code>
     * <p>The m 3 m device drone field.</p>
     */
    M3M(77),
    /**
     * <code>M3D</code>
     * <p>The m 3 d device drone field.</p>
     */
    M3D(91),
    /**
     * <code>M3TD</code>
     * <p>The m 3 td device drone field.</p>
     */
    M3TD(91),
    /**
     * <code>M4D</code>
     * <p>The m 4 d device drone field.</p>
     */
    M4D(100),
    /**
     * <code>M4TD</code>
     * <p>The m 4 td device drone field.</p>
     */
    M4TD(100),
    /**
     * <code>M4E</code>
     * <p>The m 4 e device drone field.</p>
     */
    M4E(99),
    /**
     * <code>M4T</code>
     * <p>The m 4 t device drone field.</p>
     */
    M4T(99),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown device drone field.</p>
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
     * <code>DeviceDrone</code>
     * <p>Instantiates a new device drone.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    DeviceDrone(Integer key) {
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
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceDrone} <p>The parse key return object is <code>DeviceDrone</code> type.</p>
     * @see java.lang.Integer
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static DeviceDrone parseKey(Integer key) {
        DeviceDrone parsedKey = RestKey.parseKey(DeviceDrone.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceDrone.UNKNOWN);
    }
}
