package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum RainfallType implements RestKey<Integer>{

    NO(0),

    LIGHT(1),

    MODERATE(2),

    HEAVY(3),

    UNKNOWN(-1),
    ;
    private final Integer type;

    RainfallType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static RainfallType parseKey(Integer key) {
        RainfallType parsedKey = RestKey.parseKey(RainfallType.class, key);
        return Optional.ofNullable(parsedKey).orElse(RainfallType.UNKNOWN);
    }

}
