package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ExitingRTHAction implements RestKey<Integer> {

    EXITING_RTH_EXIT(0),

    EXITING_RTH_ENTER(1),

    EXITING_RTH_UNKNOWN(-1),
    ;

    private final Integer action;

    private final String message;

    ExitingRTHAction(Integer action) {
        this.action = action;
        this.message = I18nUtils.message(name());
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.action;
    }

    @JsonCreator
    public static ExitingRTHAction parseKey(Integer key) {
        ExitingRTHAction parsedKey = RestKey.parseKey(ExitingRTHAction.class, key);
        return Optional.ofNullable(parsedKey).orElse(ExitingRTHAction.EXITING_RTH_UNKNOWN);
    }
}
