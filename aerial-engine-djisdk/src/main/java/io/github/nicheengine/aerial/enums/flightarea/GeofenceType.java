package io.github.nicheengine.aerial.enums.flightarea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum GeofenceType implements RestKey<String>{

    DFENCE("dfence"),

    NFZ("nfz"),

    UNKNOWN(""),

    ;
    private final String type;

    GeofenceType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static GeofenceType parseKey(String key) {
        GeofenceType parsedKey = RestKey.parseKey(GeofenceType.class, key);
        return Optional.ofNullable(parsedKey).orElse(GeofenceType.UNKNOWN);
    }

}
