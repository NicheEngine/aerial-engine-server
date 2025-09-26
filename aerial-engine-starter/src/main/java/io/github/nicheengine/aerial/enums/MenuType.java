package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MenuType implements RestKey<String> {

    DEMO("demo"),

    SYSTEM("system"),

    EXTEND("extend"),
    ;

    private final String menu;

    MenuType(String menu) {
        this.menu = menu;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.menu;
    }

    @JsonCreator
    public static MenuType parseKey(String key) {
        MenuType parsedKey = RestKey.parseKey(MenuType.class, key);
        return Optional.ofNullable(parsedKey).orElse(MenuType.EXTEND);
    }
}
