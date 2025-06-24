package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MeteringMode implements RestKey<Integer>{
    DISABLE(0),

    SPOT(1),

    AREA(2),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    MeteringMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static MeteringMode parseKey(Integer key) {
        MeteringMode parsedKey = RestKey.parseKey(MeteringMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(MeteringMode.UNKNOWN);
    }

}
