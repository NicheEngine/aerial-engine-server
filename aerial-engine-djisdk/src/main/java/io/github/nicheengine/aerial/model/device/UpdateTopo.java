package io.github.nicheengine.aerial.model.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateTopo extends AerialDjisdkModel {
    private DeviceDomain domain;
    private Integer type;
    private DeviceSubtype subType;
    private String deviceSecret;
    private String nonce;
    private String thingVersion;
    private List<UpdateTopoSubDevice> subDevices;


    public AerialDeviceType getType() {
        DeviceThing deviceThing = DeviceThing.parseDevice(this.domain.getDomain(), this.type, this.subType.getSubtype());
        return deviceThing.getDeviceType();
    }
}
