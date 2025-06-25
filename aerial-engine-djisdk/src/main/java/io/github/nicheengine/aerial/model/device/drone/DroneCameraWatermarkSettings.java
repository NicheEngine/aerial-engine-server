package io.github.nicheengine.aerial.model.device.drone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.device.WatermarkLayout;
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
public class DroneCameraWatermarkSettings extends AerialDjisdkModel {
    private Integer globalEnable;
    private Integer droneTypeEnable;
    private Integer droneSnEnable;
    private Integer datetimeEnable;
    private Integer gpsEnable;
    private Integer userCustomStringEnable;
    private String userCustomString;
    private WatermarkLayout layout;
}
