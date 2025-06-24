package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum PoiStatusReason implements RestKey<Integer>{
    NORMAL(0),

    UNADAPTED_PAYLOAD(1),

    CAMERA_MODE_NOT_SUPPORTED(2),

    ILLEGAL_CMD(3),

    POSITIONING_FAILED(4),

    ON_THE_GROUND(5),

    DRONE_MODE_ERROR(6),

    NOT_AVAILABLE_MODE(7),

    RC_DISCONNECTED(8),

    UNKNOWN(-1),

    ;
    private final Integer reason;

    PoiStatusReason(Integer reason) {
        this.reason = reason;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return reason;
    }

    @JsonCreator
    public static PoiStatusReason parseKey(Integer key) {
        PoiStatusReason parsedKey = RestKey.parseKey(PoiStatusReason.class, key);
        return Optional.ofNullable(parsedKey).orElse(PoiStatusReason.UNKNOWN);
    }

}
