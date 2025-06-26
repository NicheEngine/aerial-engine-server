package io.github.nicheengine.aerial.model.control.takeoff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.control.CommanderFlightMode;
import io.github.nicheengine.aerial.enums.control.CommanderModeLostAction;
import io.github.nicheengine.aerial.enums.device.ExitWaylineWhenRcLost;
import io.github.nicheengine.aerial.enums.device.RcLostAction;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.enums.wayline.RthMode;
import io.github.nicheengine.aerial.model.wayline.SimulateMission;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TakeoffToPointRequest extends AerialDjisdkModel {
    @Pattern(regexp = "^[^<>:\"/|?*._\\\\]+$")
    @NotNull
    private String flightId;
    @Min(-180)
    @Max(180)
    @NotNull
    private Float targetLongitude;
    @Min(-90)
    @Max(90)
    @NotNull
    private Float targetLatitude;
    @Min(2)
    @Max(10000)
    @NotNull
    private Float targetHeight;
    @Min(20)
    @Max(1500)
    @NotNull
    private Float securityTakeoffHeight;
    @Min(2)
    @Max(1500)
    @NotNull
    private Float rthAltitude;
    @NotNull
    private RcLostAction rcLostAction;

    @NotNull
    @DjisdkVersion(deprecated = CloudsdkVersion.V1_0_0)
    private ExitWaylineWhenRcLost exitWaylineWhenRcLost;

    @Min(1)
    @Max(15)
    @NotNull
    private Integer maxSpeed;

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @NotNull
    private RthMode rthMode;

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @NotNull
    private CommanderModeLostAction commanderModeLostAction;

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @NotNull
    private CommanderFlightMode commanderFlightMode;

    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    @NotNull
    @Min(2)
    @Max(3000)
    private Float commanderFlightHeight;

    @Valid
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private SimulateMission simulateMission;

}
