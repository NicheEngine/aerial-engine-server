package io.github.nicheengine.aerial.enums.livestream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum VideoType implements RestKey<String>{

    ZOOM("zoom"),

    WIDE("wide"),

    THERMAL("thermal"),

    NORMAL("normal"),

    IR("ir"),

    UNKNOWN(""),

    ;
    private final String type;

    VideoType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static VideoType parseKey(String key) {
        VideoType parsedKey = RestKey.parseKey(VideoType.class, key);
        return Optional.ofNullable(parsedKey).orElse(VideoType.UNKNOWN);
    }

}
