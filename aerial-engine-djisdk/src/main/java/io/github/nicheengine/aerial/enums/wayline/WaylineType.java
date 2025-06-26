package io.github.nicheengine.aerial.enums.wayline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WaylineType implements RestValue<Integer,String> {

    WAYPOINT(0, "waypoint"),

    MAPPING_2D(1, "mapping2d"),

    MAPPING_3D(2, "mapping3d"),

    MAPPING_STRIP(3, "mappingStrip"),

    UNKNOWN(-1,""),
    ;

    private final Integer type;

    private final String value;

    WaylineType(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.type;
    }

    @JsonCreator
    public static WaylineType parseKey(Integer key) {
        WaylineType parsedKey = RestKey.parseKey(WaylineType.class, key);
        return Optional.ofNullable(parsedKey).orElse(WaylineType.UNKNOWN);
    }

    public static WaylineType parseValue(String value) {
        WaylineType parsedKey = RestValue.parseValue(WaylineType.class, value);
        return Optional.ofNullable(parsedKey).orElse(WaylineType.UNKNOWN);
    }
}
