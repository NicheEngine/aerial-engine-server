package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum InterconnectMethod implements RestKey<String>{

    CUSTOM_DATA_TRANSMISSION_TO_ESDK("custom_data_transmission_to_esdk"),

    CUSTOM_DATA_TRANSMISSION_TO_PSDK("custom_data_transmission_to_psdk"),

    UNKNOWN(""),

    ;
    private final String method;

    InterconnectMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return method;
    }

    @JsonCreator
    public static InterconnectMethod parseKey(String key) {
        InterconnectMethod parsedKey = RestKey.parseKey(InterconnectMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(InterconnectMethod.UNKNOWN);
    }

}
