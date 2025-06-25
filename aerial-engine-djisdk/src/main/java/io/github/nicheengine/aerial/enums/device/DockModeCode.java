package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DockModeCode implements RestKey<Integer>{
    IDLE(0),

    DEBUGGING(1),

    REMOTE_DEBUGGING(2),

    UPGRADING(3),

    WORKING(4),

    UNKNOWN(-1),
    ;
    private final Integer code;

    DockModeCode(Integer code) {
        this.code = code;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return code;
    }

    @JsonCreator
    public static DockModeCode parseKey(Integer key) {
        DockModeCode parsedKey = RestKey.parseKey(DockModeCode.class, key);
        return Optional.ofNullable(parsedKey).orElse(DockModeCode.UNKNOWN);
    }

}
