package io.github.nicheengine.aerial.enums.logging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FileUploadUpdateStatus implements RestKey<String>{

    CANCEL("cancel"),

    UNKNOWN(""),

    ;
    private final String status;

    FileUploadUpdateStatus(String status) {
        this.status = status;
    }

    @JsonValue
    @Override
    public String getKey() {
        return status;
    }

    @JsonCreator
    public static FileUploadUpdateStatus parseKey(String key) {
        FileUploadUpdateStatus parsedKey = RestKey.parseKey(FileUploadUpdateStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(FileUploadUpdateStatus.UNKNOWN);
    }

}
