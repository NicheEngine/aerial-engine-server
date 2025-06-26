package io.github.nicheengine.aerial.enums.offlinemap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum GroupType implements RestKey<Integer>{
    CUSTOM(0),

    DEFAULT(1),

    SHARED(2),

    UNKNOWN(-1),
    ;
    private final Integer type;

    GroupType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static GroupType parseKey(Integer key) {
        GroupType parsedKey = RestKey.parseKey(GroupType.class, key);
        return Optional.ofNullable(parsedKey).orElse(GroupType.UNKNOWN);
    }

}
