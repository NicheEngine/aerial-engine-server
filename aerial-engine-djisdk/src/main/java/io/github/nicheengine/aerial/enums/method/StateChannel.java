package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nicheengine.aerial.mqtt.channel.OsdChannels;
import io.github.nichetoolkit.rest.RestItem;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.*;


public enum StateChannel implements RestValue<Class<?>, String> {

    RC_AND_DRONE_WPMZ_VERSION( WpmzVersion.class,ChannelName.INBOUND_STATE_RC_AND_DRONE_WPMZ_VERSION),

    RC_AND_DRONE_FIRMWARE_VERSION(FirmwareVersion.class,ChannelName.INBOUND_STATE_RC_AND_DRONE_FIRMWARE_VERSION),

    RC_LIVE_CAPACITY(RcLivestreamAbilityUpdate.class,ChannelName.INBOUND_STATE_RC_LIVESTREAM_ABILITY_UPDATE),

    RC_DRONE_CONTROL_SOURCE(RcDroneControlSource.class,ChannelName.INBOUND_STATE_RC_CONTROL_SOURCE),

    RC_LIVE_STATUS(RcLiveStatus.class,ChannelName.INBOUND_STATE_RC_LIVE_STATUS),

    RC_PAYLOAD_FIRMWARE(PayloadFirmwareVersion.class,ChannelName.INBOUND_STATE_RC_PAYLOAD_FIRMWARE),

    RC_COMMANDER_FLIGHT_MODE(RcCommanderFlightMode.class,ChannelName.INBOUND_STATE_RC_COMMANDER_FLIGHT_MODE),

    RC_COMMANDER_FLIGHT_HEIGHT(RcCommanderFlightHeight.class,ChannelName.INBOUND_STATE_RC_COMMANDER_FLIGHT_HEIGHT),

    RC_COMMANDER_MODE_LOST_ACTION(RcCommanderModeLostAction.class,ChannelName.INBOUND_STATE_RC_COMMANDER_MODE_LOST_ACTION),

//    RC_CAPABILITY_SET(Object.class,ChannelName.INBOUND_STATE_RC_CAPABILITY_SET),

    RC_RTH_MODE(RcRthMode.class,ChannelName.INBOUND_STATE_RC_RTH_MODE),

    RC_IS_CLOUD_CONTROL_AUTH(RcIsCloudControlAuth.class, ChannelName.INBOUND_STATE_RC_IS_CLOUD_CONTROL_AUTH),

    RC_DONGLE_INFOS(DongleInfos.class, ChannelName.INBOUND_STATE_RC_DONGLE_INFOS),

    DOCK_FIRMWARE_VERSION(DockFirmwareVersion.class, ChannelName.INBOUND_STATE_DOCK_FIRMWARE_VERSION),

    DOCK_LIVE_CAPACITY(DockLivestreamAbilityUpdate.class, ChannelName.INBOUND_STATE_DOCK_LIVESTREAM_ABILITY_UPDATE),

    DOCK_DRONE_CONTROL_SOURCE(DockDroneControlSource.class, ChannelName.INBOUND_STATE_DOCK_DRONE_CONTROL_SOURCE),

    DOCK_LIVE_STATUS(DockLiveStatus.class, ChannelName.INBOUND_STATE_DOCK_LIVE_STATUS),

    DOCK_DRONE_WPMZ_VERSION(DockDroneWpmzVersion.class, ChannelName.INBOUND_STATE_DOCK_DRONE_WPMZ_VERSION),

    DOCK_DRONE_THERMAL_SUPPORTED_PALETTE_STYLE(DockDroneThermalSupportedPaletteStyle.class,ChannelName.INBOUND_STATE_DOCK_DRONE_THERMAL_SUPPORTED_PALETTE_STYLE),

    DOCK_DRONE_RTH_MODE(DockDroneRthMode.class,ChannelName.INBOUND_STATE_DOCK_DRONE_RTH_MODE),

    DOCK_DRONE_CURRENT_RTH_MODE( DockDroneCurrentRthMode.class,ChannelName.INBOUND_STATE_DOCK_DRONE_CURRENT_RTH_MODE),

    DOCK_DRONE_COMMANDER_MODE_LOST_ACTION(DockDroneCommanderModeLostAction.class,ChannelName.INBOUND_STATE_DOCK_DRONE_COMMANDER_MODE_LOST_ACTION),

    DOCK_DRONE_COMMANDER_FLIGHT_MODE(DockDroneCommanderFlightMode.class,ChannelName.INBOUND_STATE_DOCK_DRONE_COMMANDER_FLIGHT_MODE),

    DOCK_DRONE_CURRENT_COMMANDER_FLIGHT_MODE(DockDroneCurrentCommanderFlightMode.class,ChannelName.INBOUND_STATE_DOCK_DRONE_CURRENT_COMMANDER_FLIGHT_MODE),

    DOCK_DRONE_COMMANDER_FLIGHT_HEIGHT(DockDroneCommanderFlightHeight.class,ChannelName.INBOUND_STATE_DOCK_DRONE_COMMANDER_FLIGHT_HEIGHT),

    DOCK_DRONE_MODE_CODE_REASON(DockDroneModeCodeReason.class,ChannelName.INBOUND_STATE_DOCK_DRONE_MODE_CODE_REASON),

    DOCK_DRONE_OFFLINE_MAP_ENABLE(DockDroneOfflineMapEnable.class,ChannelName.INBOUND_STATE_DOCK_DRONE_OFFLINE_MAP_ENABLE),

    DOCK_AND_DRONE_DONGLE_INFOS(DongleInfos.class,ChannelName.INBOUND_STATE_DOCK_AND_DRONE_DONGLE_INFOS),

    DOCK_SILENT_MODE(DockSilentMode.class,ChannelName.INBOUND_STATE_DOCK_SILENT_MODE),

    DOCK_WIRELESS_LINK_TOPO(DockWirelessLinkTopo.class,ChannelName.INBOUND_STATE_DOCK_WIRELESS_LINK_TOPO),

    DOCK_AIR_TRANSFER_ENABLE(DockAirTransferEnable.class,ChannelName.INBOUND_STATE_DOCK_AIR_TRANSFER_ENABLE),

    DOCK_FLYSAFE_DATABASE_VERSION(DockFlysafeDatabaseVersion.class,ChannelName.INBOUND_STATE_DOCK_FLYSAFE_DATABASE_VERSION),

    DOCK_CAMERA_WATERMARK_SETTINGS(DockCameraWatermarkSettings.class,ChannelName.INBOUND_STATE_DOCK_DOCK_CAMERA_WATERMARK_SETTINGS),

    UNKNOWN(Object.class,ChannelName.DEFAULT);

    private final Class<?> type;
    @Getter
    private final String channel;

    StateChannel(Class<?> type, String channel) {
        this.type = type;
        this.channel = channel;
    }

    @Override
    public String getValue() {
        return this.channel;
    }

    @Override
    public Class<?> getKey() {
        return this.type;
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> getType() {
        return (Class<T>) this.type;
    }

    @JsonCreator
    public static StateChannel parseKey(Class<?> key) {
        StateChannel parsedKey = RestKey.parseKey(StateChannel.class, key);
        return Optional.ofNullable(parsedKey).orElse(StateChannel.UNKNOWN);
    }

}
