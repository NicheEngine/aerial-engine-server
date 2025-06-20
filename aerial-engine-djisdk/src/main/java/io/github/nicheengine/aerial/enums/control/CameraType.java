package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CameraType implements RestKey<String>{

    ZOOM("zoom"),

    WIDE("wide"),

    IR("ir"),

    UNKNOWN(""),

    ;
    private final String type;

    CameraType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static CameraType parseKey(String key) {
        CameraType parsedKey = RestKey.parseKey(CameraType.class, key);
        return Optional.ofNullable(parsedKey).orElse(CameraType.UNKNOWN);
    }

}
