package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestReckon;
import io.github.nichetoolkit.rest.RestValue;

import java.util.Optional;

public enum PurviewType implements RestReckon<Long> {
    UNKNOWN("", 0L),
    QUERY("query", 1L),
    INSERT("insert", 2L),
    UPDATE("update", 4L),
    DELETE("delete", 8L),
    UPLOAD("upload", 16L),
    DOWNLOAD("download", 32L),
    ;

    private final String key;

    private final Long value;

    PurviewType(String key, Long value) {
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
    public static PurviewType parseKey(String key) {
        PurviewType typeEnum = RestKey.parseKey(PurviewType.class, key);
        return Optional.ofNullable(typeEnum).orElse(PurviewType.UNKNOWN);
    }

    public static PurviewType parseValue(Long value) {
        PurviewType typeEnum = RestValue.parseValue(PurviewType.class, value);
        return Optional.ofNullable(typeEnum).orElse(PurviewType.UNKNOWN);
    }
}
