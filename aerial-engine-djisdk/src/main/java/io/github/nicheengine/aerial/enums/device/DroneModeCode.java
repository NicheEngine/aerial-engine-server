package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DroneModeCode implements RestKey<Integer>{
    IDLE(0),

    TAKEOFF_PREPARE(1),

    TAKEOFF_FINISHED(2),

    MANUAL(3),

    TAKEOFF_AUTO(4),

    WAYLINE(5),

    PANORAMIC_SHOT(6),

    ACTIVE_TRACK(7),

    ADS_B_AVOIDANCE(8),

    RETURN_AUTO(9),

    LANDING_AUTO(10),

    LANDING_FORCED(11),

    LANDING_THREE_PROPELLER(12),

    UPGRADING(13),

    DISCONNECTED(14),

    APAS(15),

    VIRTUAL_JOYSTICK(16),

    LIVE_FLIGHT_CONTROLS(17),

    AERIAL_RTK_FIXED(18),

    DOCK_SITE_EVALUATION(19),

    POI(20),

    UNKNOWN(-1),
    ;
    private final Integer code;

    DroneModeCode(Integer code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return code;
    }

    @JsonCreator
    public static DroneModeCode parseKey(Integer key) {
        DroneModeCode parsedKey = RestKey.parseKey(DroneModeCode.class, key);
        return Optional.ofNullable(parsedKey).orElse(DroneModeCode.UNKNOWN);
    }

}
