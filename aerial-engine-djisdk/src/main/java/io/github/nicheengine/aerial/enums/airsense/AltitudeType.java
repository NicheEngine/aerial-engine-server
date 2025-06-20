package io.github.nicheengine.aerial.enums.airsense;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum AltitudeType implements RestKey<Integer>{
    ELLIPSOID_HEIGHT(0),

    ABOVE_SEA_LEVEL(1),

    UNKNOWN(-1),

    ;
    private final Integer level;

    AltitudeType(Integer level) {
        this.level = level;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return level;
    }

    @JsonCreator
    public static AltitudeType parseKey(Integer key) {
        AltitudeType parsedKey = RestKey.parseKey(AltitudeType.class, key);
        return Optional.ofNullable(parsedKey).orElse(AltitudeType.UNKNOWN);
    }

}
