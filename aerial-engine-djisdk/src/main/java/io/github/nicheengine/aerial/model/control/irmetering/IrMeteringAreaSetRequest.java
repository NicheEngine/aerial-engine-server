package io.github.nicheengine.aerial.model.control.irmetering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.model.device.payload.PayloadIndex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IrMeteringAreaSetRequest extends AerialDjisdkModel {
    @NotNull
    private PayloadIndex payloadIndex;
    @NotNull
    @Min(0)
    @Max(1)
    private Float x;
    @NotNull
    @Min(0)
    @Max(1)
    private Float y;
    @NotNull
    @Min(0)
    @Max(1)
    private Float width;
    @NotNull
    @Min(0)
    @Max(1)
    private Float height;
}
