package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ThermalGainMode implements RestKey<Integer>{
    AUTOMATIC(0),

    LOW(1),

    HIGH(2),

    UNKNOWN(-1),

    ;
    private final Integer mode;

    ThermalGainMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static ThermalGainMode parseKey(Integer key) {
        ThermalGainMode parsedKey = RestKey.parseKey(ThermalGainMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(ThermalGainMode.UNKNOWN);
    }

}
