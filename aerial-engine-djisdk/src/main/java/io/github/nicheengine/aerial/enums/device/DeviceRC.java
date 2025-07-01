package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DeviceRC implements AerialDeviceType {
    RC(56),
    RC_PLUS(119),
    RC_PLUS_2(174),
    RC_PRO(144),

    UNKNOWN(-1),
    ;

    private final Integer type;

    DeviceRC(Integer type) {
        this.type = type;
    }

    @JsonCreator
    public static DeviceRC parseKey(Integer key) {
        DeviceRC parsedKey = RestKey.parseKey(DeviceRC.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceRC.UNKNOWN);
    }
}
