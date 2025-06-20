package io.github.nicheengine.aerial.enums.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ConfigScope implements RestKey<String>{

    PRODUCT("product"),

    UNKNOWN(""),

    ;
    private final String scope;

    ConfigScope(String scope) {
        this.scope = scope;
    }

    @JsonValue
    @Override
    public String getKey() {
        return scope;
    }

    @JsonCreator
    public static ConfigScope parseKey(String key) {
        ConfigScope parsedKey = RestKey.parseKey(ConfigScope.class, key);
        return Optional.ofNullable(parsedKey).orElse(ConfigScope.UNKNOWN);
    }

}
