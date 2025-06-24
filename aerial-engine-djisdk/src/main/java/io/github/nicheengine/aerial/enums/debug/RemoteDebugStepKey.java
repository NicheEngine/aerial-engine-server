package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum RemoteDebugStepKey implements RestKey<String> {
    REMOTE_DEBUG_GET_BID("get_bid"),

    REMOTE_DEBUG_UPGRADING_PREVENT_REBOOT("upgrading_prevent_reboot"),

    REMOTE_DEBUG_CHECK_WORK_MODE("check_work_mode"),

    REMOTE_DEBUG_CHECK_TASK_STATE("check_task_state"),

    REMOTE_DEBUG_LAND_MCU_REBOOT("land_mcu_reboot"),

    REMOTE_DEBUG_RAIN_MCU_REBOOT("rain_mcu_reboot"),

    REMOTE_DEBUG_CORE_MCU_REBOOT("core_mcu_reboot"),

    REMOTE_DEBUG_SDR_REBOOT("sdr_reboot"),

    REMOTE_DEBUG_WRITE_REBOOT_PARAM_FILE("write_reboot_param_file"),

    REMOTE_DEBUG_GET_DRONE_POWER_STATE("get_drone_power_state"),

    REMOTE_DEBUG_CLOSE_PUTTER("close_putter"),

    REMOTE_DEBUG_CHECK_WIRED_CONNECT_STATE("check_wired_connect_state"),

    REMOTE_DEBUG_OPEN_DRONE("open_drone"),

    REMOTE_DEBUG_OPEN_ALARM("open_alarm"),

    REMOTE_DEBUG_CHECK_SCRAM_STATE("check_scram_state"),

    REMOTE_DEBUG_OPEN_COVER("open_cover"),

    REMOTE_DEBUG_CHECK_DRONE_SDR_CONNECT_STATE("check_drone_sdr_connect_state"),

    REMOTE_DEBUG_TURN_ON_DRONE("turn_on_drone"),

    REMOTE_DEBUG_DRONE_PADDLE_FORWARD("drone_paddle_forward"),

    REMOTE_DEBUG_CLOSE_COVER("close_cover"),

    REMOTE_DEBUG_DRONE_PADDLE_REVERSE("drone_paddle_reverse"),

    REMOTE_DEBUG_DRONE_PADDLE_STOP("drone_paddle_stop"),

    REMOTE_DEBUG_FREE_PUTTER("free_putter"),

    REMOTE_DEBUG_STOP_CHARGE("stop_charge"),

    REMOTE_DEBUG_UNKNOWN(""),
    ;
    private final String status;

    private final String message;

    RemoteDebugStepKey(String status) {
        this.status = status;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public String getKey() {
        return status;
    }

    @JsonCreator
    public static RemoteDebugStepKey parseKey(String key) {
        RemoteDebugStepKey parsedKey = RestKey.parseKey(RemoteDebugStepKey.class, key);
        return Optional.ofNullable(parsedKey).orElse(RemoteDebugStepKey.REMOTE_DEBUG_UNKNOWN);
    }
}
