package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum SimulateSwitch implements RestKey<Integer>{
    DISABLE(0),

    ENABLE(1),

    UNKNOWN(-1),

    ;
    private final Integer state;

    SimulateSwitch(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return state;
    }

    @JsonCreator
    public static SimulateSwitch parseKey(Integer key) {
        SimulateSwitch parsedKey = RestKey.parseKey(SimulateSwitch.class, key);
        return Optional.ofNullable(parsedKey).orElse(SimulateSwitch.UNKNOWN);
    }

}
