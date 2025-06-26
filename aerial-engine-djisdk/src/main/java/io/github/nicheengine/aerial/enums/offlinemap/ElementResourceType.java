package io.github.nicheengine.aerial.enums.offlinemap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ElementResourceType implements RestValue<Integer,String> {

    POINT(0, "Point"),

    LINE_STRING(1, "LineString"),

    POLYGON(2, "Polygon"),

    UNKNOWN(-1, ""),

    ;
    private final Integer type;

    private final String typeName;

    ElementResourceType(Integer type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @Override
    public String getValue() {
        return typeName;
    }

    @JsonCreator
    public static ElementResourceType parseKey(Integer key) {
        ElementResourceType parsedKey = RestKey.parseKey(ElementResourceType.class, key);
        return Optional.ofNullable(parsedKey).orElse(ElementResourceType.UNKNOWN);
    }

    public static ElementResourceType parseValue(String key) {
        ElementResourceType parsedValue = RestValue.parseValue(ElementResourceType.class, key);
        return Optional.ofNullable(parsedValue).orElse(ElementResourceType.UNKNOWN);
    }


}
