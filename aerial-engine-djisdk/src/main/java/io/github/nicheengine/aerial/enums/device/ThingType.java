package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestState;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ThingType implements RestValue<Integer, Class<? extends AerialDeviceType>>, RestState<Integer> {

    DOCK(1, DeviceDock.class),

    DRONE(2, DeviceDrone.class),

    RC(3, DeviceRC.class),

    CAMERA(4, DeviceCamera.class),

    UNKNOWN(-1, AerialDeviceType.class),
    ;

    private final Integer type;

    private final Class<? extends AerialDeviceType> thing;

    ThingType(Integer type, Class<? extends AerialDeviceType> thing) {
        this.type = type;
        this.thing = thing;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.type;
    }

    @Override
    public Class<? extends AerialDeviceType> getValue() {
        return this.thing;
    }

    @JsonCreator
    public static ThingType parseKey(Integer key) {
        ThingType parsedKey = RestKey.parseKey(ThingType.class, key);
        return Optional.ofNullable(parsedKey).orElse(ThingType.UNKNOWN);
    }

}
