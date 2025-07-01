package io.github.nicheengine.aerial.enums.upload;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum UploadStatus implements RestKey<String> {


    FILE_PULL("file_pull", false),

    FILE_ZIP("file_zip", false),

    FILE_UPLOADING("file_uploading", false),

    SENT("sent", false),

    IN_PROGRESS("in_progress", false),

    OK("ok", true),

    PAUSED("paused", false),

    REJECTED("rejected", true),

    FAILED("failed", true),

    CANCELED("canceled", true),

    TIMEOUT("timeout", true),

    UNKNOWN("", true),
    ;

    private final String status;

    private final boolean end;

    UploadStatus(String status, boolean end) {
        this.status = status;
        this.end = end;
    }

    @Override
    public String getKey() {
        return this.status;
    }

    @JsonCreator
    public static UploadStatus parseKey(String key) {
        UploadStatus parsedKey = RestKey.parseKey(UploadStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(UploadStatus.UNKNOWN);
    }
}
