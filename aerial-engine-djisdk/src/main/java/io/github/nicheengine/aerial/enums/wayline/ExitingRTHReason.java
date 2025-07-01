package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ExitingRTHReason implements RestKey<Integer> {

    EXITING_RTH_ADD_JOYSTICK_THROTTLE(0),

    EXITING_RTH_ADD_JOYSTICK_PITCH(1),

    EXITING_RTH_INITIALIZATION_FAILED(2),

    EXITING_RTH_SURROUNDED_BY_OBSTACLES(3),

    EXITING_RTH_FLIGHT_RESTRICTION(4),

    EXITING_RTH_OBSTACLE_IS_TOO_CLOSED(5),

    EXITING_RTH_NO_GPS(6),

    EXITING_RTH_GPS_AND_VIO_ARE_FALSE(7),

    EXITING_RTH_ERROR_OF_GPS_AND_VIO(8),

    EXITING_RTH_SHORT_DISTANCE_BACKTRACKING(9),

    EXITING_RTH_TRIGGER_RTH(10),

    EXITING_RTH_UNKNOWN(-1),
    ;

    private final Integer reason;

    private final String message;

    ExitingRTHReason(Integer reason) {
        this.reason = reason;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.reason;
    }

    @JsonCreator
    public static ExitingRTHReason parseKey(Integer key) {
        ExitingRTHReason parsedKey = RestKey.parseKey(ExitingRTHReason.class, key);
        return Optional.ofNullable(parsedKey).orElse(ExitingRTHReason.EXITING_RTH_UNKNOWN);
    }
}
