package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.AerialDeviceThing;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>DeviceThing</code>
 * <p>The device thing enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nicheengine.aerial.AerialDeviceThing
 * @since Jdk1.8
 */
public enum DeviceThing implements AerialDeviceThing {

    /**
     * <code>DOCK</code>
     * <p>The dock device thing field.</p>
     */
    DOCK(DeviceDomain.DOCK, DeviceDock.DOCK, DeviceSubtype.ZERO),
    /**
     * <code>DOCK2</code>
     * <p>The dock 2 device thing field.</p>
     */
    DOCK2(DeviceDomain.DOCK, DeviceDock.DOCK2, DeviceSubtype.ZERO),
    /**
     * <code>DOCK3</code>
     * <p>The dock 3 device thing field.</p>
     */
    DOCK3(DeviceDomain.DOCK, DeviceDock.DOCK3, DeviceSubtype.ZERO),


    /**
     * <code>M400</code>
     * <p>The m 400 device thing field.</p>
     */
    M400(DeviceDomain.DRONE, DeviceDrone.M400, DeviceSubtype.ZERO),
    /**
     * <code>M350</code>
     * <p>The m 350 device thing field.</p>
     */
    M350(DeviceDomain.DRONE, DeviceDrone.M350, DeviceSubtype.ZERO),
    /**
     * <code>M300</code>
     * <p>The m 300 device thing field.</p>
     */
    M300(DeviceDomain.DRONE, DeviceDrone.M300, DeviceSubtype.ZERO),
    /**
     * <code>M30</code>
     * <p>The m 30 device thing field.</p>
     */
    M30(DeviceDomain.DRONE, DeviceDrone.M30, DeviceSubtype.ZERO),
    /**
     * <code>M30T</code>
     * <p>The m 30 t device thing field.</p>
     */
    M30T(DeviceDomain.DRONE, DeviceDrone.M30T, DeviceSubtype.ONE),
    /**
     * <code>M3E</code>
     * <p>The m 3 e device thing field.</p>
     */
    M3E(DeviceDomain.DRONE, DeviceDrone.M3E, DeviceSubtype.ZERO),
    /**
     * <code>M3T</code>
     * <p>The m 3 t device thing field.</p>
     */
    M3T(DeviceDomain.DRONE, DeviceDrone.M3T, DeviceSubtype.ONE),
    /**
     * <code>M3M</code>
     * <p>The m 3 m device thing field.</p>
     */
    M3M(DeviceDomain.DRONE, DeviceDrone.M3M, DeviceSubtype.TWO),
    /**
     * <code>M3D</code>
     * <p>The m 3 d device thing field.</p>
     */
    M3D(DeviceDomain.DRONE, DeviceDrone.M3D, DeviceSubtype.ZERO),
    /**
     * <code>M3TD</code>
     * <p>The m 3 td device thing field.</p>
     */
    M3TD(DeviceDomain.DRONE, DeviceDrone.M3TD, DeviceSubtype.ONE),
    /**
     * <code>M4D</code>
     * <p>The m 4 d device thing field.</p>
     */
    M4D(DeviceDomain.DRONE, DeviceDrone.M4D, DeviceSubtype.ZERO),
    /**
     * <code>M4TD</code>
     * <p>The m 4 td device thing field.</p>
     */
    M4TD(DeviceDomain.DRONE, DeviceDrone.M4TD, DeviceSubtype.ONE),
    /**
     * <code>M4E</code>
     * <p>The m 4 e device thing field.</p>
     */
    M4E(DeviceDomain.DRONE, DeviceDrone.M4E, DeviceSubtype.ZERO),
    /**
     * <code>M4T</code>
     * <p>The m 4 t device thing field.</p>
     */
    M4T(DeviceDomain.DRONE, DeviceDrone.M4T, DeviceSubtype.ONE),


    /**
     * <code>RC</code>
     * <p>The rc device thing field.</p>
     */
    RC(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC, DeviceSubtype.ZERO),
    /**
     * <code>RC_PLUS</code>
     * <p>The rc plus device thing field.</p>
     */
    RC_PLUS(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC_PLUS, DeviceSubtype.ZERO),
    /**
     * <code>RC_PLUS_2</code>
     * <p>The rc plus 2 device thing field.</p>
     */
    RC_PLUS_2(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC_PLUS_2, DeviceSubtype.ZERO),
    /**
     * <code>RC_PRO</code>
     * <p>The rc pro device thing field.</p>
     */
    RC_PRO(DeviceDomain.REMOTER_CONTROL, DeviceRC.RC_PRO, DeviceSubtype.ZERO),


    /**
     * <code>L1_CAMERA</code>
     * <p>The l 1 camera device thing field.</p>
     * @see java.lang.Deprecated
     * @deprecated <p>The <code>L1_CAMERA</code> field has be deprecated.</p>
     */
    @Deprecated
    L1_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.L1_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>P1_CAMERA</code>
     * <p>The p 1 camera device thing field.</p>
     * @see java.lang.Deprecated
     * @deprecated <p>The <code>P1_CAMERA</code> field has be deprecated.</p>
     */
    @Deprecated
    P1_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.P1_CAMERA, DeviceSubtype._65535),

    /**
     * <code>DOCK_CAMERA</code>
     * <p>The dock camera device thing field.</p>
     */
    DOCK_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.DOCK_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>FPV_CAMERA</code>
     * <p>The fpv camera device thing field.</p>
     */
    FPV_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.FPV_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>FPV_SHADOW_CAMERA</code>
     * <p>The fpv shadow camera device thing field.</p>
     */
    FPV_SHADOW_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.FPV_SHADOW, DeviceSubtype.ZERO),
    /**
     * <code>Z30_CAMERA</code>
     * <p>The z 30 camera device thing field.</p>
     */
    Z30_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.Z30_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>XT2_CAMERA</code>
     * <p>The xt 2 camera device thing field.</p>
     */
    XT2_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.XT2_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>XTS_CAMERA</code>
     * <p>The xts camera device thing field.</p>
     */
    XTS_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.XTS_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>H20_CAMERA</code>
     * <p>The h 20 camera device thing field.</p>
     */
    H20_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H20_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>H20T_CAMERA</code>
     * <p>The h 20 t camera device thing field.</p>
     */
    H20T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H20T_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>H20N_CAMERA</code>
     * <p>The h 20 n camera device thing field.</p>
     */
    H20N_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H20N_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>H30_CAMERA</code>
     * <p>The h 30 camera device thing field.</p>
     */
    H30_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H30_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>H30T_CAMERA</code>
     * <p>The h 30 t camera device thing field.</p>
     */
    H30T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.H30T_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M30_CAMERA</code>
     * <p>The m 30 camera device thing field.</p>
     */
    M30_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M30_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M30T_CAMERA</code>
     * <p>The m 30 t camera device thing field.</p>
     */
    M30T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M30T_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M4E_CAMERA</code>
     * <p>The m 4 e camera device thing field.</p>
     */
    M4E_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4E_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M4T_CAMERA</code>
     * <p>The m 4 t camera device thing field.</p>
     */
    M4T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4T_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M3E_CAMERA</code>
     * <p>The m 3 e camera device thing field.</p>
     */
    M3E_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3E_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M3T_CAMERA</code>
     * <p>The m 3 t camera device thing field.</p>
     */
    M3T_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3T_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M3M_CAMERA</code>
     * <p>The m 3 m camera device thing field.</p>
     */
    M3M_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3M_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M3D_CAMERA</code>
     * <p>The m 3 d camera device thing field.</p>
     */
    M3D_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3D_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M3TD_CAMERA</code>
     * <p>The m 3 td camera device thing field.</p>
     */
    M3TD_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M3TD_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M4D_CAMERA</code>
     * <p>The m 4 d camera device thing field.</p>
     */
    M4D_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4D_CAMERA, DeviceSubtype.ZERO),
    /**
     * <code>M4TD_CAMERA</code>
     * <p>The m 4 td camera device thing field.</p>
     */
    M4TD_CAMERA(DeviceDomain.PAYLOAD, DeviceCamera.M4TD_CAMERA, DeviceSubtype.ZERO),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown device thing field.</p>
     */
    UNKNOWN(DeviceDomain.UNKNOWN, DeviceCamera.UNKNOWN, DeviceSubtype.UNKNOWN),
    ;

    /**
     * <code>key</code>
     * {@link io.github.nicheengine.aerial.enums.device.DeviceDomain} <p>The <code>key</code> field.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceDomain
     */
    private final DeviceDomain key;

    /**
     * <code>value</code>
     * {@link io.github.nicheengine.aerial.AerialDeviceType} <p>The <code>value</code> field.</p>
     * @see io.github.nicheengine.aerial.AerialDeviceType
     */
    private final AerialDeviceType value;

    /**
     * <code>item</code>
     * {@link io.github.nicheengine.aerial.enums.device.DeviceSubtype} <p>The <code>item</code> field.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceSubtype
     */
    private final DeviceSubtype item;

    /**
     * <code>DeviceThing</code>
     * <p>Instantiates a new device thing.</p>
     * @param deviceDomain  {@link io.github.nicheengine.aerial.enums.device.DeviceDomain} <p>The device domain parameter is <code>DeviceDomain</code> type.</p>
     * @param deviceType    {@link io.github.nicheengine.aerial.AerialDeviceType} <p>The device type parameter is <code>AerialDeviceType</code> type.</p>
     * @param deviceSubtype {@link io.github.nicheengine.aerial.enums.device.DeviceSubtype} <p>The device subtype parameter is <code>DeviceSubtype</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceDomain
     * @see io.github.nicheengine.aerial.AerialDeviceType
     * @see io.github.nicheengine.aerial.enums.device.DeviceSubtype
     */
    DeviceThing(DeviceDomain deviceDomain, AerialDeviceType deviceType, DeviceSubtype deviceSubtype) {
        this.key = deviceDomain;
        this.value = deviceType;
        this.item = deviceSubtype;
    }

    @Override
    public DeviceSubtype getItem() {
        return this.item;
    }

    @Override
    public AerialDeviceType getValue() {
        return this.value;
    }

    @Override
    public DeviceDomain getKey() {
        return this.key;
    }

    /**
     * <code>parseDevice</code>
     * <p>The parse device method.</p>
     * @param key {@link java.lang.String} <p>The key parameter is <code>String</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceThing} <p>The parse device return object is <code>DeviceThing</code> type.</p>
     * @see java.lang.String
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static DeviceThing parseDevice(String key) {
        DeviceThing parsedKey = RestKey.parseKey(DeviceThing.class, key, AerialDeviceThing::getDeviceKey);
        return Optional.ofNullable(parsedKey).orElse(DeviceThing.UNKNOWN);
    }

    /**
     * <code>parseDevice</code>
     * <p>The parse device method.</p>
     * @param deviceDomain  {@link io.github.nicheengine.aerial.enums.device.DeviceDomain} <p>The device domain parameter is <code>DeviceDomain</code> type.</p>
     * @param deviceType    {@link io.github.nicheengine.aerial.AerialDeviceType} <p>The device type parameter is <code>AerialDeviceType</code> type.</p>
     * @param deviceSubtype {@link io.github.nicheengine.aerial.enums.device.DeviceSubtype} <p>The device subtype parameter is <code>DeviceSubtype</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceThing} <p>The parse device return object is <code>DeviceThing</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceDomain
     * @see io.github.nicheengine.aerial.AerialDeviceType
     * @see io.github.nicheengine.aerial.enums.device.DeviceSubtype
     */
    public static DeviceThing parseDevice(DeviceDomain deviceDomain, AerialDeviceType deviceType, DeviceSubtype deviceSubtype) {
        return DeviceThing.parseDevice(deviceDomain.getDomain(), deviceType.getType(), deviceSubtype.getSubtype());
    }

    /**
     * <code>parseDevice</code>
     * <p>The parse device method.</p>
     * @param domain  int <p>The domain parameter is <code>int</code> type.</p>
     * @param type    int <p>The type parameter is <code>int</code> type.</p>
     * @param subtype int <p>The subtype parameter is <code>int</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceThing} <p>The parse device return object is <code>DeviceThing</code> type.</p>
     */
    public static DeviceThing parseDevice(int domain, int type, int subtype) {
        String deviceKey = AerialDeviceThing.deviceKey(domain, type, subtype);
        return DeviceThing.parseDevice(deviceKey);
    }
}
