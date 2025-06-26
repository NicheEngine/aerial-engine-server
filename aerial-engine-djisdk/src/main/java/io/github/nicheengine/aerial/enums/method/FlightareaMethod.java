package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FlightareaMethod implements RestKey<String>{

    FLIGHT_AREAS_UPDATE("flight_areas_update"),

    FLIGHT_AREAS_DELETE("flight_areas_delete"),

    UNKNOWN(""),

    ;
    private final String method;

    FlightareaMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return method;
    }

    @JsonCreator
    public static FlightareaMethod parseKey(String key) {
        FlightareaMethod parsedKey = RestKey.parseKey(FlightareaMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(FlightareaMethod.UNKNOWN);
    }

}
