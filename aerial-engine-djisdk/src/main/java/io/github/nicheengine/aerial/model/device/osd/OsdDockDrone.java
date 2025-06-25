package io.github.nicheengine.aerial.model.device.osd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nicheengine.aerial.enums.debug.SwitchAction;
import io.github.nicheengine.aerial.enums.device.*;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.model.device.*;
import io.github.nicheengine.aerial.model.device.DistanceLimitStatus;
import io.github.nicheengine.aerial.model.device.drone.DroneBattery;
import io.github.nicheengine.aerial.model.device.drone.DronePayload;
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
public class OsdDockDrone extends AerialDjisdkModel {
    private Float attitudeHead;
    private Double attitudePitch;
    private Double attitudeRoll;
    private Float elevation;
    private DroneBattery battery;
    private String firmwareVersion;
    private GearType gear;
    private Float height;
    private Float homeDistance;
    private Float horizontalSpeed;
    private Float latitude;
    private Float longitude;
    private DroneModeCode modeCode;
    private Double totalFlightDistance;
    private Float totalFlightTime;
    private Float verticalSpeed;
    private WindDirection windDirection;
    private Float windSpeed;
    private PositionState positionState;
    @JsonProperty(PayloadPosition.PAYLOAD_KEY)
    private List<DronePayload> payloads;
    private DeviceStorage storage;
    private SwitchAction nightLightsState;
    private Integer heightLimit;
    private DistanceLimitStatus distanceLimitStatus;
    private ObstacleAvoidance obstacleAvoidance;
    private Long activationTime;
    private List<OsdCamera> cameras;
    private RcLostAction rcLostAction;
    private Integer rthAltitude;
    private Integer totalFlightSorties;
    @DjisdkVersion(deprecated = CloudSdkVersion.V1_0_0)
    private ExitWaylineWhenRcLost exitWaylineWhenRcLost;
    private String country;
    private Boolean ridState;
    @JsonProperty("is_near_area_limit")
    private Boolean nearAreaLimit;
    @JsonProperty("is_near_height_limit")
    private Boolean nearHeightLimit;
    private MaintainStatusWrapper maintainStatus;
    private String trackId;
}
