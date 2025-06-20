package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ExposureCameraType implements RestKey<String>{

    ZOOM("zoom"),

    WIDE("wide"),

    UNKNOWN(""),

    ;
    private final String type;

    ExposureCameraType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static ExposureCameraType parseKey(String key) {
        ExposureCameraType parsedKey = RestKey.parseKey(ExposureCameraType.class, key);
        return Optional.ofNullable(parsedKey).orElse(ExposureCameraType.UNKNOWN);
    }

}
