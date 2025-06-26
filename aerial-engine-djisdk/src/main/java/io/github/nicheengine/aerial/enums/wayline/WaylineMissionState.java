package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WaylineMissionState implements RestKey<Integer> {

    DISCONNECT(0, "Disconnect"),

    NOT_SUPPORTED_WAYPOINT(1, "Do not support this waypoint"),

    WAYLINE_PREPARING(2, "Wayline is ready. File can be uploaded and uploaded file can be executed."),

    WAYLINE_UPLOADING(3, "Wayline file is uploading"),

    DRONE_PREPARING(4, "Trigger start command. Trgger aircraft reading wayline. Not start. Under preparation."),

    ARRIVE_FIRST_WAYPOINT(5, "Enter wayline and arrive first waypoint"),

    WAYLINE_EXECUTING(6, "Execute wayline"),

    WAYLINE_BROKEN(7, "Wayline is broken. Trigger reason: 1. User pauses the wayline. 2. Flight control is abnormal."),

    WAYLINE_RECOVER(8, "Wayline recover"),

    WAYLINE_END(9, "Wayline stop"),

    UNKNOWN(-1),
    ;

    private final Integer reason;

    private final String message;

    WaylineMissionState(Integer reason) {
        this.reason = reason;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.reason;
    }

    @JsonCreator
    public static WaylineMissionState parseKey(Integer key) {
        WaylineMissionState parsedKey = RestKey.parseKey(WaylineMissionState.class, key);
        return Optional.ofNullable(parsedKey).orElse(WaylineMissionState.UNKNOWN);
    }
}
