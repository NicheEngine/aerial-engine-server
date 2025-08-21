package io.github.nicheengine.aerial.error.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum EngineErrorStatus implements AerialErrorStatus {
    AERIAL_SUCCESS(0),

    AERIAL_ERROR(220000),
    AERIAL_DATA_ERROR(220001),
    AERIAL_PARAM_ERROR(210002),
    AERIAL_UNSUPPORTED_ERROR(210003),

    AERIAL_MQTT_ERROR(211010),
    AERIAL_MQTT_PUBLIC_ERROR(211011),

    AERIAL_WEBSOCKET_ERROR(212020),
    AERIAL_WEBSOCKET_PUBLIC_ERROR(211021),

    AERIAL_DEVICE_ERROR(210030),
    AERIAL_DEVICE_UNREGISTERED(210031),
    AERIAL_DEVICE_TYPE_UNSUPPORTED(210032),
    AERIAL_DEVICE_VERSION_UNSUPPORTED(210033),
    AERIAL_DEVICE_PROPERTY_UNSUPPORTED(210034),

    AERIAL_UNKNOWN_ERROR(999999),
    ;

    private final Integer status;

    EngineErrorStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getCode() {
        return this.status;
    }

    @JsonCreator
    public static EngineErrorStatus parseKey(Integer key) {
        EngineErrorStatus parsedKey = RestKey.parseKey(EngineErrorStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(EngineErrorStatus.AERIAL_UNKNOWN_ERROR);
    }

}
