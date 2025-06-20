package io.github.nicheengine.aerial.enums.airsense;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WarningLevel implements RestKey<Integer>{
    ZERO(0),

    ONE(1),

    TWO(2),

    THREE(3),

    FOUR(4),

    UNKNOWN(-1),

    ;
    private final Integer level;

    WarningLevel(Integer level) {
        this.level = level;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return level;
    }

    @JsonCreator
    public static WarningLevel parseKey(Integer key) {
        WarningLevel parsedKey = RestKey.parseKey(WarningLevel.class, key);
        return Optional.ofNullable(parsedKey).orElse(WarningLevel.UNKNOWN);
    }

}
