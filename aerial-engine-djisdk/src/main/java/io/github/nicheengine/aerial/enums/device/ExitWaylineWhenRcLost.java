package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ExitWaylineWhenRcLost implements RestKey<Integer>{

    CONTINUE(0),

    EXECUTE_RC_LOST_ACTION(1),

    UNKNOWN(-1),

    ;
    private final Integer action;

    ExitWaylineWhenRcLost(Integer action) {
        this.action = action;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return action;
    }

    @JsonCreator
    public static ExitWaylineWhenRcLost parseKey(Integer key) {
        ExitWaylineWhenRcLost parsedKey = RestKey.parseKey(ExitWaylineWhenRcLost.class, key);
        return Optional.ofNullable(parsedKey).orElse(ExitWaylineWhenRcLost.UNKNOWN);
    }

}
