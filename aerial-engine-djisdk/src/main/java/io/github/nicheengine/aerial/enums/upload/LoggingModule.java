package io.github.nicheengine.aerial.enums.upload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LoggingModule implements RestKey<String> {
    DRONE("0"),
    DOCK ("3"),
    UNKNOWN("");

    private final String module;

    LoggingModule(String module) {
        this.module = module;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.module;
    }

    @JsonCreator
    public static LoggingModule parseKey(String key) {
        LoggingModule parsedKey = RestKey.parseKey(LoggingModule.class, key);
        return Optional.ofNullable(parsedKey).orElse(LoggingModule.UNKNOWN);
    }
}
