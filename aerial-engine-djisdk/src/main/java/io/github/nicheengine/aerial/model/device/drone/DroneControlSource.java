package io.github.nicheengine.aerial.model.device.drone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.device.ControlSource;
import io.github.nicheengine.aerial.model.device.payload.PayloadControlSource;
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
public class DroneControlSource extends AerialDjisdkModel {
    private ControlSource controlSource;
    private Float homeLatitude;
    private Float homeLongitude;
    private Integer lowBatteryWarningThreshold;
    private Integer seriousLowBatteryWarningThreshold;
    private List<PayloadControlSource> payloads;
    private Boolean locked;
    private ModeCodeReason modeCodeReason;
}
