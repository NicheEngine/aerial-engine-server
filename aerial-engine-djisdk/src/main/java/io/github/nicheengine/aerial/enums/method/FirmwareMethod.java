package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FirmwareMethod implements RestKey<String>{

    OTA_CREATE("ota_create"),

    UNKNOWN(""),

    ;
    private final String method;

    FirmwareMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return method;
    }

    @JsonCreator
    public static FirmwareMethod parseKey(String key) {
        FirmwareMethod parsedKey = RestKey.parseKey(FirmwareMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(FirmwareMethod.UNKNOWN);
    }

}
