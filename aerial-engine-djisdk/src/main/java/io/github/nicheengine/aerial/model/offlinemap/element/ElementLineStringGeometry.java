package io.github.nicheengine.aerial.model.offlinemap.element;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.enums.offlinemap.ElementResourceType;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.status.EngineErrorStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ElementLineStringGeometry extends ElementGeometry {
    @NotNull
    private final String type = ElementResourceType.LINE_STRING.getTypeName();
    @NotNull
    @Size(min = 2)
    private Double[][] coordinates;

    @Override
    public List<ElementCoordinate> toCoordinates() throws AerialServerErrorException {
        if (this.coordinates.length < 2) {
            throw new AerialServerErrorException(EngineErrorStatus.AERIAL_PARAM_ERROR);
        }
        List<ElementCoordinate> coordinateList = new ArrayList<>();
        for (Double[] coordinate : this.coordinates) {
            ElementCoordinate elementCoordinate = ElementCoordinate.builder().longitude(coordinate[0]).latitude(coordinate[1]).build();
            coordinateList.add(elementCoordinate);
        }
        return coordinateList;
    }

    @Override
    public void ofCoordinates(List<ElementCoordinate> coordinateList) throws AerialServerErrorException {
        if (CollectionUtils.isEmpty(coordinateList) || coordinateList.size() < 2) {
            throw new AerialServerErrorException(EngineErrorStatus.AERIAL_PARAM_ERROR);
        }
        this.coordinates = new Double[coordinateList.size()][2];
        for (int i = 0; i < this.coordinates.length; i++) {
            this.coordinates[i][0] = coordinateList.get(i).getLongitude();
            this.coordinates[i][1] = coordinateList.get(i).getLatitude();
        }
    }
}
