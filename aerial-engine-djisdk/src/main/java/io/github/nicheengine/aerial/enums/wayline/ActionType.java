package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ActionType implements RestKey<Integer> {

    SPOT_CHECK(1),

    UNKNOWN(-1),
    ;

    private final Integer type;

    ActionType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.type;
    }

    @JsonCreator
    public static ActionType parseKey(Integer key) {
        ActionType parsedKey = RestKey.parseKey(ActionType.class, key);
        return Optional.ofNullable(parsedKey).orElse(ActionType.UNKNOWN);
    }
}
