package io.github.nicheengine.aerial.enums.flightarea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum GeometryType implements RestKey<String>{

    POINT("Point"),

    POLYGON("Polygon"),

    UNKNOWN(""),

    ;
    private final String type;

    GeometryType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static GeometryType parseKey(String key) {
        GeometryType parsedKey = RestKey.parseKey(GeometryType.class, key);
        return Optional.ofNullable(parsedKey).orElse(GeometryType.UNKNOWN);
    }

}
