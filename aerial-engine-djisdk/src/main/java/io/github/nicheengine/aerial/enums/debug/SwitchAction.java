package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum SwitchAction implements RestKey<Integer>{
    DISABLE(0),

    ENABLE(1),

    UNKNOWN(-1),

    ;
    private final Integer action;

    SwitchAction(Integer action) {
        this.action = action;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return action;
    }

    @JsonCreator
    public static SwitchAction parseKey(Integer key) {
        SwitchAction parsedKey = RestKey.parseKey(SwitchAction.class, key);
        return Optional.ofNullable(parsedKey).orElse(SwitchAction.UNKNOWN);
    }

}
