package io.github.nicheengine.aerial.enums.firmware;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum OtaProgressStatus implements RestKey<String> {


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

    OtaProgressStatus(String status, boolean end) {
        this.status = status;
        this.end = end;
    }

    @Override
    public String getKey() {
        return this.status;
    }

    @JsonCreator
    public static OtaProgressStatus parseKey(String key) {
        OtaProgressStatus parsedKey = RestKey.parseKey(OtaProgressStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(OtaProgressStatus.UNKNOWN);
    }
}
