package io.github.nicheengine.aerial.model.control.takeoff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.control.TakeoffStatus;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.model.control.point.GeographyPoint;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TakeoffToPointProgress extends AerialDjisdkModel {
    private AerialErrorStatus result;
    private TakeoffStatus status;
    private String flightId;
    private String trackId;
    private Integer wayPointIndex;
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private Float remainingDistance;
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private Integer remainingTime;
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private List<GeographyPoint> plannedPathPoints;
}
