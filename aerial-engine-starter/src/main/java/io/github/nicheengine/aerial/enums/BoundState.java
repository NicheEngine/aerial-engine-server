package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestState;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum BoundState implements RestState<Boolean> {

    TRUE(true),

    FALSE(false),

    UNKNOWN(null),
    ;

    private final Boolean state;

    BoundState(Boolean state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Boolean getKey() {
        return this.state;
    }

    @JsonCreator
    public static BoundState parseKey(Boolean key) {
        BoundState parsedKey = RestKey.parseKey(BoundState.class, key);
        return Optional.ofNullable(parsedKey).orElse(BoundState.UNKNOWN);
    }
}
