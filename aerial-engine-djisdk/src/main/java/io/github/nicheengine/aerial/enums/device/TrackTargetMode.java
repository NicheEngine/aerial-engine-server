package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum TrackTargetMode implements RestKey<Integer>{
    NORMAL(1),

    LOW_CREDIBILITY(2),

    PREDICTED(3),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    TrackTargetMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static TrackTargetMode parseKey(Integer key) {
        TrackTargetMode parsedKey = RestKey.parseKey(TrackTargetMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(TrackTargetMode.UNKNOWN);
    }

}
