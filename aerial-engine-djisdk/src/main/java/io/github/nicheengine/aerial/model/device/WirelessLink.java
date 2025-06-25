package io.github.nicheengine.aerial.model.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.device.LinkWorkMode;
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
public class WirelessLink extends AerialDjisdkModel {
    @JsonProperty("4g_freq_band")
    private Float fourthGenerationFreqBand;
    @JsonProperty("4g_gnd_quality")
    private Integer fourthGenerationGndQuality;
    @JsonProperty("4g_link_state")
    private Boolean fourthGenerationLinkState;
    @JsonProperty("4g_quality")
    private Integer fourthGenerationQuality;
    @JsonProperty("4g_uav_quality")
    private Integer fourthGenerationUavQuality;
    private Integer dongleNumber;
    private LinkWorkMode linkWorkmode;
    private Float sdrFreqBand;

    private Boolean sdrLinkState;

    private Integer sdrQuality;
}
