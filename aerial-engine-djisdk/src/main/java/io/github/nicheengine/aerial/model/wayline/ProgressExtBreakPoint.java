package io.github.nicheengine.aerial.model.wayline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.wayline.BreakpointState;
import io.github.nicheengine.aerial.enums.wayline.FlighttaskBreakReason;
import io.github.nicheengine.aerial.enums.wayline.SimulateSwitch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProgressExtBreakPoint extends AerialDjisdkModel {
    private Integer index;
    private BreakpointState state;
    private Float progress;
    private Integer waylineId;
    private FlighttaskBreakReason breakReason;
    private Float latitude;
    private Float longitude;
    private Float height;
    private Integer attitudeHead;
}
