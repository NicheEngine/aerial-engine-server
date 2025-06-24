package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum SimSlot implements RestKey<Integer>{

    UNKNOWN(0),

    SIM(1),

    ESIM(2),

    ;
    private final Integer slot;

    SimSlot(Integer slot) {
        this.slot = slot;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return slot;
    }

    @JsonCreator
    public static SimSlot parseKey(Integer key) {
        SimSlot parsedKey = RestKey.parseKey(SimSlot.class, key);
        return Optional.ofNullable(parsedKey).orElse(SimSlot.UNKNOWN);
    }

}
