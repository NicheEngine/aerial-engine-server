package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum PositionFixed implements RestKey<Integer>{

    NOT_START(0),

    FIXING(1),

    SUCCESSFUL(2),

    FAILED(3),

    UNKNOWN(-1),

    ;
    private final Integer fixed;

    PositionFixed(Integer fixed) {
        this.fixed = fixed;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return fixed;
    }

    @JsonCreator
    public static PositionFixed parseKey(Integer key) {
        PositionFixed parsedKey = RestKey.parseKey(PositionFixed.class, key);
        return Optional.ofNullable(parsedKey).orElse(PositionFixed.UNKNOWN);
    }

}
