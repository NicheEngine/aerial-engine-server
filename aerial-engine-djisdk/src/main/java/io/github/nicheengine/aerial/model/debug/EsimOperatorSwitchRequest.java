package io.github.nicheengine.aerial.model.debug;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.debug.DongleDeviceType;
import io.github.nicheengine.aerial.enums.debug.TelecomOperator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EsimOperatorSwitchRequest extends AerialDjisdkModel {
    @NotNull
    private String imei;
    @NotNull
    private DongleDeviceType deviceType;
    @NotNull
    private TelecomOperator telecomOperator;
}
