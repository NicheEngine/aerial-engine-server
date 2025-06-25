package io.github.nicheengine.aerial.manager;

import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nicheengine.aerial.enums.device.DeviceSubtype;
import io.github.nicheengine.aerial.enums.device.DeviceThing;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DjisdkManager {

    //TODO use redis
    private static final ConcurrentHashMap<String, GatewayManager> DJISDK_CACHES = new ConcurrentHashMap<>(16);

    public static GatewayManager deviceSdk(String gatewaySn) {
        return DJISDK_CACHES.get(gatewaySn);
    }

    public static GatewayManager registerDevice(String gatewaySn, String droneSn, DeviceThing deviceThing, String gatewayThingVersion, String droneThingVersion) {
        return registerDevice(gatewaySn, droneSn, GatewayThing.parseGateway(DeviceThing.parseDevice(deviceThing.getDeviceDomain(), deviceThing.getDeviceType(), deviceThing.getDeviceSubtype())), gatewayThingVersion, droneThingVersion);
    }

    public static GatewayManager registerDevice(String gatewaySn, String droneSn,
                                                DeviceDomain deviceDomain, AerialDeviceType deviceType, DeviceSubtype subtype,
                                                String gatewayThingVersion, String droneThingVersion) {
        return registerDevice(gatewaySn, droneSn, GatewayThing.parseGateway(DeviceThing.parseDevice(deviceDomain, deviceType, subtype)), gatewayThingVersion, droneThingVersion);
    }

    public static GatewayManager registerDevice(String gatewaySn, String droneSn, GatewayThing gatewayThing,
                                                String gatewayThingVersion, String droneThingVersion) {
        GatewayManager gatewayManager = new GatewayManager(Objects.requireNonNull(gatewaySn), droneSn, gatewayThing, gatewayThingVersion, droneThingVersion);
        return registerDevice(gatewayManager);
    }

    public static GatewayManager registerDevice(GatewayManager gateway) {
        DJISDK_CACHES.put(gateway.getGatewaySn(), gateway);
        return gateway;
    }

    public static void logoutDevice(String gatewaySn) {
        DJISDK_CACHES.remove(gatewaySn);
    }
}
