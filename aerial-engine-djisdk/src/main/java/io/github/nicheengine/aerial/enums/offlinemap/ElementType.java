package io.github.nicheengine.aerial.enums.offlinemap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ElementType implements RestKey<ElementResourceType> {

    POINT(ElementResourceType.POINT),

    LINE_STRING(ElementResourceType.LINE_STRING),

    POLYGON(ElementResourceType.POLYGON),

    UNKNOWN(ElementResourceType.UNKNOWN);

    private final ElementResourceType resourceType;

    ElementType(ElementResourceType resourceType) {
        this.resourceType = resourceType;
    }

    @JsonValue
    @Override
    public ElementResourceType getKey() {
        return resourceType;
    }


    @JsonCreator
    public static ElementType parseKey(ElementResourceType key) {
        ElementType parsedKey = RestKey.parseKey(ElementType.class, key);
        return Optional.ofNullable(parsedKey).orElse(ElementType.UNKNOWN);
    }

}
