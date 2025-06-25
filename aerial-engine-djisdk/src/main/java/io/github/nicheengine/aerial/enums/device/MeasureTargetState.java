package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MeasureTargetState implements RestKey<Integer>{
    NORMAL(0),

    TOO_CLOSE(1),

    TOO_FAR(2),

    NO_SIGNAL(3),

    UNKNOWN(-1),
    ;
    private final Integer state;

    MeasureTargetState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return state;
    }

    @JsonCreator
    public static MeasureTargetState parseKey(Integer key) {
        MeasureTargetState parsedKey = RestKey.parseKey(MeasureTargetState.class, key);
        return Optional.ofNullable(parsedKey).orElse(MeasureTargetState.UNKNOWN);
    }

}
