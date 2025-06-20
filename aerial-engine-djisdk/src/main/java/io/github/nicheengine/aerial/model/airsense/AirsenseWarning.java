package io.github.nicheengine.aerial.model.airsense;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.airsense.AltitudeType;
import io.github.nicheengine.aerial.enums.airsense.VertTrend;
import io.github.nicheengine.aerial.enums.airsense.WarningLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AirsenseWarning extends AerialDjisdkModel {
    private String icao;
    private WarningLevel warningLevel;
    private Float latitude;
    private Float longitude;
    private Integer altitude;
    private AltitudeType altitudeType;
    private Float heading;
    private Integer relativeAltitude;
    private VertTrend vertTrend;
    private Integer distance;
}
