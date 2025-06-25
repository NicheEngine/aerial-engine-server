package io.github.nicheengine.aerial.model.device.osd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nicheengine.aerial.enums.device.DroneModeCode;
import io.github.nicheengine.aerial.enums.device.GearType;
import io.github.nicheengine.aerial.enums.device.WindDirection;
import io.github.nicheengine.aerial.model.device.DeviceStorage;
import io.github.nicheengine.aerial.model.device.DistanceLimitStatus;
import io.github.nicheengine.aerial.model.device.PositionState;
import io.github.nicheengine.aerial.model.device.WirelessLink;
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
public class OsdRemoteControl extends AerialDjisdkModel {
    private Float latitude;
    private Float longitude;
    private Float height;
    private Integer capacityPercent;
    private WirelessLink wirelessLink;
}
