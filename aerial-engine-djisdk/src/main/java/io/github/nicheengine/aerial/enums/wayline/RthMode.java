package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum RthMode implements RestKey<Integer>{
    OPTIMAL_HEIGHT(0),

    PRESET_HEIGHT(1),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    RthMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static RthMode parseKey(Integer key) {
        RthMode parsedKey = RestKey.parseKey(RthMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(RthMode.UNKNOWN);
    }

}
