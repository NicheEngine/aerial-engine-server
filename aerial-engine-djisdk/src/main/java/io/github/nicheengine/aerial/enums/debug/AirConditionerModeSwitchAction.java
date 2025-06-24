package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum AirConditionerModeSwitchAction implements RestKey<Integer>{
    IDLE_MODE(0),

    COOLING_MODE(1),

    heating_mode(2),

    DEHUMIDIFICATION_MODE(3),

    UNKNOWN(-1),

    ;
    private final Integer action;

    AirConditionerModeSwitchAction(Integer action) {
        this.action = action;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return action;
    }

    @JsonCreator
    public static AirConditionerModeSwitchAction parseKey(Integer key) {
        AirConditionerModeSwitchAction parsedKey = RestKey.parseKey(AirConditionerModeSwitchAction.class, key);
        return Optional.ofNullable(parsedKey).orElse(AirConditionerModeSwitchAction.UNKNOWN);
    }

}
