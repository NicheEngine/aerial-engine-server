package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsLevel implements RestKey<Integer>{

    INFORM(0),

    NOTICE(1),

    ALARM(2),

    UNKNOWN(-1),

    ;
    private final Integer level;

    HmsLevel(Integer level) {
        this.level = level;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return level;
    }

    @JsonCreator
    public static HmsLevel parseKey(Integer key) {
        HmsLevel parsedKey = RestKey.parseKey(HmsLevel.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsLevel.UNKNOWN);
    }

}
