package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LiveStreamMethod implements RestKey<String>{

    LIVE_START_PUSH("live_start_push"),

    LIVE_STOP_PUSH("live_stop_push"),

    LIVE_SET_QUALITY("live_set_quality"),

    LIVE_LENS_CHANGE("live_lens_change"),

    UNKNOWN(""),

    ;
    private final String method;

    LiveStreamMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return method;
    }

    @JsonCreator
    public static LiveStreamMethod parseKey(String key) {
        LiveStreamMethod parsedKey = RestKey.parseKey(LiveStreamMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(LiveStreamMethod.UNKNOWN);
    }

}
