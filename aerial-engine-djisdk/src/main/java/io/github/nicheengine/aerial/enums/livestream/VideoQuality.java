package io.github.nicheengine.aerial.enums.livestream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum VideoQuality implements RestKey<Integer>{
    AUTO (0),

    SMOOTH(1),

    STANDARD_DEFINITION(2),

    HIGH_DEFINITION(3),

    ULTRA_HD(4),

    UNKNOWN(-1),

    ;
    private final Integer quality;

    VideoQuality(Integer quality) {
        this.quality = quality;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return quality;
    }

    @JsonCreator
    public static VideoQuality parseKey(Integer key) {
        VideoQuality parsedKey = RestKey.parseKey(VideoQuality.class, key);
        return Optional.ofNullable(parsedKey).orElse(VideoQuality.UNKNOWN);
    }

}
