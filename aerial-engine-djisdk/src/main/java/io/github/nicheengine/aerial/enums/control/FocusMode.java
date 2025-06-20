package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FocusMode implements RestKey<Integer>{
    MF(0),

    AFS(1),

    AFC(2),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    FocusMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static FocusMode parseKey(Integer key) {
        FocusMode parsedKey = RestKey.parseKey(FocusMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(FocusMode.UNKNOWN);
    }

}
