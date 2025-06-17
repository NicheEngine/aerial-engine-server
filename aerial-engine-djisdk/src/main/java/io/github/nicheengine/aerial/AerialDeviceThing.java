package io.github.nicheengine.aerial;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nicheengine.aerial.enums.device.DeviceSubtype;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nichetoolkit.rest.RestItem;

import java.util.Arrays;

/**
 * <code>AerialDeviceThing</code>
 * <p>The aerial device thing interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestItem
 * @since Jdk1.8
 */
public interface AerialDeviceThing extends RestItem<DeviceDomain, AerialDeviceType, DeviceSubtype> {

    /**
     * <code>getDeviceDomain</code>
     * <p>The get device domain getter method.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceDomain} <p>The get device domain return object is <code>DeviceDomain</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceDomain
     */
    default DeviceDomain getDeviceDomain() {
        return getKey();
    }

    /**
     * <code>getDeviceType</code>
     * <p>The get device type getter method.</p>
     * @return {@link io.github.nicheengine.aerial.AerialDeviceType} <p>The get device type return object is <code>AerialDeviceType</code> type.</p>
     * @see io.github.nicheengine.aerial.AerialDeviceType
     */
    default AerialDeviceType getDeviceType() {
        return getValue();
    }

    /**
     * <code>getDeviceSubtype</code>
     * <p>The get device subtype getter method.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceSubtype} <p>The get device subtype return object is <code>DeviceSubtype</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceSubtype
     */
    default DeviceSubtype getDeviceSubtype() {
        return getItem();
    }

    /**
     * <code>getDeviceKey</code>
     * <p>The get device key getter method.</p>
     * @return {@link java.lang.String} <p>The get device key return object is <code>String</code> type.</p>
     * @see java.lang.String
     * @see com.fasterxml.jackson.annotation.JsonValue
     */
    @JsonValue
    default String getDeviceKey() {
        return AerialDeviceThing.deviceKey(getDeviceDomain(), getDeviceType(), getDeviceSubtype());
    }

    /**
     * <code>deviceKey</code>
     * <p>The device key method.</p>
     * @param deviceDomain  {@link io.github.nicheengine.aerial.enums.device.DeviceDomain} <p>The device domain parameter is <code>DeviceDomain</code> type.</p>
     * @param deviceType    {@link io.github.nicheengine.aerial.AerialDeviceType} <p>The device type parameter is <code>AerialDeviceType</code> type.</p>
     * @param deviceSubtype {@link io.github.nicheengine.aerial.enums.device.DeviceSubtype} <p>The device subtype parameter is <code>DeviceSubtype</code> type.</p>
     * @return {@link java.lang.String} <p>The device key return object is <code>String</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceDomain
     * @see io.github.nicheengine.aerial.AerialDeviceType
     * @see io.github.nicheengine.aerial.enums.device.DeviceSubtype
     * @see java.lang.String
     */
    static String deviceKey(DeviceDomain deviceDomain, AerialDeviceType deviceType, DeviceSubtype deviceSubtype) {
        return AerialDeviceThing.deviceKey(deviceDomain.getDomain(), deviceType.getType(), deviceSubtype.getSubtype());
    }

    /**
     * <code>deviceKey</code>
     * <p>The device key method.</p>
     * @param domain  int <p>The domain parameter is <code>int</code> type.</p>
     * @param type    int <p>The type parameter is <code>int</code> type.</p>
     * @param subtype int <p>The subtype parameter is <code>int</code> type.</p>
     * @return {@link java.lang.String} <p>The device key return object is <code>String</code> type.</p>
     * @see java.lang.String
     */
    static String deviceKey(int domain, int type, int subtype) {
        return String.format("%s-%s-%s", domain, type, subtype);
    }


}
