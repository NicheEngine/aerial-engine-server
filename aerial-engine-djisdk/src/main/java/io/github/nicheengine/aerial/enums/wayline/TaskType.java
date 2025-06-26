package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum TaskType implements RestKey<Integer> {

    IMMEDIATE(0),

    TIMED(1),

    CONDITIONAL(2),

    UNKNOWN(-1),
    ;

    private final Integer type;

    TaskType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.type;
    }

    @JsonCreator
    public static TaskType parseKey(Integer key) {
        TaskType parsedKey = RestKey.parseKey(TaskType.class, key);
        return Optional.ofNullable(parsedKey).orElse(TaskType.UNKNOWN);
    }
}
