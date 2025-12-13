package io.github.nicheengine.aerial;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.device.*;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestState;

public interface AerialDeviceType extends RestKey<Integer>, RestState<Integer> {

    AerialDeviceType UNKNOWN = () -> -1;

    @JsonValue
    @Override
    default Integer getKey() {
        return getType();
    }

    Integer getType();

    @Override
    default String getName() {
        return "deviceType";
    }

    static AerialDeviceType parseKey(ThingType thingType, Integer key) {
        switch (thingType) {
            case DOCK:
                return DeviceDock.parseKey(key);
            case RC:
                return DeviceRC.parseKey(key);
            case DRONE:
                return DeviceDrone.parseKey(key);
            case CAMERA:
                return DeviceCamera.parseKey(key);
            case UNKNOWN:
                default:
                    return UNKNOWN;
        }
    }


}
