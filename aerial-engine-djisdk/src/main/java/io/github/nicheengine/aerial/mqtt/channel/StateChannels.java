package io.github.nicheengine.aerial.mqtt.channel;

public interface StateChannels {

    String INBOUND_STATE_DRONE_WPMZ_VERSION = "inboundStateDroneWpmzVersion";

    String INBOUND_STATE_DRONE_FIRMWARE_VERSION = "inboundStateDroneFirmwareVersion";

    String INBOUND_STATE_DRONE_LIVE_CAPACITY = "inboundStateDroneLiveCapacity";

    String INBOUND_STATE_DRONE_CONTROL_SOURCE = "inboundStateDroneControlSource";

    String INBOUND_STATE_DRONE_LIVE_STATUS = "inboundStateDroneLiveStatus";

    String INBOUND_STATE_DRONE_COMMANDER_FLIGHT_MODE = "inboundStateDroneCommanderFlightMode";

    String INBOUND_STATE_DRONE_CURRENT_COMMANDER_FLIGHT_MODE = "inboundStateDroneCurrentCommanderFlightMode";

    String INBOUND_STATE_DRONE_COMMANDER_FLIGHT_HEIGHT = "inboundStateDroneCommanderFlightHeight";

    String INBOUND_STATE_DRONE_COMMANDER_MODE_LOST_ACTION = "inboundStateDroneCommanderModeLostAction";

    String INBOUND_STATE_DRONE_RTH_MODE = "inboundStateDroneRthMode";

    String INBOUND_STATE_DRONE_CURRENT_RTH_MODE = "inboundStateDroneCurrentRthMode";

    String INBOUND_STATE_DRONE_DONGLE_INFOS = "inboundStateDroneDongleInfos";

    String INBOUND_STATE_DRONE_CAMERA_WATERMARK_SETTINGS = "inboundStateDroneCameraWatermarkSettings";

    String INBOUND_STATE_DRONE_OFFLINE_MAP_ENABLE = "inboundStateDroneOfflineMapEnable";

    String INBOUND_STATE_DRONE_MODE_CODE_REASON = "inboundStateDroneModeCodeReason";

    // dock

    String INBOUND_STATE_DOCK_THERMAL_SUPPORTED_PALETTE_STYLE = "inboundStateDockThermalSupportedPaletteStyle";

    String INBOUND_STATE_DOCK_SILENT_MODE = "inboundStateDockSilentMode";

    String INBOUND_STATE_DOCK_WIRELESS_LINK_TOPO = "inboundStateDockWirelessLinkTopo";

    String INBOUND_STATE_DOCK_AIR_TRANSFER_ENABLE = "inboundStateDockAirTransferEnable";

    String INBOUND_STATE_DOCK_FLYSAFE_DATABASE_VERSION = "inboundStateDockFlysafeDatabaseVersion";

    // rc

    String INBOUND_STATE_RC_PAYLOAD_FIRMWARE = "inboundStateRcPayloadFirmware";

    String INBOUND_STATE_RC_CLOUD_CONTROL_AUTH = "inboundStateRcCloudControlAuth";

}
