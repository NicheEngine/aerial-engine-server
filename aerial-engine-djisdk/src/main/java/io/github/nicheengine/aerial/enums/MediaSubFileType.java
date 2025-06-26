package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MediaSubFileType implements RestKey<Integer> {

    NORMAL(0),

    PANORAMA(1),

    UNKNOWN(-1),
    ;

    private final Integer type;

    MediaSubFileType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.type;
    }

    @JsonCreator
    public static MediaSubFileType parseKey(Integer key) {
        MediaSubFileType parsedKey = RestKey.parseKey(MediaSubFileType.class, key);
        return Optional.ofNullable(parsedKey).orElse(MediaSubFileType.UNKNOWN);
    }
}
