package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum TelecomOperator implements RestKey<Integer>{
    UNKNOWN(0),

    CHINA_MOBILE(1),

    CHINA_UNICOM(2),

    CHINA_TELECOM(3),

    ;
    private final Integer operator;

    TelecomOperator(Integer operator) {
        this.operator = operator;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return operator;
    }

    @JsonCreator
    public static TelecomOperator parseKey(Integer key) {
        TelecomOperator parsedKey = RestKey.parseKey(TelecomOperator.class, key);
        return Optional.ofNullable(parsedKey).orElse(TelecomOperator.UNKNOWN);
    }

}
