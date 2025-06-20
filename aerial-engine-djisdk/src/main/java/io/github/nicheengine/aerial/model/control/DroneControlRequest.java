package io.github.nicheengine.aerial.model.control;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
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
public class DroneControlRequest extends AerialDjisdkModel {
    @NotNull
    private Long seq;
    @Min(-17)
    @Max(17)
    private Float x;
    @Min(-17)
    @Max(17)
    private Float y;
    @Min(-4)
    @Max(5)
    private Float h;
    @Min(-90)
    @Max(90)
    private Float w;
    @Min(2)
    @Max(10)
    private Integer freq;
    @Min(100)
    @Max(1000)
    private Integer delayTime;

}
