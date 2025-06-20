package io.github.nicheengine.aerial.enums.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ConfigType implements RestKey<String>{

    PRODUCT("product"),

    UNKNOWN(""),

    ;
    private final String type;

    ConfigType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static ConfigType parseKey(String key) {
        ConfigType parsedKey = RestKey.parseKey(ConfigType.class, key);
        return Optional.ofNullable(parsedKey).orElse(ConfigType.UNKNOWN);
    }

}
