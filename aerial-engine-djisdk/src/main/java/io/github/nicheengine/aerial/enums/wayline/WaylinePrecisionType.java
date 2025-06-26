package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WaylinePrecisionType implements RestKey<Integer> {

    GPS(0),

    RTK(1),

    UNKNOWN(-1),
    ;

    private final Integer type;

    WaylinePrecisionType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.type;
    }

    @JsonCreator
    public static WaylinePrecisionType parseKey(Integer key) {
        WaylinePrecisionType parsedKey = RestKey.parseKey(WaylinePrecisionType.class, key);
        return Optional.ofNullable(parsedKey).orElse(WaylinePrecisionType.UNKNOWN);
    }
}
