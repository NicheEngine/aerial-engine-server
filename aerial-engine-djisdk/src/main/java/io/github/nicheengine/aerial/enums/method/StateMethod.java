package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.model.device.dock.*;
import io.github.nicheengine.aerial.model.device.drone.*;
import io.github.nicheengine.aerial.model.device.rc.RcCloudControlAuth;
import io.github.nicheengine.aerial.model.device.rc.RcPayloadFirmwareVersion;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nicheengine.aerial.mqtt.channel.StateChannels;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.*;


public enum StateMethod implements RestValue<String,Class<?>> {

    // drone / dock / rc

    DRONE_WPMZ_VERSION(StateChannels.INBOUND_STATE_DRONE_WPMZ_VERSION, DroneWpmzVersion.class),

    DRONE_FIRMWARE_VERSION(StateChannels.INBOUND_STATE_DRONE_FIRMWARE_VERSION, DroneFirmwareVersion.class),

    DRONE_LIVE_CAPACITY(StateChannels.INBOUND_STATE_DRONE_LIVE_CAPACITY, DroneLiveCapacity.class),

    DRONE_CONTROL_SOURCE(StateChannels.INBOUND_STATE_DRONE_CONTROL_SOURCE, DroneControlSource.class),

    DRONE_LIVE_STATUS(StateChannels.INBOUND_STATE_DRONE_LIVE_STATUS, DroneLiveStatus.class),

    DRONE_COMMANDER_FLIGHT_MODE(StateChannels.INBOUND_STATE_DRONE_COMMANDER_FLIGHT_MODE, DroneCommanderFlightMode.class),

    DRONE_CURRENT_COMMANDER_FLIGHT_MODE(StateChannels.INBOUND_STATE_DRONE_CURRENT_COMMANDER_FLIGHT_MODE, DroneCurrentCommanderFlightMode.class),

    DRONE_COMMANDER_FLIGHT_HEIGHT(StateChannels.INBOUND_STATE_DRONE_COMMANDER_FLIGHT_HEIGHT, DroneCommanderFlightHeight.class),

    DRONE_COMMANDER_MODE_LOST_ACTION(StateChannels.INBOUND_STATE_DRONE_COMMANDER_MODE_LOST_ACTION, DroneCommanderModeLostAction.class),

    DRONE_RTH_MODE(StateChannels.INBOUND_STATE_DRONE_RTH_MODE, DroneRthMode.class),

    DRONE_CURRENT_RTH_MODE(StateChannels.INBOUND_STATE_DRONE_CURRENT_RTH_MODE, DroneCurrentRthMode.class),

    DRONE_DONGLE_INFOS(StateChannels.INBOUND_STATE_DRONE_DONGLE_INFOS, DroneDongleInfos.class),

    DRONE_CAMERA_WATERMARK_SETTINGS(StateChannels.INBOUND_STATE_DRONE_CAMERA_WATERMARK_SETTINGS, DroneCameraWatermarkSettings.class),

    DRONE_OFFLINE_MAP_ENABLE(StateChannels.INBOUND_STATE_DRONE_OFFLINE_MAP_ENABLE, DroneOfflineMapEnable.class),

    DRONE_MODE_CODE_REASON(StateChannels.INBOUND_STATE_DRONE_MODE_CODE_REASON, DroneModeCodeReason.class),


    DOCK_THERMAL_SUPPORTED_PALETTE_STYLE(StateChannels.INBOUND_STATE_DOCK_THERMAL_SUPPORTED_PALETTE_STYLE, DockThermalSupportedPaletteStyle.class),

    DOCK_SILENT_MODE(StateChannels.INBOUND_STATE_DOCK_SILENT_MODE, DockSilentMode.class),

    DOCK_WIRELESS_LINK_TOPO(StateChannels.INBOUND_STATE_DOCK_WIRELESS_LINK_TOPO, DockWirelessLinkTopo.class),

    DOCK_AIR_TRANSFER_ENABLE(StateChannels.INBOUND_STATE_DOCK_AIR_TRANSFER_ENABLE, DockAirTransferEnable.class),

    DOCK_FLYSAFE_DATABASE_VERSION(StateChannels.INBOUND_STATE_DOCK_FLYSAFE_DATABASE_VERSION, DockFlysafeDatabaseVersion.class),


    RC_PAYLOAD_FIRMWARE(StateChannels.INBOUND_STATE_RC_PAYLOAD_FIRMWARE, RcPayloadFirmwareVersion.class),

    RC_CLOUD_CONTROL_AUTH(StateChannels.INBOUND_STATE_RC_CLOUD_CONTROL_AUTH, RcCloudControlAuth.class),

    UNKNOWN(MqttChannels.DEFAULT, Object.class);

    @Getter
    private final String channel;

    private final Class<?> type;

    StateMethod(String channel, Class<?> type) {
        this.channel = channel;
        this.type = type;
    }

    @Override
    public String getKey() {
        return this.channel;
    }

    @Override
    public Class<?> getValue() {
        return this.type;
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> getType() {
        return (Class<T>) this.type;
    }

    @JsonCreator
    public static StateMethod parseValue(Class<?> value) {
        StateMethod parsedValue = RestValue.parseValue(StateMethod.class, value);
        return Optional.ofNullable(parsedValue).orElse(StateMethod.UNKNOWN);
    }

}
