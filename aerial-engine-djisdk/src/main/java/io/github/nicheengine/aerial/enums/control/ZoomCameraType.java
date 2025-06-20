package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ZoomCameraType implements RestKey<String>{

    ZOOM("zoom"),

    IR("ir"),

    UNKNOWN(""),

    ;
    private final String type;

    ZoomCameraType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static ZoomCameraType parseKey(String key) {
        ZoomCameraType parsedKey = RestKey.parseKey(ZoomCameraType.class, key);
        return Optional.ofNullable(parsedKey).orElse(ZoomCameraType.UNKNOWN);
    }

}
