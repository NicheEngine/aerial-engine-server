package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DrcState implements RestKey<Integer>{
    DISCONNECTED(0),

    CONNECTING(1),

    CONNECTED(2),

    UNKNOWN(-1),

    ;
    private final Integer state;

    DrcState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return state;
    }

    @JsonCreator
    public static DrcState parseKey(Integer key) {
        DrcState parsedKey = RestKey.parseKey(DrcState.class, key);
        return Optional.ofNullable(parsedKey).orElse(DrcState.UNKNOWN);
    }

}
