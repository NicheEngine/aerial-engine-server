package io.github.nicheengine.aerial.model.offlinemap.element;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nichetoolkit.rest.RestException;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type",
        include = JsonTypeInfo.As.EXISTING_PROPERTY, defaultImpl = ElementGeometry.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ElementCircleGeometry.class, name = "Circle"),
        @JsonSubTypes.Type(value = ElementPointGeometry.class, name = "Point"),
        @JsonSubTypes.Type(value = ElementLineStringGeometry.class, name = "LineString"),
        @JsonSubTypes.Type(value = ElementPolygonGeometry.class, name = "Polygon")
})
@SuperBuilder
@NoArgsConstructor
public abstract class ElementGeometry extends AerialDjisdkModel {

    public abstract String getType();

    public abstract List<ElementCoordinate> toCoordinates() throws AerialServerErrorException;

    public abstract void ofCoordinates(List<ElementCoordinate> coordinateList) throws AerialServerErrorException;
}
