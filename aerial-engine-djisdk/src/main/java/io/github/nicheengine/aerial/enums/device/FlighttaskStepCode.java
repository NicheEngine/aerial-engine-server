package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FlighttaskStepCode implements RestKey<Integer>{
    TASK_PREPARING(0),

    TASK_OPERATING(1),

    STATE_RECOVERING(2),

    CUSTOM_FLIGHT_AREA_UPDATING(3),

    OFFLINE_MAP_UPDATING(4),

    IDLE(5),

    UNKNOWN(-1),
    ;
    private final Integer code;

    FlighttaskStepCode(Integer code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return code;
    }

    @JsonCreator
    public static FlighttaskStepCode parseKey(Integer key) {
        FlighttaskStepCode parsedKey = RestKey.parseKey(FlighttaskStepCode.class, key);
        return Optional.ofNullable(parsedKey).orElse(FlighttaskStepCode.UNKNOWN);
    }

}
