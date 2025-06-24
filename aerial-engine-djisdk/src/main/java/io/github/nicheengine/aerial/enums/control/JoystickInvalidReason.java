package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum JoystickInvalidReason implements RestValue<Integer,String> {

    JOYSTICK_RC_LOST(0),

    JOYSTICK_BATTERY_LOW_GO_HOME(1),

    JOYSTICK_BATTERY_SUPER_LOW_LANDING(2),

    JOYSTICK_NEAR_BOUNDARY(3),

    JOYSTICK_RC_AUTHORITY(4),

    JOYSTICK_UNKNOWN(-1),
    ;
    private final Integer reason;

    private final String message;

    JoystickInvalidReason(Integer reason) {
        this.reason = reason;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.reason;
    }

    @Override
    public String getValue() {
        return this.message;
    }

    @JsonCreator
    public static JoystickInvalidReason parseKey(Integer key) {
        JoystickInvalidReason parsedKey = RestKey.parseKey(JoystickInvalidReason.class, key);
        return Optional.ofNullable(parsedKey).orElse(JoystickInvalidReason.JOYSTICK_UNKNOWN);
    }


}
