package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>DeviceSubtype</code>
 * <p>The device subtype enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestKey
 * @since Jdk1.8
 */
public enum DeviceSubtype implements RestKey<Integer> {

    /**
     * <code>ZERO</code>
     * <p>The zero device subtype field.</p>
     */
    ZERO(0),

    /**
     * <code>ONE</code>
     * <p>The one device subtype field.</p>
     */
    ONE(1),

    /**
     * <code>TWO</code>
     * <p>The two device subtype field.</p>
     */
    TWO(2),

    /**
     * <code>_65535</code>
     * <p>The 65535 device subtype field.</p>
     */
    _65535(65535),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown device subtype field.</p>
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
     * <code>DeviceSubtype</code>
     * <p>Instantiates a new device subtype.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    DeviceSubtype(Integer key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.key;
    }

    /**
     * <code>getSubtype</code>
     * <p>The get subtype getter method.</p>
     * @return {@link java.lang.Integer} <p>The get subtype return object is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    public Integer getSubtype() {
        return this.key;
    }

    /**
     * <code>parseKey</code>
     * <p>The parse key method.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceSubtype} <p>The parse key return object is <code>DeviceSubtype</code> type.</p>
     * @see java.lang.Integer
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static DeviceSubtype parseKey(Integer key) {
        DeviceSubtype parsedKey = RestKey.parseKey(DeviceSubtype.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceSubtype.UNKNOWN);
    }
}
