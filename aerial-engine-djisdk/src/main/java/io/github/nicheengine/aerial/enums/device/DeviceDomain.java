package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>DeviceDomain</code>
 * <p>The device domain enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestKey
 * @since Jdk1.8
 */
public enum DeviceDomain implements RestKey<Integer> {

    /**
     * <code>DRONE</code>
     * <p>The drone device domain field.</p>
     */
    DRONE(0),

    /**
     * <code>PAYLOAD</code>
     * <p>The payload device domain field.</p>
     */
    PAYLOAD(1),

    /**
     * <code>REMOTER_CONTROL</code>
     * <p>The remoter control device domain field.</p>
     */
    REMOTER_CONTROL(2),

    /**
     * <code>DOCK</code>
     * <p>The dock device domain field.</p>
     */
    DOCK(3),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown device domain field.</p>
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
     * <code>DeviceDomain</code>
     * <p>Instantiates a new device domain.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    DeviceDomain(Integer key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.key;
    }

    /**
     * <code>getDomain</code>
     * <p>The get domain getter method.</p>
     * @return {@link java.lang.Integer} <p>The get domain return object is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    public Integer getDomain() {
        return this.key;
    }

    /**
     * <code>parseKey</code>
     * <p>The parse key method.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceDomain} <p>The parse key return object is <code>DeviceDomain</code> type.</p>
     * @see java.lang.Integer
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static DeviceDomain parseKey(Integer key) {
        DeviceDomain parsedKey = RestKey.parseKey(DeviceDomain.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceDomain.UNKNOWN);
    }
}
