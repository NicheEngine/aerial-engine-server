package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestReckon;
import io.github.nichetoolkit.rest.RestValue;

import java.util.Optional;

public enum RoleType implements RestReckon<Long> {
    UNKNOWN("", 0L),
    USER("user", 1L),
    ADMIN("admin", 2L),
    SUPER("super", 4L),
    ;

    private final String key;

    private final Long value;

    RoleType(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Long getValue() {
        return this.value;
    }

    @JsonCreator
    public static RoleType parseKey(String key) {
        RoleType typeEnum = RestKey.parseKey(RoleType.class, key);
        return Optional.ofNullable(typeEnum).orElse(RoleType.UNKNOWN);
    }

    public static RoleType parseValue(Long value) {
        RoleType typeEnum = RestValue.parseValue(RoleType.class, value);
        return Optional.ofNullable(typeEnum).orElse(RoleType.UNKNOWN);
    }
}
