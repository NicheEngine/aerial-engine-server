package io.github.nicheengine.aerial.service;


import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.error.AerialMqttErrorException;
import io.github.nicheengine.aerial.model.device.UpdateTopo;
import io.github.nicheengine.aerial.model.device.dock.*;
import io.github.nicheengine.aerial.model.device.drone.*;
import io.github.nicheengine.aerial.model.device.osd.OsdDock;
import io.github.nicheengine.aerial.model.device.osd.OsdDockDrone;
import io.github.nicheengine.aerial.model.device.osd.OsdRcDrone;
import io.github.nicheengine.aerial.model.device.osd.OsdRemoteControl;
import io.github.nicheengine.aerial.model.device.rc.RcCloudControlAuth;
import io.github.nicheengine.aerial.model.device.rc.RcPayloadFirmwareVersion;
import io.github.nicheengine.aerial.mqtt.MqttReplyResult;
import io.github.nicheengine.aerial.mqtt.channel.*;
import io.github.nicheengine.aerial.mqtt.osd.OsdTopicRequest;
import io.github.nicheengine.aerial.mqtt.state.StateTopicRequest;
import io.github.nicheengine.aerial.mqtt.state.StateTopicResponse;
import io.github.nicheengine.aerial.mqtt.status.StatusTopicRequest;
import io.github.nicheengine.aerial.mqtt.status.StatusTopicResponse;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
import io.github.nichetoolkit.rest.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

@Slf4j
public abstract class DeviceService {

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_DOCK)
    public void osdDock(OsdTopicRequest<OsdDock> request, MessageHeaders headers) throws RestException {
        log.error("the service of [osdDock] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("osdDock not implemented.");
    }

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_DOCK_DRONE)
    public void osdDockDrone(OsdTopicRequest<OsdDockDrone> request, MessageHeaders headers) throws RestException {
        log.error("the service of [osdDockDrone] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("osdDockDrone not implemented.");
    }

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_RC)
    public void osdRemoteControl(OsdTopicRequest<OsdRemoteControl> request, MessageHeaders headers) throws RestException {
        log.error("the service of [osdRemoteControl] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("osdRemoteControl not implemented.");
    }

    @ServiceActivator(inputChannel = OsdChannels.INBOUND_OSD_RC_DRONE)
    public void osdRcDrone(OsdTopicRequest<OsdRcDrone> request, MessageHeaders headers) throws RestException {
        log.error("the service of [osdRcDrone] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("osdRcDrone not implemented.");
    }

    @ServiceActivator(inputChannel = StatusChannels.INBOUND_STATUS_ONLINE, outputChannel = DjisdkChannels.OUTBOUND_STATUS)
    public StatusTopicResponse<MqttReplyResult<?>> topoOnline(StatusTopicRequest<UpdateTopo> request, MessageHeaders headers) throws RestException {
        log.error("the service of [topoOnline] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("topoOnline not implemented.");
    }

    @ServiceActivator(inputChannel = StatusChannels.INBOUND_STATUS_OFFLINE, outputChannel = DjisdkChannels.OUTBOUND_STATUS)
    public StatusTopicResponse<MqttReplyResult<?>> topoOffline(StatusTopicRequest<UpdateTopo> request, MessageHeaders headers) throws RestException {
        log.error("the service of [topoOffline] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("topoOffline not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_WPMZ_VERSION)
    public void droneWpmzVersion(StateTopicRequest<DroneWpmzVersion> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneWpmzVersion] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneWpmzVersion not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_FIRMWARE_VERSION)
    public void droneFirmwareVersion(StateTopicRequest<DroneFirmwareVersion> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneFirmwareVersion] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneFirmwareVersion not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_CONTROL_SOURCE)
    public void droneControlSource(StateTopicRequest<DroneControlSource> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneControlSource] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneControlSource not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_LIVE_STATUS)
    public void droneLiveStatus(StateTopicRequest<DroneLiveStatus> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneLiveStatus] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneLiveStatus not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_COMMANDER_FLIGHT_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneCommanderFlightMode(StateTopicRequest<DroneCommanderFlightMode> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneCommanderFlightMode] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneCommanderFlightMode not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_CURRENT_COMMANDER_FLIGHT_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneCurrentCommanderFlightMode(StateTopicRequest<DroneCurrentCommanderFlightMode> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneCurrentCommanderFlightMode] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneCurrentCommanderFlightMode not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_COMMANDER_FLIGHT_HEIGHT, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneCommanderFlightHeight(StateTopicRequest<DroneCommanderFlightHeight> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneCommanderFlightHeight] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneCommanderFlightHeight not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_COMMANDER_MODE_LOST_ACTION, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneCommanderModeLostAction(StateTopicRequest<DroneCommanderModeLostAction> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneCommanderModeLostAction] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneCommanderModeLostAction not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_RTH_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneRthMode(StateTopicRequest<DroneRthMode> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneRthMode] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneRthMode not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_CURRENT_RTH_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneCurrentRthMode(StateTopicRequest<DroneCurrentRthMode> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneCurrentRthMode] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneCurrentRthMode not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = GatewayThing.DOCK2)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_DONGLE_INFOS, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneDongleInfos(StateTopicRequest<DroneDongleInfos> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneDongleInfos] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneDongleInfos not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_CAMERA_WATERMARK_SETTINGS, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneCameraWatermarkSettings(StateTopicRequest<DroneCameraWatermarkSettings> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneCameraWatermarkSettings] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneCameraWatermarkSettings not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DRONE_MODE_CODE_REASON, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> droneModeCodeReason(StateTopicRequest<DroneModeCodeReason> request, MessageHeaders headers) throws RestException {
        log.error("the service of [droneModeCodeReason] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("droneModeCodeReason not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_THERMAL_SUPPORTED_PALETTE_STYLE)
    public void dockThermalSupportedPaletteStyle(StateTopicRequest<DockThermalSupportedPaletteStyle> request, MessageHeaders headers) throws RestException {
        log.error("the service of [dockThermalSupportedPaletteStyle] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("dockThermalSupportedPaletteStyle not implemented.");
    }

    @DjisdkVersion(since = CloudsdkVersion.V1_0_2, include = GatewayThing.DOCK)
    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_SILENT_MODE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockSilentMode(StateTopicRequest<DockSilentMode> request, MessageHeaders headers) throws RestException {
        log.error("the service of [dockSilentMode] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("dockSilentMode not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_WIRELESS_LINK_TOPO, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockWirelessLinkTopo(StateTopicRequest<DockWirelessLinkTopo> request, MessageHeaders headers) throws RestException {
        log.error("the service of [dockWirelessLinkTopo] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("dockWirelessLinkTopo not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_AIR_TRANSFER_ENABLE, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockAirTransferEnable(StateTopicRequest<DockAirTransferEnable> request, MessageHeaders headers) throws RestException {
        log.error("the service of [dockAirTransferEnable] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("dockAirTransferEnable not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_DOCK_FLYSAFE_DATABASE_VERSION, outputChannel = DjisdkChannels.OUTBOUND_STATE)
    public StateTopicResponse<MqttReplyResult<?>> dockFlysafeDatabaseVersion(StateTopicRequest<DockFlysafeDatabaseVersion> request, MessageHeaders headers) throws RestException {
        log.error("the service of [dockFlysafeDatabaseVersion] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("dockFlysafeDatabaseVersion not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_PAYLOAD_FIRMWARE)
    public void rcPayloadFirmwareVersion(StateTopicRequest<RcPayloadFirmwareVersion> request, MessageHeaders headers) throws RestException {
        log.error("the service of [rcPayloadFirmwareVersion] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("rcPayloadFirmwareVersion not implemented.");
    }

    @ServiceActivator(inputChannel = StateChannels.INBOUND_STATE_RC_CLOUD_CONTROL_AUTH)
    public void rcCloudControlAuth(StateTopicRequest<RcCloudControlAuth> request, MessageHeaders headers) throws RestException {
        log.error("the service of [rcCloudControlAuth] is default, no method to handle it, \n===> request: {}, \n===> headers: {}", JacksonUtils.parseJson(request), JacksonUtils.parseJson(headers));
        throw new MethodLackError("rcCloudControlAuth not implemented.");
    }

}
