package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CoverState implements RestKey<Integer> {

    CLOSED(0),

    OPENED(1),

    HALF_OPEN(2),

    ABNORMAL(3),

    UNKNOWN(-1),
    ;

    private final Integer state;

    CoverState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static CoverState parseKey(Integer key) {
        CoverState parsedKey = RestKey.parseKey(CoverState.class, key);
        return Optional.ofNullable(parsedKey).orElse(CoverState.UNKNOWN);
    }
}
