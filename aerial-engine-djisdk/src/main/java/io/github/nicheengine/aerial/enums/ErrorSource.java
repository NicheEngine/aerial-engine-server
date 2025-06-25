package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ErrorSource implements RestKey<Integer> {

    DEVICE(3),

    DOCK(5),

    PILOT(6),

    UNKNOWN(-1),
    ;

    private final Integer source;

    ErrorSource(Integer source) {
        this.source = source;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.source;
    }

    @JsonCreator
    public static ErrorSource parseKey(Integer key) {
        ErrorSource parsedKey = RestKey.parseKey(ErrorSource.class, key);
        return Optional.ofNullable(parsedKey).orElse(ErrorSource.UNKNOWN);
    }
}
