package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum GearType implements RestKey<Integer>{
    A(0),

    P(1),

    NAV(2),

    FPV(3),

    FARM(4),

    S(5),

    F(6),

    M(7),

    G(8),

    T(9),

    UNKNOWN(-1),
    ;
    private final Integer type;

    GearType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static GearType parseKey(Integer key) {
        GearType parsedKey = RestKey.parseKey(GearType.class, key);
        return Optional.ofNullable(parsedKey).orElse(GearType.UNKNOWN);
    }

}
