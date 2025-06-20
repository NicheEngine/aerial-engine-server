package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CommanderFlightMode implements RestKey<Integer>{
    SMART_HEIGHT(0),
    SETTING_HEIGHT(1),
    UNKNOWN(-1),
    ;
    private final Integer mode;

    CommanderFlightMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static CommanderFlightMode parseKey(Integer key) {
        CommanderFlightMode parsedKey = RestKey.parseKey(CommanderFlightMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(CommanderFlightMode.UNKNOWN);
    }

}
