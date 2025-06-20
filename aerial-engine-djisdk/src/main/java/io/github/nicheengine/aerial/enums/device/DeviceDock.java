package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DeviceDock implements AerialDeviceType {

    DOCK(1),

    DOCK2(2),

    DOCK3(3),

    UNKNOWN(-1),
    ;

    private final Integer type;

    DeviceDock(Integer type) {
        this.type = type;
    }

    @JsonCreator
    public static DeviceDock parseKey(Integer key) {
        DeviceDock parsedKey = RestKey.parseKey(DeviceDock.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceDock.UNKNOWN);
    }
}
