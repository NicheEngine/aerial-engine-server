package io.github.nicheengine.aerial.manager;

import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nicheengine.aerial.enums.device.DeviceSubtype;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import io.github.nicheengine.aerial.error.AerialErrorConstants;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.AerialServiceLackError;
import io.github.nichetoolkit.rest.util.I18nUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DjisdkManager {

    //TODO use redis
    private static final ConcurrentHashMap<String, GatewayManager> DJISDK_CACHES = new ConcurrentHashMap<>(16);

    public static GatewayManager deviceSdk(String gatewaySn) {
//        OptionalUtils.ofFalseThrowError(DJISDK_CACHES.containsKey(gatewaySn),() -> new AerialServiceLackError(AerialErrorStatus.AERIAL_DEVICE_UNREGISTERED, I18nUtils.message(AerialErrorConstants.AERIAL_DEVICE_UNREGISTERED_ERROR)));
        return DJISDK_CACHES.get(gatewaySn);
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
