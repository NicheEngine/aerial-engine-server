package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WaylineMissionState implements RestKey<Integer> {

    WAYLINE_MISSION_DISCONNECT(0),

    WAYLINE_MISSION_NOT_SUPPORTED_WAYPOINT(1),

    WAYLINE_MISSION_WAYLINE_PREPARING(2),

    WAYLINE_MISSION_WAYLINE_UPLOADING(3),

    WAYLINE_MISSION_DRONE_PREPARING(4),

    WAYLINE_MISSION_ARRIVE_FIRST_WAYPOINT(5),

    WAYLINE_MISSION_WAYLINE_EXECUTING(6),

    WAYLINE_MISSION_WAYLINE_BROKEN(7),

    WAYLINE_MISSION_WAYLINE_RECOVER(8),

    WAYLINE_MISSION_WAYLINE_END(9),

    WAYLINE_MISSION_UNKNOWN(-1),
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
        return Optional.ofNullable(parsedKey).orElse(WaylineMissionState.WAYLINE_MISSION_UNKNOWN);
    }
}
