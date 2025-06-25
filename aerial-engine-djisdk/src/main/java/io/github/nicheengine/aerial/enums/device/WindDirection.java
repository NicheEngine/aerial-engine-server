package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WindDirection implements RestKey<Integer>{

    NO(0),

    NORTH(1),

    NORTHEAST(2),

    EAST(3),

    SOUTHEAST(4),

    SOUTH(5),

    SOUTHWEST(6),

    WEST(7),

    NORTHWEST(8),

    UNKNOWN(-1),

    ;
    private final Integer direction;

    WindDirection(Integer direction) {
        this.direction = direction;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return direction;
    }

    @JsonCreator
    public static WindDirection parseKey(Integer key) {
        WindDirection parsedKey = RestKey.parseKey(WindDirection.class, key);
        return Optional.ofNullable(parsedKey).orElse(WindDirection.UNKNOWN);
    }

}
