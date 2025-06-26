package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum OutOfControlAction implements RestKey<Integer> {

    RETURN_TO_HOME(0),

    HOVERING(1),

    LANDING(2),

    UNKNOWN(-1),
    ;

    private final Integer action;

    OutOfControlAction(Integer action) {
        this.action = action;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.action;
    }

    @JsonCreator
    public static OutOfControlAction parseKey(Integer key) {
        OutOfControlAction parsedKey = RestKey.parseKey(OutOfControlAction.class, key);
        return Optional.ofNullable(parsedKey).orElse(OutOfControlAction.UNKNOWN);
    }
}
