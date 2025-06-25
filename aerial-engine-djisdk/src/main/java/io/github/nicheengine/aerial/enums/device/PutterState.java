package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum PutterState implements RestKey<Integer> {

    CLOSED(0),

    OPENED(1),

    HALF_OPEN(2),

    ABNORMAL(3),

    UNKNOWN(-1),
    ;

    private final Integer state;

    PutterState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static PutterState parseKey(Integer key) {
        PutterState parsedKey = RestKey.parseKey(PutterState.class, key);
        return Optional.ofNullable(parsedKey).orElse(PutterState.UNKNOWN);
    }
}
