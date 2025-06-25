package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum AirConditionerState implements RestKey<Integer>{

    IDLE(0),

    COOL(1),

    HEAT(2),

    DEHUMIDIFICATION(3),

    COOLING_EXIT(4),

    HEATING_EXIT(5),

    DEHUMIDIFICATION_EXIT(6),

    COOLING_PREPARATION(7),

    HEATING_PREPARATION(8),

    DEHUMIDIFICATION_PREPARATION(9),

    DISCONNECTED(32767),

    UNKNOWN(-1),

    ;
    private final Integer state;

    AirConditionerState(Integer action) {
        this.state = action;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return state;
    }

    @JsonCreator
    public static AirConditionerState parseKey(Integer key) {
        AirConditionerState parsedKey = RestKey.parseKey(AirConditionerState.class, key);
        return Optional.ofNullable(parsedKey).orElse(AirConditionerState.UNKNOWN);
    }

}
