package io.github.nicheengine.aerial.enums.flightarea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum GeometrySubtype implements RestKey<String>{

    CIRCLE("Circle"),

    UNKNOWN(""),

    ;
    private final String subtype;

    GeometrySubtype(String subtype) {
        this.subtype = subtype;
    }

    @JsonValue
    @Override
    public String getKey() {
        return subtype;
    }

    @JsonCreator
    public static GeometrySubtype parseKey(String key) {
        GeometrySubtype parsedKey = RestKey.parseKey(GeometrySubtype.class, key);
        return Optional.ofNullable(parsedKey).orElse(GeometrySubtype.UNKNOWN);
    }

}
