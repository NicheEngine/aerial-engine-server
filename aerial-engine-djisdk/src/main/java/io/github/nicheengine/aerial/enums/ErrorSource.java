package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

public enum ErrorSource implements AerialDeviceType {

    DEVICE(3),

    DOCK(5),

    PILOT(6),

    UNKNOWN(99999),
    ;

    private final Integer key;

    ErrorSource(Integer key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.key;
    }

    public Integer getSource() {
        return key;
    }

    @JsonCreator
    public static ErrorSource parseKey(Integer key) {
        ErrorSource parsedKey = RestKey.parseKey(ErrorSource.class, key);
        return Optional.ofNullable(parsedKey).orElse(ErrorSource.UNKNOWN);
    }
}
