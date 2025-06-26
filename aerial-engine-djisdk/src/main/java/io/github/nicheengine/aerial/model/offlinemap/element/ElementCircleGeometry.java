package io.github.nicheengine.aerial.model.offlinemap.element;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.enums.flightarea.GeometrySubtype;
import io.github.nicheengine.aerial.enums.offlinemap.ElementResourceType;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nichetoolkit.rest.RestException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ElementCircleGeometry extends ElementPointGeometry {
    private final String type = GeometrySubtype.CIRCLE.getSubtype();
    private Float radius;

    @Override
    public void ofCoordinates(List<ElementCoordinate> coordinateList) throws AerialServerErrorException {
        super.ofCoordinates(coordinateList);
        Double[] coordinates = this.getCoordinates();
        this.setCoordinates(new Double[]{coordinates[0], coordinates[1]});
    }
}
