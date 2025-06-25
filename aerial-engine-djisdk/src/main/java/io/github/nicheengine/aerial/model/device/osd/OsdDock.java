package io.github.nicheengine.aerial.model.device.osd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.control.DrcState;
import io.github.nicheengine.aerial.enums.device.*;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.model.device.*;
import io.github.nicheengine.aerial.model.device.MaintainStatusWrapper;
import io.github.nicheengine.aerial.model.device.dock.DockPositionState;
import io.github.nicheengine.aerial.model.device.drone.DroneBatteryMaintenanceInfo;
import io.github.nicheengine.aerial.model.device.drone.DroneChargeState;
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
public class OsdDock extends AerialDjisdkModel {
    private NetworkState networkState;
    private Boolean droneInDock;
    private DroneChargeState droneChargeState;
    private RainfallType rainfall;
    private Float windSpeed;
    private Float environmentTemperature;
    private Float temperature;
    private Integer humidity;
    private Float latitude;
    private Float longitude;
    private Float height;
    private AlternateLandPoint alternateLandPoint;
    private Long firstPowerOn;
    private DockPositionState positionState;
    private DeviceStorage storage;
    private DockModeCode modeCode;
    private CoverState coverState;
    private Boolean supplementLightState;
    private Boolean emergencyStopState;
    private AirConditioner airConditioner;
    private BatteryStoreMode batteryStoreMode;
    private Boolean alarmState;
    private PutterState putterState;
    private SubDevice subDevice;
    private Integer jobNumber;
    private Long accTime;
    private Long activationTime;
    private MaintainStatusWrapper maintainStatus;
    private Integer electricSupplyVoltage;
    private Integer workingVoltage;
    private Integer workingCurrent;
    private BackupBattery backupBattery;
    private DroneBatteryMaintenanceInfo droneBatteryMaintenanceInfo;
    private FlighttaskStepCode flighttaskStepCode;
    private Integer flighttaskPrepareCapacity;
    private MediaFileDetail mediaFileDetail;
    private WirelessLink wirelessLink;
    private DrcState drcState;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    private UserExperienceImprovement userExperienceImprovement;
}
