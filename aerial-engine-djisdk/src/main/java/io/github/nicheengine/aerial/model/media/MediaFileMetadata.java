package io.github.nicheengine.aerial.model.media;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MediaFileMetadata extends AerialDjisdkModel {
    @NotNull
    private Double absoluteAltitude;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssVV")
    private LocalDateTime createdTime;
    @NotNull
    private Double gimbalYawDegree;
    @NotNull
    @Valid
    private ShootPosition shootPosition;
    @NotNull
    private Double relativeAltitude;
}
