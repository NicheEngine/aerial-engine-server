package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FocusState implements RestKey<Integer> {

    IDLE(0),

    FOCUSING(1),

    SUCCESS(2),

    FAILED(3),

    UNKNOWN(-1),
    ;

    private final Integer state;

    FocusState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static FocusState parseKey(Integer key) {
        FocusState parsedKey = RestKey.parseKey(FocusState.class, key);
        return Optional.ofNullable(parsedKey).orElse(FocusState.UNKNOWN);
    }
}
