package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum EsimActivateState implements RestKey<Integer> {

    INACTIVATED(0),

    ACTIVATED(1),

    UNKNOWN(-1),
    ;

    private final Integer state;

    EsimActivateState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static EsimActivateState parseKey(Integer key) {
        EsimActivateState parsedKey = RestKey.parseKey(EsimActivateState.class, key);
        return Optional.ofNullable(parsedKey).orElse(EsimActivateState.UNKNOWN);
    }
}
