package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsFormatKey implements RestKey<String>{

    ALARM_ID("%alarmid"),

    COMPONENT_INDEX("%component_index"),

    INDEX("%index"),

    BATTERY_INDEX("%battery_index"),

    DOCK_COVER_INDEX("%dock_cover_index"),

    CHARGING_ROD_INDEX("%charging_rod_index"),

    UNKNOWN(""),

    ;
    private final String key;

    HmsFormatKey(String key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public String getKey() {
        return key;
    }

    @JsonCreator
    public static HmsFormatKey parseKey(String key) {
        HmsFormatKey parsedKey = RestKey.parseKey(HmsFormatKey.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsFormatKey.UNKNOWN);
    }

}
