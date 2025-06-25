package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DongleType implements RestKey<Integer>{
    OLD_DONGLE(6),

    SUPPORTED_ESIM(10),

    UNKNOWN(-1),
    ;
    private final Integer type;

    DongleType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static DongleType parseKey(Integer key) {
        DongleType parsedKey = RestKey.parseKey(DongleType.class, key);
        return Optional.ofNullable(parsedKey).orElse(DongleType.UNKNOWN);
    }

}
