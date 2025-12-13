package io.github.nicheengine.aerial.model.device.drone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.debug.SwitchAction;
import io.github.nicheengine.aerial.enums.device.MeasureTargetState;
import io.github.nicheengine.aerial.enums.device.ThermalGainMode;
import io.github.nicheengine.aerial.enums.device.ThermalPaletteStyle;
import io.github.nicheengine.aerial.model.device.DeviceBattery;
import io.github.nicheengine.aerial.model.device.SmartTrackPoint;
import io.github.nicheengine.aerial.model.device.payload.PayloadIndex;
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
public class DronePayload extends AerialDjisdkModel {
    private PayloadIndex payloadIndex;
    private Float gimbalPitch;
    private Float gimbalRoll;
    private Float gimbalYaw;
    private Float measureTargetAltitude;
    private Float measureTargetDistance;
    private Float measureTargetLatitude;
    private Float measureTargetLongitude;

    private MeasureTargetState measureTargetErrorState;

    private Integer version;
    private ThermalPaletteStyle thermalCurrentPaletteStyle;
    private ThermalGainMode thermalGainMode;
    private Float thermalGlobalTemperatureMax;
    private Float thermalGlobalTemperatureMin;
    private Integer thermalIsothermLowerLimit;
    private SwitchAction thermalIsothermState;
    private Integer thermalIsothermUpperLimit;
    private List<SmartTrackPoint> smartTrackPoint;
    @DjisdkVersion(include = {GatewayThing.DOCK2,GatewayThing.DOCK3})
    private Float zoomFactor;
}
