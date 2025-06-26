package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum OfflineMapMethod implements RestKey<String>{

    OFFLINE_MAP_UPDATE("offline_map_update"),

    UNKNOWN(""),

    ;
    private final String method;

    OfflineMapMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return method;
    }

    @JsonCreator
    public static OfflineMapMethod parseKey(String key) {
        OfflineMapMethod parsedKey = RestKey.parseKey(OfflineMapMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(OfflineMapMethod.UNKNOWN);
    }

}
