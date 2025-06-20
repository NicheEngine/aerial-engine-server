package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;


@Getter
public enum WebsocketMethod implements RestKey<String> {

    DEVICE_ONLINE("device_online"),

    DEVICE_OFFLINE("device_offline"),

    DEVICE_UPDATE_TOPO("device_update_topo"),

    DEVICE_OSD("device_osd"),

    MAP_ELEMENT_CREATE("map_element_create"),

    MAP_ELEMENT_UPDATE("map_element_update"),

    MAP_ELEMENT_DELETE("map_element_delete"),

    MAP_GROUP_REFRESH("map_group_refresh"),

    UNKNOWN("");

    private final String method;

    WebsocketMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.method;
    }

    @JsonCreator
    public static WebsocketMethod parseKey(String key) {
        WebsocketMethod parsedKey = RestKey.parseKey(WebsocketMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(WebsocketMethod.UNKNOWN);
    }
}
