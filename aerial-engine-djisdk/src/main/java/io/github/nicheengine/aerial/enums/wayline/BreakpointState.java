package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum BreakpointState implements RestKey<Integer> {

    WAYLINE_SEGMENT(0, "On the wayline segment"),

    WAYPOINT(1, "On the waypoint"),

    UNKNOWN(-1),
    ;

    private final Integer state;

    private final String message;

    BreakpointState(Integer state) {
        this.state = state;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static BreakpointState parseKey(Integer key) {
        BreakpointState parsedKey = RestKey.parseKey(BreakpointState.class, key);
        return Optional.ofNullable(parsedKey).orElse(BreakpointState.UNKNOWN);
    }
}
