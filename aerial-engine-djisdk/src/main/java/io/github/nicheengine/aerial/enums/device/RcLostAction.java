package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum RcLostAction implements RestKey<Integer>{

    HOVER(0),

    LAND(1),

    RETURN_HOME(2),

    UNKNOWN(-1),

    ;
    private final Integer action;

    RcLostAction(Integer action) {
        this.action = action;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return action;
    }

    @JsonCreator
    public static RcLostAction parseKey(Integer key) {
        RcLostAction parsedKey = RestKey.parseKey(RcLostAction.class, key);
        return Optional.ofNullable(parsedKey).orElse(RcLostAction.UNKNOWN);
    }

}
