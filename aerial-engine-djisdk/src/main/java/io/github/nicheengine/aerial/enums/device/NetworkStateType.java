package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum NetworkStateType implements RestKey<Integer>{


    FOURTH_GENERATION(1),

    ETHERNET(2),

    UNKNOWN(-1),
    ;
    private final Integer type;

    NetworkStateType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static NetworkStateType parseKey(Integer key) {
        NetworkStateType parsedKey = RestKey.parseKey(NetworkStateType.class, key);
        return Optional.ofNullable(parsedKey).orElse(NetworkStateType.UNKNOWN);
    }

}
