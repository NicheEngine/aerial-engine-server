package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum BatteryStoreMode implements RestKey<Integer>{
    PLAN(1),

    EMERGENCY(2),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    BatteryStoreMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static BatteryStoreMode parseKey(Integer key) {
        BatteryStoreMode parsedKey = RestKey.parseKey(BatteryStoreMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(BatteryStoreMode.UNKNOWN);
    }

}
