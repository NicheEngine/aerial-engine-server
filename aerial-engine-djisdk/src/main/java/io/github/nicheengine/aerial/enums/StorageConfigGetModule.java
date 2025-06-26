package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum StorageConfigGetModule implements RestKey<Integer> {

    MEDIA(0),

    UNKNOWN(-1),
    ;

    private final Integer module;

    StorageConfigGetModule(Integer module) {
        this.module = module;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.module;
    }

    @JsonCreator
    public static StorageConfigGetModule parseKey(Integer key) {
        StorageConfigGetModule parsedKey = RestKey.parseKey(StorageConfigGetModule.class, key);
        return Optional.ofNullable(parsedKey).orElse(StorageConfigGetModule.UNKNOWN);
    }
}
