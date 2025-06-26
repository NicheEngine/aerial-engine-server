package io.github.nicheengine.aerial.model.tsa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
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
public class DeviceTopology extends AerialDjisdkModel {
    @NotNull
    private String sn;
    @NotNull
    private String deviceCallsign;
    @NotNull
    @Valid
    private TopologyDeviceModel deviceModel;
    @NotNull
    private Boolean onlineStatus;
    private String userId;
    @NotNull
    private String userCallsign;
    @NotNull
    @Valid
    private DeviceIconUrl iconUrls;

}
