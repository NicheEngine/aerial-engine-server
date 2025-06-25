package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum SimCardState implements RestKey<Integer> {

    NO_CARD(0),

    INSERTED(1),

    UNKNOWN(-1),
    ;

    private final Integer state;

    SimCardState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static SimCardState parseKey(Integer key) {
        SimCardState parsedKey = RestKey.parseKey(SimCardState.class, key);
        return Optional.ofNullable(parsedKey).orElse(SimCardState.UNKNOWN);
    }
}
