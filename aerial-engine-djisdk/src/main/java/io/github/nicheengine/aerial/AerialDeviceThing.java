package io.github.nicheengine.aerial;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nicheengine.aerial.enums.device.DeviceSubtype;
import io.github.nichetoolkit.rest.RestItem;

public interface AerialDeviceThing extends RestItem<DeviceDomain, AerialDeviceType, DeviceSubtype> {

    @Override
    default DeviceDomain getKey() {
        return getDeviceDomain();
    }

    @Override
    default AerialDeviceType getValue() {
        return getDeviceType();
    }

    @Override
    default DeviceSubtype getItem() {
        return getDeviceSubtype();
    }

    DeviceDomain getDeviceDomain();

    AerialDeviceType getDeviceType();

    DeviceSubtype getDeviceSubtype();


    @JsonValue
    default String getDeviceKey() {
        return AerialDeviceThing.deviceKey(getDeviceDomain(), getDeviceType(), getDeviceSubtype());
    }

    static String deviceKey(DeviceDomain deviceDomain, AerialDeviceType deviceType, DeviceSubtype deviceSubtype) {
        return AerialDeviceThing.deviceKey(deviceDomain.getDomain(), deviceType.getType(), deviceSubtype.getSubtype());
    }

    static String deviceKey(int domain, int type, int subtype) {
        return String.format("%s-%s-%s", domain, type, subtype);
    }


}
