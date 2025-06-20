package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum PropertySetResult implements RestKey<Integer> {
    SUCCESS(0),
    FAILED(1),
    TIMEOUT(2),
    UNKNOWN(-1);
    private final Integer result;

    PropertySetResult(Integer result) {
        this.result = result;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.result;
    }

    @JsonCreator
    public static PropertySetResult parseKey(Integer key) {
        PropertySetResult parsedKey = RestKey.parseKey(PropertySetResult.class, key);
        return Optional.ofNullable(parsedKey).orElse(PropertySetResult.UNKNOWN);
    }


}
