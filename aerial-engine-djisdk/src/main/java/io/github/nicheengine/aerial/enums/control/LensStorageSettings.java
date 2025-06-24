package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LensStorageSettings implements RestKey<String>{

    CURRENT("current"),

    ZOOM("zoom"),

    WIDE("wide"),

    VISION("vision"),

    INFRARED("ir"),

    UNKNOWN(""),

    ;
    private final String lens;

    LensStorageSettings(String lens) {
        this.lens = lens;
    }

    @JsonValue
    @Override
    public String getKey() {
        return lens;
    }

    @JsonCreator
    public static LensStorageSettings parseKey(String key) {
        LensStorageSettings parsedKey = RestKey.parseKey(LensStorageSettings.class, key);
        return Optional.ofNullable(parsedKey).orElse(LensStorageSettings.UNKNOWN);
    }

}
