package io.github.nicheengine.aerial.model.wayline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.enums.wayline.WaylineMissionState;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FlighttaskProgressExt extends AerialDjisdkModel {
    private Integer currentWaypointIndex;
    private Integer mediaCount;
    private String flightId;
    private String trackId;
    private ProgressExtBreakPoint breakPoint;
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private WaylineMissionState waylineMissionState;
    @DjisdkVersion(since = CloudsdkVersion.V1_0_0)
    private Integer waylineId;
}
