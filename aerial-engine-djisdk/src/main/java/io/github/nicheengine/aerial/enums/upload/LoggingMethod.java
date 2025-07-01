package io.github.nicheengine.aerial.enums.upload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LoggingMethod implements RestKey<String> {
    FILE_UPLOAD_LIST("fileupload_list"),

    FILE_UPLOAD_START("fileupload_start"),

    FILE_UPLOAD_UPDATE("fileupload_update"),

    UNKNOWN("");

    private final String method;

    LoggingMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.method;
    }

    @JsonCreator
    public static LoggingMethod parseKey(String key) {
        LoggingMethod parsedKey = RestKey.parseKey(LoggingMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(LoggingMethod.UNKNOWN);
    }
}
