package io.github.nicheengine.aerial.model.wayline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.device.ExitWaylineWhenRcLost;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.enums.wayline.*;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FlighttaskPrepareRequest extends AerialDjisdkModel {
    @NotNull
    @Pattern(regexp = "^[^<>:\"/|?*._\\\\]+$")
    private String flightId;
    @Min(123456789012L)
    private Long executeTime;
    @NotNull
    private TaskType taskType;
    @NotNull
    private WaylineType waylineType;
    @NotNull
    @Valid
    private FlighttaskFile file;
    @Valid
    private ReadyConditions readyConditions;
    @Valid
    private ExecutableConditions executableConditions;
    @Valid
    private FlighttaskBreakPoint breakPoint;
    @NotNull
    @Min(20)
    @Max(1500)
    private Integer rthAltitude;
    @NotNull
    private OutOfControlAction outOfControlAction;
    @NotNull
    private ExitWaylineWhenRcLost exitWaylineWhenRcLost;
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private RthMode rthMode = RthMode.PRESET_HEIGHT;
    @Valid
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private SimulateMission simulateMission;
    @NotNull
    @DjisdkVersion(since = CloudsdkVersion.V1_0_1, include = {GatewayThing.DOCK2,GatewayThing.DOCK3})
    private WaylinePrecisionType waylinePrecisionType;

}
