package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FlighttaskStatus implements RestKey<String> {
    
    SENT("sent", false),

    IN_PROGRESS("in_progress", false),

    OK("ok", true),

    PAUSED("paused", false),

    REJECTED("rejected", true),

    FAILED("failed", true),

    CANCELED("canceled", true),

    TIMEOUT("timeout", true),

    PARTIALLY_DONE("partially_done", true),

    UNKNOWN("", true),
    ;

    private final String status;

    private final boolean finished;

    FlighttaskStatus(String status, boolean finished) {
        this.status = status;
        this.finished = finished;
    }

    @Override
    public String getKey() {
        return this.status;
    }

    @JsonCreator
    public static FlighttaskStatus parseKey(String key) {
        FlighttaskStatus parsedKey = RestKey.parseKey(FlighttaskStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(FlighttaskStatus.UNKNOWN);
    }
}
