package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

/**
 * <code>AerialErrorStatus</code>
 * <p>The aerial error status enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nicheengine.aerial.error.AerialErrorInfo
 * @see lombok.Getter
 * @since Jdk1.8
 */
@Getter
public enum AerialErrorStatus implements AerialErrorInfo {
    /**
     * <code>AERIAL_ERROR</code>
     * <p>The aerial error aerial error status field.</p>
     */
    AERIAL_ERROR(220000),
    /**
     * <code>AERIAL_DATA_ERROR</code>
     * <p>The aerial data error aerial error status field.</p>
     */
    AERIAL_DATA_ERROR(220001),

    /**
     * <code>AERIAL_PARAM_ERROR</code>
     * <p>The aerial param error aerial error status field.</p>
     */
    AERIAL_PARAM_ERROR(210002),

    /**
     * <code>AERIAL_MQTT_ERROR</code>
     * <p>The aerial mqtt error aerial error status field.</p>
     */
    AERIAL_MQTT_ERROR(211003),

    /**
     * <code>AERIAL_MQTT_PUBLIC_ERROR</code>
     * <p>The aerial mqtt public error aerial error status field.</p>
     */
    AERIAL_MQTT_PUBLIC_ERROR(211004),

    /**
     * <code>AERIAL_WEBSOCKET_ERROR</code>
     * <p>The aerial websocket error aerial error status field.</p>
     */
    AERIAL_WEBSOCKET_ERROR(212005),

    /**
     * <code>AERIAL_WEBSOCKET_PUBLIC_ERROR</code>
     * <p>The aerial websocket public error aerial error status field.</p>
     */
    AERIAL_WEBSOCKET_PUBLIC_ERROR(211006),

    /**
     * <code>AERIAL_UNSUPPORTED_ERROR</code>
     * <p>The aerial unsupported error aerial error status field.</p>
     */
    AERIAL_UNSUPPORTED_ERROR(210007),

    /**
     * <code>AERIAL_DEVICE_ERROR</code>
     * <p>The aerial device error aerial error status field.</p>
     */
    AERIAL_DEVICE_ERROR(210010),

    /**
     * <code>AERIAL_DEVICE_UNREGISTERED</code>
     * <p>The aerial device unregistered aerial error status field.</p>
     */
    AERIAL_DEVICE_UNREGISTERED(210011),

    /**
     * <code>AERIAL_DEVICE_TYPE_UNSUPPORTED</code>
     * <p>The aerial device type unsupported aerial error status field.</p>
     */
    AERIAL_DEVICE_TYPE_UNSUPPORTED(210012),

    /**
     * <code>AERIAL_DEVICE_VERSION_UNSUPPORTED</code>
     * <p>The aerial device version unsupported aerial error status field.</p>
     */
    AERIAL_DEVICE_VERSION_UNSUPPORTED(210013),

    /**
     * <code>AERIAL_DEVICE_PROPERTY_UNSUPPORTED</code>
     * <p>The aerial device property unsupported aerial error status field.</p>
     */
    AERIAL_DEVICE_PROPERTY_UNSUPPORTED(210014),

    /**
     * <code>AERIAL_UNKNOWN_ERROR</code>
     * <p>The aerial unknown error aerial error status field.</p>
     */
    AERIAL_UNKNOWN_ERROR(299999),
    ;

    /**
     * <code>status</code>
     * {@link java.lang.Integer} <p>The <code>status</code> field.</p>
     * @see java.lang.Integer
     */
    private final Integer status;
    /**
     * <code>message</code>
     * {@link java.lang.String} <p>The <code>message</code> field.</p>
     * @see java.lang.String
     */
    private final String message;

    /**
     * <code>AerialErrorStatus</code>
     * <p>Instantiates a new aerial error status.</p>
     * @param status {@link java.lang.Integer} <p>The status parameter is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    AerialErrorStatus(Integer status) {
        this.status = status;
        this.message = I18nUtils.message(name());
    }

    /**
     * <code>AerialErrorStatus</code>
     * <p>Instantiates a new aerial error status.</p>
     * @param status  {@link java.lang.Integer} <p>The status parameter is <code>Integer</code> type.</p>
     * @param message {@link java.lang.String} <p>The message parameter is <code>String</code> type.</p>
     * @see java.lang.Integer
     * @see java.lang.String
     */
    AerialErrorStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * <code>getName</code>
     * <p>The get name getter method.</p>
     * @return {@link java.lang.String} <p>The get name return object is <code>String</code> type.</p>
     * @see java.lang.String
     */
    public String getName() {
        return this.name().toLowerCase().replace("_", " ");
    }

    @Override
    public Integer getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
