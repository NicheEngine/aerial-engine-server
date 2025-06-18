package io.github.nicheengine.aerial.mqtt.channel;

public interface DrcUpChannels {
    String INBOUND_DRC_UP_DRONE_CONTROL = "inboundDrcUpDroneControl";

    String INBOUND_DRC_UP_DRONE_EMERGENCY_STOP = "inboundDrcUpDroneEmergencyStop";

    String INBOUND_DRC_UP_HEART_BEAT = "inboundDrcUpHeartBeat";

    String INBOUND_DRC_UP_HSI_INFO_PUSH = "inboundDrcUpHsiInfoPush";

    String INBOUND_DRC_UP_DELAY_INFO_PUSH = "inboundDrcUpDelayInfoPush";

    String INBOUND_DRC_UP_OSD_INFO_PUSH = "inboundDrcUpOsdInfoPush";
}
