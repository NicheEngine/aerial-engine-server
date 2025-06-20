package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DeviceSubtype implements RestKey<Integer> {

    ZERO(0),

    ONE(1),

    TWO(2),

    _65535(65535),

    UNKNOWN(-1),
    ;

    private final Integer subtype;

    DeviceSubtype(Integer subtype) {
        this.subtype = subtype;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.subtype;
    }

    @JsonCreator
    public static DeviceSubtype parseKey(Integer key) {
        DeviceSubtype parsedKey = RestKey.parseKey(DeviceSubtype.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceSubtype.UNKNOWN);
    }
}
