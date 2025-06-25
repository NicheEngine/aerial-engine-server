package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum SilentMode implements RestKey<Integer>{
    RING(0),

    SILENT(1),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    SilentMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static SilentMode parseKey(Integer key) {
        SilentMode parsedKey = RestKey.parseKey(SilentMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(SilentMode.UNKNOWN);
    }

}
