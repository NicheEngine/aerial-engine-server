package io.github.nicheengine.aerial.enums.upload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum UploadUpdateStatus implements RestKey<String>{

    CANCEL("cancel"),

    UNKNOWN(""),

    ;
    private final String status;

    UploadUpdateStatus(String status) {
        this.status = status;
    }

    @JsonValue
    @Override
    public String getKey() {
        return status;
    }

    @JsonCreator
    public static UploadUpdateStatus parseKey(String key) {
        UploadUpdateStatus parsedKey = RestKey.parseKey(UploadUpdateStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(UploadUpdateStatus.UNKNOWN);
    }

}
