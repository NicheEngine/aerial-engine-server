package io.github.nicheengine.aerial.model.device.osd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nicheengine.aerial.enums.device.*;
import io.github.nicheengine.aerial.model.device.DeviceStorage;
import io.github.nicheengine.aerial.model.device.DistanceLimitStatus;
import io.github.nicheengine.aerial.model.device.PositionState;
import io.github.nicheengine.aerial.model.device.drone.DroneBattery;
import io.github.nicheengine.aerial.model.device.drone.DronePayload;
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
public class OsdRcDrone extends AerialDjisdkModel {
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
    private Integer heightLimit;
    private DistanceLimitStatus distanceLimitStatus;
    private String trackId;
}
