package io.github.nicheengine.aerial.enums.livestream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LensChangeVideoType implements RestKey<String>{

    ZOOM("zoom"),

    WIDE("wide"),

    IR("ir"),

    UNKNOWN(""),

    ;
    private final String type;

    LensChangeVideoType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static LensChangeVideoType parseKey(String key) {
        LensChangeVideoType parsedKey = RestKey.parseKey(LensChangeVideoType.class, key);
        return Optional.ofNullable(parsedKey).orElse(LensChangeVideoType.UNKNOWN);
    }

}
