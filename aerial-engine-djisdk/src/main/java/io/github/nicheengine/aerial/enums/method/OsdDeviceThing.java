package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.model.device.osd.OsdDock;
import io.github.nicheengine.aerial.model.device.osd.OsdDockDrone;
import io.github.nicheengine.aerial.model.device.osd.OsdRcDrone;
import io.github.nicheengine.aerial.model.device.osd.OsdRemoteControl;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nicheengine.aerial.mqtt.channel.OsdChannels;
import io.github.nichetoolkit.rest.RestItem;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.*;


public enum OsdDeviceThing implements RestItem<Class<?>, String, Set<GatewayThing>> {

    RC(OsdRemoteControl.class, OsdChannels.INBOUND_OSD_RC, true, GatewayThing.REMOTER_CONTROL),

    DOCK(OsdDock.class, OsdChannels.INBOUND_OSD_DOCK, true, GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3),

    RC_DRONE(OsdRcDrone.class, OsdChannels.INBOUND_OSD_RC_DRONE, false, GatewayThing.REMOTER_CONTROL),

    DOCK_DRONE(OsdDockDrone.class, OsdChannels.INBOUND_OSD_DOCK_DRONE, false, GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3),

    UNKNOWN(Object.class, MqttChannels.DEFAULT, false);
    
    private final Set<GatewayThing> gatewayThings = new HashSet<>();

    private final Class<?> type;
    @Getter
    private final String channel;
    @Getter
    private final boolean gateway;

    OsdDeviceThing(Class<?> type, String channel, boolean gateway, GatewayThing... gatewayThings) {
        this.type = type;
        this.channel = channel;
        this.gateway = gateway;
        Collections.addAll(this.gatewayThings, gatewayThings);
    }

    @Override
    public Set<GatewayThing> getItem() {
        return this.gatewayThings;
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
    public static OsdDeviceThing parseKey(Class<?> key) {
        OsdDeviceThing parsedKey = RestKey.parseKey(OsdDeviceThing.class, key);
        return Optional.ofNullable(parsedKey).orElse(OsdDeviceThing.UNKNOWN);
    }

    public static OsdDeviceThing parseDevice(GatewayThing gatewayThing, boolean isGateway) {
        Optional<OsdDeviceThing> parsedDevice = Arrays.stream(values()).filter(deviceThing -> deviceThing.gatewayThings.contains(gatewayThing) && deviceThing.gateway == isGateway).findAny();
        return parsedDevice.orElse(OsdDeviceThing.UNKNOWN);
    }
}
