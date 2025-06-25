package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum SimType implements RestKey<Integer>{
    UNKNOWN(0),

    ORDINARY(1),

    THREE_NETWORK_MODES(2),
    ;
    private final Integer type;

    SimType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static SimType parseKey(Integer key) {
        SimType parsedKey = RestKey.parseKey(SimType.class, key);
        return Optional.ofNullable(parsedKey).orElse(SimType.UNKNOWN);
    }

}
