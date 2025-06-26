package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LastPointType implements RestKey<Integer> {

    OVER_THE_HOME_POINT(0),

    NOT_OVER_THE_HOME_POINT(1),

    UNKNOWN(-1),
    ;

    private final Integer type;

    LastPointType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.type;
    }

    @JsonCreator
    public static LastPointType parseKey(Integer key) {
        LastPointType parsedKey = RestKey.parseKey(LastPointType.class, key);
        return Optional.ofNullable(parsedKey).orElse(LastPointType.UNKNOWN);
    }
}
