package io.github.nicheengine.aerial.mqtt.channel;

public interface StateChannels {
    String INBOUND_STATE_RC_CONTROL_SOURCE = "inboundStateRcControlSource";

    String INBOUND_STATE_DOCK_DRONE_CONTROL_SOURCE = "inboundStateDockControlSource";

    String INBOUND_STATE_RC_LIVESTREAM_ABILITY_UPDATE = "inboundStateRcLiveCapacity";

    String INBOUND_STATE_DOCK_LIVESTREAM_ABILITY_UPDATE = "inboundStateDockLiveCapacity";

    String INBOUND_STATE_RC_LIVE_STATUS = "inboundStateRcLiveStatus";

    String INBOUND_STATE_DOCK_LIVE_STATUS = "inboundStateDockLiveStatus";

    String INBOUND_STATE_RC_AND_DRONE_FIRMWARE_VERSION = "inboundStateRcAndDroneFirmwareVersion";

    String INBOUND_STATE_RC_AND_DRONE_WPMZ_VERSION = "inboundStateRcAndDroneWpmzVersion";

    String INBOUND_STATE_DOCK_FIRMWARE_VERSION = "inboundStateDockFirmwareVersion";

    String INBOUND_STATE_RC_PAYLOAD_FIRMWARE = "inboundStateRcPayloadFirmware";

    String INBOUND_STATE_RC_COMMANDER_FLIGHT_MODE = "inboundStateRcCommanderFlightMode";

    String INBOUND_STATE_RC_COMMANDER_FLIGHT_HEIGHT = "inboundStateRcCommanderFlightHeight";

    String INBOUND_STATE_RC_COMMANDER_MODE_LOST_ACTION = "inboundStateRcCommanderModeLostAction";

    String INBOUND_STATE_RC_CAPABILITY_SET = "inboundStateRcCapabilitySet";

    String INBOUND_STATE_RC_RTH_MODE = "inboundStateRcRthMode";

    String INBOUND_STATE_RC_IS_CLOUD_CONTROL_AUTH = "inboundStateRcIsCloudControlAuth";

    String INBOUND_STATE_RC_DONGLE_INFOS = "inboundStateRcDongleInfos";

    String INBOUND_STATE_DOCK_DRONE_WPMZ_VERSION = "inboundStateDockDroneWpmzVersion";

    String INBOUND_STATE_DOCK_DRONE_THERMAL_SUPPORTED_PALETTE_STYLE = "inboundStateDockDronePayload";

    String INBOUND_STATE_DOCK_DRONE_RTH_MODE = "inboundStateDockDroneRthMode";

    String INBOUND_STATE_DOCK_DRONE_CURRENT_RTH_MODE = "inboundStateDockDroneCurrentRthMode";

    String INBOUND_STATE_DOCK_DRONE_COMMANDER_MODE_LOST_ACTION = "inboundStateDockDroneCommanderModeLostAction";

    String INBOUND_STATE_DOCK_DRONE_COMMANDER_FLIGHT_MODE = "inboundStateDockDroneCommanderFlightMode";

    String INBOUND_STATE_DOCK_DRONE_CURRENT_COMMANDER_FLIGHT_MODE = "inboundStateDockDroneCurrentCommanderFlightMode";

    String INBOUND_STATE_DOCK_DRONE_COMMANDER_FLIGHT_HEIGHT = "inboundStateDockDroneCommanderFlightHeight";

    String INBOUND_STATE_DOCK_DRONE_MODE_CODE_REASON = "inboundStateDockDroneModeCodeReason";

    String INBOUND_STATE_DOCK_DRONE_OFFLINE_MAP_ENABLE = "inboundStateDockDroneOfflineMapEnable";

    String INBOUND_STATE_DOCK_AND_DRONE_DONGLE_INFOS = "inboundStateDockAndDroneDongleInfos";

    String INBOUND_STATE_DOCK_SILENT_MODE = "inboundStateDockSilentMode";

    String INBOUND_STATE_DOCK_WIRELESS_LINK_TOPO = "inboundStateDockWirelessLinkTopo";

    String INBOUND_STATE_DOCK_AIR_TRANSFER_ENABLE = "inboundStateDockAirTransferEnable";

    String INBOUND_STATE_DOCK_FLYSAFE_DATABASE_VERSION = "inboundStateDockFlysafeDatabaseVersion";

    String INBOUND_STATE_DOCK_DOCK_CAMERA_WATERMARK_SETTINGS = "inboundStateDockCameraWatermarkSettings";

}
