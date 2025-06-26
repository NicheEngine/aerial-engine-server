package io.github.nicheengine.aerial.model.tsa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nicheengine.aerial.enums.device.DeviceSubtype;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TopologyDeviceModel extends AerialDjisdkModel {
    @NotNull
    private DeviceThing deviceModelKey;
    @NotNull
    private DeviceDomain domain;
    @NotNull
    private Integer type;
    @NotNull
    private DeviceSubtype subType;

    public AerialDeviceType getType() {
        DeviceThing deviceThing = DeviceThing.parseDevice(this.domain.getDomain(), this.type, this.subType.getSubtype());
        return deviceThing.getDeviceType();
    }

}
