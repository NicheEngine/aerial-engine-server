package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ExposureMode implements RestKey<Integer>{
    AUTO(1),

    SHUTTER_PRIORITY(2),

    APERTURE_PRIORITY(3),

    MANUAL(4),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    ExposureMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static ExposureMode parseKey(Integer key) {
        ExposureMode parsedKey = RestKey.parseKey(ExposureMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(ExposureMode.UNKNOWN);
    }

}
