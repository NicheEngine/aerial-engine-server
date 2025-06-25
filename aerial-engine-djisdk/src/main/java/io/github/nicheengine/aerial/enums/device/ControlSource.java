package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ControlSource implements RestKey<String>{

    A("A"),

    B("B"),

    UNKNOWN(""),

    ;
    private final String controlSource;

    ControlSource(String controlSource) {
        this.controlSource = controlSource;
    }

    @JsonValue
    @Override
    public String getKey() {
        return controlSource;
    }

    @JsonCreator
    public static ControlSource parseKey(String key) {
        ControlSource parsedKey = RestKey.parseKey(ControlSource.class, key);
        return Optional.ofNullable(parsedKey).orElse(ControlSource.UNKNOWN);
    }

}
