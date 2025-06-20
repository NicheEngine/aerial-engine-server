package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.AerialDeviceThing;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DeviceThing implements AerialDeviceThing {

    DOCK(DeviceDomain.DOCK, DeviceDock.DOCK, DeviceSubtype.ZERO),
    DOCK2(DeviceDomain.DOCK, DeviceDock.DOCK2, DeviceSubtype.ZERO),
    DOCK3(DeviceDomain.DOCK, DeviceDock.DOCK3, DeviceSubtype.ZERO),


    M400(DeviceDomain.DRONE, DeviceDrone.M400, DeviceSubtype.ZERO),
    M350(DeviceDomain.DRONE, DeviceDrone.M350, DeviceSubtype.ZERO),
    M300(DeviceDomain.DRONE, DeviceDrone.M300, DeviceSubtype.ZERO),
    M30(DeviceDomain.DRONE, DeviceDrone.M30, DeviceSubtype.ZERO),
    M30T(DeviceDomain.DRONE, DeviceDrone.M30T, DeviceSubtype.ONE),
    M3E(DeviceDomain.DRONE, DeviceDrone.M3E, DeviceSubtype.ZERO),
    M3T(DeviceDomain.DRONE, DeviceDrone.M3T, DeviceSubtype.ONE),
    M3M(DeviceDomain.DRONE, DeviceDrone.M3M, DeviceSubtype.TWO),
    M3D(DeviceDomain.DRONE, DeviceDrone.M3D, DeviceSubtype.ZERO),
    M3TD(DeviceDomain.DRONE, DeviceDrone.M3TD, DeviceSubtype.ONE),
    M4D(DeviceDomain.DRONE, DeviceDrone.M4D, DeviceSubtype.ZERO),
    M4TD(DeviceDomain.DRONE, DeviceDrone.M4TD, DeviceSubtype.ONE),
    M4E(DeviceDomain.DRONE, DeviceDrone.M4E, DeviceSubtype.ZERO),
    M4T(DeviceDomain.DRONE, DeviceDrone.M4T, DeviceSubtype.ONE),


    RC(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC, DeviceSubtype.ZERO),
    RC_PLUS(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC_PLUS, DeviceSubtype.ZERO),
    RC_PLUS_2(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC_PLUS_2, DeviceSubtype.ZERO),
    RC_PRO(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC_PRO, DeviceSubtype.ZERO),


    @Deprecated
    L1_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.L1_CAMERA, DeviceSubtype.ZERO),
    @Deprecated
    P1_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.P1_CAMERA, DeviceSubtype._65535),

    DOCK_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.DOCK_CAMERA, DeviceSubtype.ZERO),
    FPV_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.FPV_CAMERA, DeviceSubtype.ZERO),
    FPV_SHADOW_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.FPV_SHADOW, DeviceSubtype.ZERO),
    Z30_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.Z30_CAMERA, DeviceSubtype.ZERO),
    XT2_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.XT2_CAMERA, DeviceSubtype.ZERO),
    XTS_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.XTS_CAMERA, DeviceSubtype.ZERO),
    H20_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H20_CAMERA, DeviceSubtype.ZERO),
    H20T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H20T_CAMERA, DeviceSubtype.ZERO),
    H20N_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H20N_CAMERA, DeviceSubtype.ZERO),
    H30_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H30_CAMERA, DeviceSubtype.ZERO),
    H30T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H30T_CAMERA, DeviceSubtype.ZERO),
    M30_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M30_CAMERA, DeviceSubtype.ZERO),
    M30T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M30T_CAMERA, DeviceSubtype.ZERO),
    M4E_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4E_CAMERA, DeviceSubtype.ZERO),
    M4T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4T_CAMERA, DeviceSubtype.ZERO),
    M3E_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3E_CAMERA, DeviceSubtype.ZERO),
    M3T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3T_CAMERA, DeviceSubtype.ZERO),
    M3M_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3M_CAMERA, DeviceSubtype.ZERO),
    M3D_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3D_CAMERA, DeviceSubtype.ZERO),
    M3TD_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3TD_CAMERA, DeviceSubtype.ZERO),
    M4D_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4D_CAMERA, DeviceSubtype.ZERO),
    M4TD_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4TD_CAMERA, DeviceSubtype.ZERO),

    UNKNOWN(DeviceDomain.UNKNOWN, DeviceCamera.UNKNOWN, DeviceSubtype.UNKNOWN),
    ;

    private final DeviceDomain deviceDomain;

    private final AerialDeviceType deviceType;

    private final DeviceSubtype deviceSubtype;

    DeviceThing(DeviceDomain deviceDomain, AerialDeviceType deviceType, DeviceSubtype deviceSubtype) {
        this.deviceDomain = deviceDomain;
        this.deviceType = deviceType;
        this.deviceSubtype = deviceSubtype;
    }

    @JsonCreator
    public static DeviceThing parseDevice(String key) {
        DeviceThing parsedKey = RestKey.parseKey(DeviceThing.class, key, AerialDeviceThing::getDeviceKey);
        return Optional.ofNullable(parsedKey).orElse(DeviceThing.UNKNOWN);
    }

    public static DeviceThing parseDevice(DeviceDomain deviceDomain, AerialDeviceType deviceType, DeviceSubtype deviceSubtype) {
        return DeviceThing.parseDevice(deviceDomain.getDomain(), deviceType.getType(), deviceSubtype.getSubtype());
    }

    public static DeviceThing parseDevice(int domain, int type, int subtype) {
        String deviceKey = AerialDeviceThing.deviceKey(domain, type, subtype);
        return DeviceThing.parseDevice(deviceKey);
    }
}
