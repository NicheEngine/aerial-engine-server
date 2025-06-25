package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MaintainType implements RestKey<Integer>{
    NO(0),

    DRONE_BASIC(1),

    DRONE_ROUTINE(2),

    DRONE_DEEP(3),

    DOCK_ROUTINE(17),

    DOCK_DEEP(18),

    UNKNOWN(-1),
    ;
    private final Integer type;

    MaintainType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static MaintainType parseKey(Integer key) {
        MaintainType parsedKey = RestKey.parseKey(MaintainType.class, key);
        return Optional.ofNullable(parsedKey).orElse(MaintainType.UNKNOWN);
    }

}
