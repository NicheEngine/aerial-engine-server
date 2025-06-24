package io.github.nicheengine.aerial.service;


import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.model.device.UpdateTopo;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.*;
import io.github.nicheengine.aerial.mqtt.state.StateTopicResponse;
import io.github.nicheengine.aerial.mqtt.status.StatusTopicRequest;
import io.github.nicheengine.aerial.mqtt.status.StatusTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

@Slf4j
public class DeviceService {

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_DOCK)
    public void osdDock(TopicOsdRequest<OsdDock> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("osdDock not implemented");
    }

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_DOCK_DRONE)
    public void osdDockDrone(TopicOsdRequest<OsdDockDrone> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("osdDockDrone not implemented");
    }

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_RC)
    public void osdRemoteControl(TopicOsdRequest<OsdRemoteControl> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("osdRemoteControl not implemented");
    }

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_RC_DRONE)
    public void osdRcDrone(TopicOsdRequest<OsdRcDrone> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("osdRcDrone not implemented");
    }

    @ServiceActivator(inputChannel = StatusChannels.INBOUND_STATUS_ONLINE, outputChannel = DjisdkChannels.OUTBOUND_STATUS)
    public StatusTopicResponse<MqttReplyResult<?>> updateTopoOnline(StatusTopicRequest<UpdateTopo> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("updateTopoOnline not implemented");
    }

    @ServiceActivator(inputChannel = StatusChannels.INBOUND_STATUS_OFFLINE, outputChannel = DjisdkChannels.OUTBOUND_STATUS)
    public StatusTopicResponse<MqttReplyResult<?>> updateTopoOffline(StatusTopicRequest<UpdateTopo> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("updateTopoOffline not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_FIRMWARE_VERSION)
    public void dockFirmwareVersionUpdate(TopicStateRequest<DockFirmwareVersion> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockFirmwareVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_AND_DRONE_FIRMWARE_VERSION)
    public void rcAndDroneFirmwareVersionUpdate(TopicStateRequest<FirmwareVersion> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcAndDroneFirmwareVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_AND_DRONE_WPMZ_VERSION)
    public void rcAndDroneWpmzVersionUpdate(TopicStateRequest<WpmzVersion> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcAndDroneWpmzVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_CONTROL_SOURCE)
    public void dockControlSourceUpdate(TopicStateRequest<DockDroneControlSource> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockControlSourceUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_CONTROL_SOURCE)
    public void rcControlSourceUpdate(TopicStateRequest<RcDroneControlSource> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcControlSourceUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_LIVE_STATUS)
    public void dockLiveStatusUpdate(TopicStateRequest<DockLiveStatus> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockLiveStatusUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_LIVE_STATUS)
    public void rcLiveStatusUpdate(TopicStateRequest<RcLiveStatus> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcLiveStatusUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_PAYLOAD_FIRMWARE)
    public void rcPayloadFirmwareVersionUpdate(TopicStateRequest<PayloadFirmwareVersion> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcPayloadFirmwareVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_WPMZ_VERSION)
    public void dockWpmzVersionUpdate(TopicStateRequest<DockDroneWpmzVersion> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockWpmzVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_COMMANDER_FLIGHT_MODE)
    public void rcCommanderFlightMode(TopicStateRequest<RcCommanderFlightMode> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcCommanderFlightMode not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_COMMANDER_FLIGHT_HEIGHT)
    public void rcCommanderFlightHeight(TopicStateRequest<RcCommanderFlightHeight> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcCommanderFlightHeight not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_COMMANDER_MODE_LOST_ACTION)
    public void rcCommanderModeLostAction(TopicStateRequest<RcCommanderModeLostAction> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcCommanderModeLostAction not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_CAPABILITY_SET)
    public void rcCapabilitySet(TopicStateRequest<Object> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcCapabilitySet not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_RTH_MODE)
    public void rcRthMode(TopicStateRequest<RcRthMode> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcRthMode not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_IS_CLOUD_CONTROL_AUTH)
    public void rcIsCloudControlAuth(TopicStateRequest<RcIsCloudControlAuth> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcIsCloudControlAuth not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_DONGLE_INFOS)
    public void rcDongleInfos(TopicStateRequest<DongleInfos> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("rcDongleInfos not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_THERMAL_SUPPORTED_PALETTE_STYLE)
    public void dockThermalSupportedPaletteStyle(TopicStateRequest<DockDroneThermalSupportedPaletteStyle> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockThermalSupportedPaletteStyle not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_RTH_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockDroneRthMode(TopicStateRequest<DockDroneRthMode> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockRthMode not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_CURRENT_RTH_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockDroneCurrentRthMode(TopicStateRequest<DockDroneCurrentRthMode> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockCurrentRthMode not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_COMMANDER_MODE_LOST_ACTION, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockDroneCommanderModeLostAction(TopicStateRequest<DockDroneCommanderModeLostAction> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockDroneCommanderModeLostAction not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_CURRENT_COMMANDER_FLIGHT_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockDroneCurrentCommanderFlightMode(TopicStateRequest<DockDroneCurrentCommanderFlightMode> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockDroneCurrentCommanderFlightMode not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_COMMANDER_FLIGHT_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockDroneCommanderFlightMode(TopicStateRequest<DockDroneCommanderFlightMode> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockDroneCommanderFlightMode not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_COMMANDER_FLIGHT_HEIGHT, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockDroneCommanderFlightHeight(TopicStateRequest<DockDroneCommanderFlightHeight> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockDroneCommanderFlightHeight not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DRONE_MODE_CODE_REASON, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockDroneModeCodeReason(TopicStateRequest<DockDroneModeCodeReason> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockDroneModeCodeReason not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_1, include = GatewayThing.DOCK2)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_AND_DRONE_DONGLE_INFOS, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dongleInfos(TopicStateRequest<DongleInfos> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dongleInfos not implemented");
    }

    @DjisdkVersion(since = CloudSdkVersion.V1_0_2, include = GatewayThing.DOCK)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_SILENT_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockSilentMode(TopicStateRequest<DockSilentMode> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockSilentMode not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_WIRELESS_LINK_TOPO, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockWirelessLinkTopo(TopicStateRequest<DockWirelessLinkTopo> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockWirelessLinkTopo not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_AIR_TRANSFER_ENABLE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockAirTransferEnable(TopicStateRequest<DockAirTransferEnable> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockAirTransferEnable not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_FLYSAFE_DATABASE_VERSION, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockFlysafeDatabaseVersion(TopicStateRequest<DockFlysafeDatabaseVersion> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockFlysafeDatabaseVersion not implemented");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_DOCK_CAMERA_WATERMARK_SETTINGS, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockCameraWatermarkSettings(TopicStateRequest<DockCameraWatermarkSettings> request, MessageHeaders headers) throws AerialMqttErrorException {
        throw new UnsupportedOperationException("dockCameraWatermarkSettings not implemented");
    }

}
