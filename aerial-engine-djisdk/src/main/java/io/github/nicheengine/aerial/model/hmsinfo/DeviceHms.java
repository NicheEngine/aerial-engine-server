package io.github.nicheengine.aerial.model.hmsinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import io.github.nicheengine.aerial.enums.hmsinfo.HmsLevel;
import io.github.nicheengine.aerial.enums.hmsinfo.HmsModule;
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
public class DeviceHms extends AerialDjisdkModel {
    private String code;
    private String deviceType;
    private Boolean imminent;
    private Boolean inTheSky;
    private HmsLevel level;
    private HmsModule module;
    private DeviceHmsArgs args;

    public AerialDeviceType getDeviceType() {
        DeviceThing deviceThing = DeviceThing.parseDevice(this.deviceType);
        return deviceThing.getDeviceType();
    }

}
