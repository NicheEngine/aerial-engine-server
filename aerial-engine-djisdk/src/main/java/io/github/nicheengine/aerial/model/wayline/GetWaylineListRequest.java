package io.github.nicheengine.aerial.model.wayline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import io.github.nicheengine.aerial.enums.wayline.ActionType;
import io.github.nicheengine.aerial.enums.wayline.SimulateSwitch;
import io.github.nicheengine.aerial.enums.wayline.WaylineType;
import io.github.nicheengine.aerial.model.tsa.DeviceTopology;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetWaylineListRequest extends AerialDjisdkModel {
    @NotNull
    @Pattern(regexp = "^[^<>:\"/|?*._\\\\]+$")
    private String name;
    @NotNull
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$")
    private String id;
    @NotNull
    private DeviceThing droneModelKey;
    private String sign;
    @NotNull
    @Size(min = 1)
    private List<DeviceThing> payloadModelKeys;
    @NotNull
    private Boolean favorited;
    @NotNull
    @Size(min = 1)
    private List<WaylineType> templateTypes;
    @NotNull
    private String objectKey;
    @NotNull
    private String userName;
    @NotNull
    @Min(123456789012L)
    private Long updateTime;
    @NotNull
    @Min(123456789012L)
    private Long createTime;
    @JsonProperty("action_type")
    private ActionType actionType;
}
