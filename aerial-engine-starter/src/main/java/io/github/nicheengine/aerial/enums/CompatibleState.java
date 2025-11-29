package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestState;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CompatibleState implements RestState<Boolean> {

    TRUE(true),

    FALSE(false),

    UNKNOWN(null),
    ;

    private final Boolean state;

    CompatibleState(Boolean state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Boolean getKey() {
        return this.state;
    }

    @JsonCreator
    public static CompatibleState parseKey(Boolean key) {
        CompatibleState parsedKey = RestKey.parseKey(CompatibleState.class, key);
        return Optional.ofNullable(parsedKey).orElse(CompatibleState.UNKNOWN);
    }
}
