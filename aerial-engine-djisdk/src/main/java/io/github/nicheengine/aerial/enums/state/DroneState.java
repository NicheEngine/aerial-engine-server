package io.github.nicheengine.aerial.enums.state;

import com.google.common.collect.Sets;
import io.github.nicheengine.aerial.model.device.drone.DroneCameraWatermarkSettings;
import io.github.nicheengine.aerial.model.device.drone.*;
import io.github.nicheengine.aerial.mqtt.MqttDeviceState;
import lombok.Getter;

import java.util.Set;

@Getter
public enum DroneState implements MqttDeviceState {

    OFFLINE_MAP_ENABLE(Sets.newHashSet("offline_map_enable"), DroneOfflineMapEnable.class),

    MODE_CODE_REASON(Sets.newHashSet("mode_code_reason"), DroneModeCodeReason.class),

    WPMZ_VERSION(Sets.newHashSet("wpmz_version"), DroneWpmzVersion.class),

    FIRMWARE_VERSION(Sets.newHashSet("firmware_version"), DroneFirmwareVersion.class),

    LIVE_CAPACITY(Sets.newHashSet("live_capacity"), DroneLiveCapacity.class),

    CONTROL_SOURCE(Sets.newHashSet("control_source"), DroneControlSource.class),

    LIVE_STATUS(Sets.newHashSet("live_status"), DroneLiveStatus.class),

    RTH_MODE(Sets.newHashSet("rth_mode"), DroneRthMode.class),

    CURRENT_RTH_MODE(Sets.newHashSet("current_rth_mode"), DroneCurrentRthMode.class),

    COMMANDER_MODE_LOST_ACTION(Sets.newHashSet("commander_mode_lost_action"), DroneCommanderModeLostAction.class),

    COMMANDER_FLIGHT_MODE(Sets.newHashSet("commander_flight_mode"), DroneCommanderFlightMode.class),

    CURRENT_COMMANDER_FLIGHT_MODE(Sets.newHashSet("current_commander_flight_mode"), DroneCurrentCommanderFlightMode.class),

    COMMANDER_FLIGHT_HEIGHT(Sets.newHashSet("commander_flight_height"), DroneCommanderFlightHeight.class),

    CAMERA_WATERMARK_SETTINGS(Sets.newHashSet("camera_watermark_settings"), DroneCameraWatermarkSettings.class),

    DONGLE_INFOS(Sets.newHashSet("dongle_infos"), DroneDongleInfos.class),

    ;

    private final Set<String> keys;

    private final Class<?> type;

    DroneState(Set<String> keys, Class<?> type) {
        this.keys = keys;
        this.type = type;
    }

}
