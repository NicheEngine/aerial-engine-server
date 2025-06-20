package io.github.nicheengine.aerial.enums.airsense;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum VertTrend implements RestKey<Integer>{

    RELATIVE_HEIGHT_UNCHANGED(0),

    RELATIVE_HEIGHT_INCREASE(1),

    RELATIVE_HEIGHT_DECREASE(2),

    UNKNOWN(-1),

    ;
    private final Integer type;

    VertTrend(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static VertTrend parseKey(Integer key) {
        VertTrend parsedKey = RestKey.parseKey(VertTrend.class, key);
        return Optional.ofNullable(parsedKey).orElse(VertTrend.UNKNOWN);
    }

}
