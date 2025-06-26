package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum OrderByColumn implements RestKey<String> {
    NAME("name"),

    UPDATE_TIME("update_time"),

    CREATE_TIME("create_time"),

    UNKNOWN(""),
    ;
    private final String column;


    OrderByColumn(String column) {
        this.column = column;
    }

    @JsonValue
    @Override
    public String getKey() {
        return column;
    }

    @JsonCreator
    public static OrderByColumn parseKey(String key) {
        OrderByColumn parsedKey = RestKey.parseKey(OrderByColumn.class, key);
        return Optional.ofNullable(parsedKey).orElse(OrderByColumn.UNKNOWN);
    }
}
