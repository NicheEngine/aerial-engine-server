package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum NetworkStateQuality implements RestKey<Integer>{

    NO_SIGNAL(0),

    BAD(1),

    POOR(2),

    FAIR(3),

    GOOD(4),

    EXCELLENT(5),

    UNKNOWN(-1),
    ;
    private final Integer quality;

    NetworkStateQuality(Integer quality) {
        this.quality = quality;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return quality;
    }

    @JsonCreator
    public static NetworkStateQuality parseKey(Integer key) {
        NetworkStateQuality parsedKey = RestKey.parseKey(NetworkStateQuality.class, key);
        return Optional.ofNullable(parsedKey).orElse(NetworkStateQuality.UNKNOWN);
    }

}
