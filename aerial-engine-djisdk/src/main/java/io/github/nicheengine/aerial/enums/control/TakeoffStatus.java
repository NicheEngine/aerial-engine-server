package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum TakeoffStatus implements RestKey<String> {
    TAKE_OFF_TASK_READY("task_ready"),

    TAKE_OFF_PROGRESS("wayline_progress"),

    TAKE_OFF_FAILED("wayline_failed"),

    TAKE_OFF_OK("wayline_ok"),

    TAKE_OFF_CANCEL("wayline_cancel"),

    TAKE_OFF_TASK_FINISH("task_finish"),

    TAKE_OFF_UNKNOWN(""),
    ;
    private final String status;

    private final String message;

    TakeoffStatus(String status) {
        this.status = status;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public String getKey() {
        return status;
    }

    @JsonCreator
    public static TakeoffStatus parseKey(String key) {
        TakeoffStatus parsedKey = RestKey.parseKey(TakeoffStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(TakeoffStatus.TAKE_OFF_UNKNOWN);
    }
}
