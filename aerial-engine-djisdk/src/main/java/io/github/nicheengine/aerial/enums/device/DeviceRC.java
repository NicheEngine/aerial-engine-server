package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sun.org.apache.xpath.internal.operations.Plus;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>DeviceRC</code>
 * <p>The device rc enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nicheengine.aerial.AerialDeviceType
 * @since Jdk1.8
 */
public enum DeviceRC implements AerialDeviceType {
    /**
     * <code>RC</code>
     * <p>The rc device rc field.</p>
     */
    RC(56),
    /**
     * <code>RC_PLUS</code>
     * <p>The rc plus device rc field.</p>
     */
    RC_PLUS(119),
    /**
     * <code>RC_PLUS_2</code>
     * <p>The rc plus 2 device rc field.</p>
     */
    RC_PLUS_2(174),
    /**
     * <code>RC_PRO</code>
     * <p>The rc pro device rc field.</p>
     */
    RC_PRO(144),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown device rc field.</p>
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
     * <code>DeviceRC</code>
     * <p>Instantiates a new device rc.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    DeviceRC(Integer key) {
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
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceRC} <p>The parse key return object is <code>DeviceRC</code> type.</p>
     * @see java.lang.Integer
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static DeviceRC parseKey(Integer key) {
        DeviceRC parsedKey = RestKey.parseKey(DeviceRC.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceRC.UNKNOWN);
    }
}
