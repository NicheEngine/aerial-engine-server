package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum RemoteDebugStatus implements RestKey<String> {
    SENT("sent", false),

    IN_PROGRESS("in_progress", false),

    OK("ok", true),

    PAUSED("paused", false),

    REJECTED("rejected", true),

    FAILED("failed", true),

    CANCELED("canceled", true),

    TIMEOUT("timeout", true),

    ;
    private final String status;

    private final Boolean end;

    RemoteDebugStatus(String status, Boolean end) {
        this.status = status;
        this.end = end;
    }

    @JsonValue
    @Override
    public String getKey() {
        return status;
    }

    @JsonCreator
    public static RemoteDebugStatus parseKey(String key) {
        RemoteDebugStatus parsedKey = RestKey.parseKey(RemoteDebugStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(RemoteDebugStatus.TIMEOUT);
    }
}
