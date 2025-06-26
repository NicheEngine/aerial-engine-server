package io.github.nicheengine.aerial.model.flightarea;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.flightarea.GeometryType;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type",
        include = JsonTypeInfo.As.EXISTING_PROPERTY, defaultImpl = FlightAreaGeometry.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FlightAreaPointGeometry.class, name = "Point"),
        @JsonSubTypes.Type(value = FlightAreaPolygonGeometry.class, name = "Polygon")
})
@SuperBuilder
@NoArgsConstructor
public abstract class FlightAreaGeometry extends AerialDjisdkModel {

    public abstract GeometryType getType();

}
