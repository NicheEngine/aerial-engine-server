package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FlyToStatus implements RestKey<String> {
    FLY_TO_PROGRESS("wayline_progress"),

    FLY_TO_FAILED("wayline_failed"),

    FLY_TO_OK("wayline_ok"),

    FLY_TO_CANCEL("wayline_cancel"),

    FLY_TO_UNKNOWN(""),
    ;
    private final String status;

    private final String message;

    FlyToStatus(String status) {
        this.status = status;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public String getKey() {
        return status;
    }

    @JsonCreator
    public static FlyToStatus parseKey(String key) {
        FlyToStatus parsedKey = RestKey.parseKey(FlyToStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(FlyToStatus.FLY_TO_UNKNOWN);
    }
}
