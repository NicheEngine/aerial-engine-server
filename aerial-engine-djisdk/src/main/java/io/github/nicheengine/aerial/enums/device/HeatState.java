package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HeatState implements RestKey<Integer> {

    DISABLED(0),

    HEATING(1),

    INSULATION(2),

    UNKNOWN(-1),
    ;

    private final Integer state;

    HeatState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static HeatState parseKey(Integer key) {
        HeatState parsedKey = RestKey.parseKey(HeatState.class, key);
        return Optional.ofNullable(parsedKey).orElse(HeatState.UNKNOWN);
    }
}
