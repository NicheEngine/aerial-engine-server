package io.github.nicheengine.aerial.model.wayline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.wayline.BreakpointState;
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
public class ExecutableConditions extends AerialDjisdkModel {
    @NotNull
    @Min(0)
    private Integer index;
    @NotNull
    private BreakpointState state;
    @NotNull
    @Min(0)
    @Max(1)
    private Float progress;
    @NotNull
    private Integer waylineId;

}
