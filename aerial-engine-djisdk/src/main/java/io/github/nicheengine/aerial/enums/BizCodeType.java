package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

public enum BizCodeType implements RestKey<String> {

    DEVICE_ONLINE("device_online"),

    DEVICE_OFFLINE("device_offline"),

    DEVICE_UPDATE_TOPO("device_update_topo"),

    DEVICE_OSD("device_osd"),

    MAP_ELEMENT_CREATE("map_element_create"),

    MAP_ELEMENT_UPDATE("map_element_update"),

    MAP_ELEMENT_DELETE("map_element_delete"),

    MAP_GROUP_REFRESH("map_group_refresh"),


    UNKNOWN("unknown");

    private final String key;

    BizCodeType(String key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.key;
    }

    public String getMethod() {
        return key;
    }

    @JsonCreator
    public static BizCodeType parseKey(String key) {
        BizCodeType parsedKey = RestKey.parseKey(BizCodeType.class, key);
        return Optional.ofNullable(parsedKey).orElse(BizCodeType.UNKNOWN);
    }
}
