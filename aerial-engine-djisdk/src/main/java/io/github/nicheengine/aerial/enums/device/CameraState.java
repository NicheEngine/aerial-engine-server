package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CameraState implements RestKey<Integer> {

    IDLE(0),

    WORKING(1),

    UNKNOWN(-1),
    ;

    private final Integer state;

    CameraState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static CameraState parseKey(Integer key) {
        CameraState parsedKey = RestKey.parseKey(CameraState.class, key);
        return Optional.ofNullable(parsedKey).orElse(CameraState.UNKNOWN);
    }
}
