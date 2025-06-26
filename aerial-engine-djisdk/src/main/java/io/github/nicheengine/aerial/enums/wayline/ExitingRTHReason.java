package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ExitingRTHReason implements RestKey<Integer> {

    ADD_JOYSTICK_THROTTLE(0, "Add joystick throttle"),

    ADD_JOYSTICK_PITCH(1, "Add joystick pitch"),

    INITIALIZATION_FAILED(2, "The initialization of behavior tree is failed"),

    SURROUNDED_BY_OBSTACLES(3, "Surrounded by obstacles"),

    FLIGHT_RESTRICTION(4, "Flight restriction is triggered"),

    OBSTACLE_IS_TOO_CLOSED(5, "Obstacle is too closed"),

    NO_GPS(6, "No GPS signal"),

    GPS_AND_VIO_ARE_FALSE(7, "The output flag of GPS and VIO location is false"),

    ERROR_OF_GPS_AND_VIO(8, "The error of GPS and VIO fusion position is too large"),

    SHORT_DISTANCE_BACKTRACKING(9, "Backtrack in a short distance"),

    TRIGGER_RTH(10, "Trigger the RTH in a short distanc"),

    UNKNOWN(-1),
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
        return Optional.ofNullable(parsedKey).orElse(ExitingRTHReason.UNKNOWN);
    }
}
