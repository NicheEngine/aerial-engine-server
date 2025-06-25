package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CameraMode implements RestKey<Integer>{
    PHOTO(0),

    VIDEO(1),

    LOW_LIGHT_INTELLIGENCE(2),

    PANORAMA(3),

    UNSUPPORTED(-1),

    ;
    private final Integer mode;

    CameraMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static CameraMode parseKey(Integer key) {
        CameraMode parsedKey = RestKey.parseKey(CameraMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(CameraMode.UNSUPPORTED);
    }

}
