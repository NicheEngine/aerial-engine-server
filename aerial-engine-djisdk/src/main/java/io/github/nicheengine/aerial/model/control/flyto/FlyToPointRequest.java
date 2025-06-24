package io.github.nicheengine.aerial.model.control.flyto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.model.control.point.GeographyPoint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FlyToPointRequest extends AerialDjisdkModel {
    @Pattern(regexp = "^[^<>:\"/|?*._\\\\]+$")
    @NotNull
    private String flyToId;
    @Min(1)
    @Max(15)
    @NotNull
    private Integer maxSpeed;
    @Size(min = 1)
    @NotNull
    private List<@Valid GeographyPoint> points;

}
