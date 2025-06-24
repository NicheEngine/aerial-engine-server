package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum GimbalResetMode implements RestKey<Integer>{
    RECENTER(0),

    DOWN(1),

    RECENTER_PAN(2),

    PITCH_DOWN(3),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    GimbalResetMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static GimbalResetMode parseKey(Integer key) {
        GimbalResetMode parsedKey = RestKey.parseKey(GimbalResetMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(GimbalResetMode.UNKNOWN);
    }

}
