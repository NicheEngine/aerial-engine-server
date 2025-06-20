package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DeviceDrone implements AerialDeviceType {
    M400(181),
    M350(89),
    M300(60),
    M30(67),
    M30T(67),
    M3E(77),
    M3T(77),
    M3M(77),
    M3D(91),
    M3TD(91),
    M4D(100),
    M4TD(100),
    M4E(99),
    M4T(99),

    UNKNOWN(-1),
    ;

    private final Integer type;

    DeviceDrone(Integer type) {
        this.type = type;
    }

    @JsonCreator
    public static DeviceDrone parseKey(Integer key) {
        DeviceDrone parsedKey = RestKey.parseKey(DeviceDrone.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceDrone.UNKNOWN);
    }
}
