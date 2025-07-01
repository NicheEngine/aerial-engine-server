package io.github.nicheengine.aerial.enums.method;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.nicheengine.aerial.model.control.DroneControlResponse;
import io.github.nicheengine.aerial.model.control.HeartBeatRequest;
import io.github.nicheengine.aerial.model.control.info.DelayInfoPush;
import io.github.nicheengine.aerial.model.control.info.HsiInfoPush;
import io.github.nicheengine.aerial.model.control.info.OsdInfoPush;
import io.github.nicheengine.aerial.mqtt.MqttMethod;
import io.github.nicheengine.aerial.mqtt.channel.DrcUpChannels;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nicheengine.aerial.mqtt.drc.DrcUpData;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

public enum DrcUpMethod implements MqttMethod {

    DRONE_CONTROL("drone_control", DrcUpChannels.INBOUND_DRC_UP_DRONE_CONTROL, new TypeReference<DrcUpData<DroneControlResponse>>() {}),

    DRONE_EMERGENCY_STOP("drone_emergency_stop", DrcUpChannels.INBOUND_DRC_UP_DRONE_EMERGENCY_STOP, new TypeReference<DrcUpData<?>>() {}),

    HEART_BEAT("heart_beat", DrcUpChannels.INBOUND_DRC_UP_HEART_BEAT, new TypeReference<HeartBeatRequest>() {}),

    HSI_INFO_PUSH("hsi_info_push", DrcUpChannels.INBOUND_DRC_UP_HSI_INFO_PUSH, new TypeReference<HsiInfoPush>() {}),

    DELAY_INFO_PUSH("delay_info_push", DrcUpChannels.INBOUND_DRC_UP_DELAY_INFO_PUSH, new TypeReference<DelayInfoPush>() {}),

    OSD_INFO_PUSH("osd_info_push", DrcUpChannels.INBOUND_DRC_UP_OSD_INFO_PUSH, new TypeReference<OsdInfoPush>() {}),

    UNKNOWN("", MqttChannels.DEFAULT, new TypeReference<Object>() {})
    ;


    @Getter
    private final String method;
    @Getter
    private final String channel;

    private final TypeReference<?> typeReference;

    DrcUpMethod(String method, String channel, TypeReference<?> typeReference) {
        this.method = method;
        this.channel = channel;
        this.typeReference = typeReference;
    }

    @SuppressWarnings("unchecked")
    public <T> TypeReference<T> getTypeReference() {
        return (TypeReference<T>) this.typeReference;
    }

    @Override
    @JsonValue
    public String getKey() {
        return this.method;
    }

    @JsonCreator
    public static DrcUpMethod parseKey(String key) {
        DrcUpMethod parsedKey = RestKey.parseKey(DrcUpMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(DrcUpMethod.UNKNOWN);
    }

    public static DrcUpMethod parseValue(String value) {
        DrcUpMethod parsedValue = RestValue.parseValue(DrcUpMethod.class, value);
        return Optional.ofNullable(parsedValue).orElse(DrcUpMethod.UNKNOWN);
    }


}
