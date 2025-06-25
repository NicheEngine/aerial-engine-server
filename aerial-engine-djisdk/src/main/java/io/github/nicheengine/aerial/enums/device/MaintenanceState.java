package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MaintenanceState implements RestKey<Integer> {

    NO_NEED_TO_MAINTENANCE(0),

    NEED_MAINTENANCE(1),

    UNDER_MAINTENANCE(2),

    UNKNOWN(-1),
    ;

    private final Integer state;

    MaintenanceState(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static MaintenanceState parseKey(Integer key) {
        MaintenanceState parsedKey = RestKey.parseKey(MaintenanceState.class, key);
        return Optional.ofNullable(parsedKey).orElse(MaintenanceState.UNKNOWN);
    }
}
