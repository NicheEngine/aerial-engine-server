package io.github.nicheengine.aerial.model.offlinemap.element;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.enums.offlinemap.ElementResourceType;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.stream.RestStream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ElementPointGeometry extends ElementGeometry {
    @NotNull
    private final String type = ElementResourceType.POINT.getTypeName();
    @NotNull
    @Size(min = 2, max = 3)
    protected Double[] coordinates;

    @Override
    public List<ElementCoordinate> toCoordinates() {
        List<ElementCoordinate> coordinateList = new ArrayList<>();
        ElementCoordinate elementCoordinate = ElementCoordinate.builder().longitude(coordinates[0])
                .latitude(coordinates[1]).altitude(this.coordinates.length == 3 ? this.coordinates[2] : null).build();
        coordinateList.add(elementCoordinate);
        return coordinateList;
    }

    @Override
    public void ofCoordinates(List<ElementCoordinate> coordinateList) throws AerialServerErrorException {
        RestOptional.ofEmptyable(coordinateList).orEmptyThrow(() -> new AerialServerErrorException(DjisdkErrorStatus.AERIAL_PARAM_ERROR));
        Optional<ElementCoordinate> firstOptional = coordinateList.stream().findFirst();
        firstOptional.orElseThrow(() -> new AerialServerErrorException(DjisdkErrorStatus.AERIAL_PARAM_ERROR));
        ElementCoordinate coordinate = firstOptional.get();
        this.coordinates = new Double[]{
                coordinate.getLongitude(),
                coordinate.getLatitude(),
                coordinate.getAltitude()
        };
    }
}
