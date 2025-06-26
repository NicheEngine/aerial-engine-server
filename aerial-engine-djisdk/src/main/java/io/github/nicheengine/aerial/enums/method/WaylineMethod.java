package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WaylineMethod implements RestKey<String>{

    FLIGHTTASK_CREATE("flighttask_create"),

    FLIGHTTASK_PREPARE("flighttask_prepare"),

    FLIGHTTASK_EXECUTE("flighttask_execute"),

    FLIGHTTASK_UNDO("flighttask_undo"),

    FLIGHTTASK_PAUSE("flighttask_pause"),

    FLIGHTTASK_RECOVERY("flighttask_recovery"),

    RETURN_HOME("return_home"),

    RETURN_HOME_CANCEL("return_home_cancel"),

    UNKNOWN(""),

    ;
    private final String method;

    WaylineMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return method;
    }

    @JsonCreator
    public static WaylineMethod parseKey(String key) {
        WaylineMethod parsedKey = RestKey.parseKey(WaylineMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(WaylineMethod.UNKNOWN);
    }

}
