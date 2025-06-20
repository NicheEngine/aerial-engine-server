package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CommanderModeLostAction implements RestKey<Integer>{
    CONTINUE(0),
    EXECUTE_RC_LOST_ACTION(1),
    UNKNOWN(-1),
    ;
    private final Integer mode;

    CommanderModeLostAction(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static CommanderModeLostAction parseKey(Integer key) {
        CommanderModeLostAction parsedKey = RestKey.parseKey(CommanderModeLostAction.class, key);
        return Optional.ofNullable(parsedKey).orElse(CommanderModeLostAction.UNKNOWN);
    }

}
