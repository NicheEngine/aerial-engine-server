package io.github.nicheengine.aerial.model.control.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
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
public class HsiInfoPush extends AerialDjisdkModel {
    private Integer upDistance;
    private Integer downDistance;
    private List<Integer> aroundDistance;
    private Boolean upEnable;
    private Boolean upWork;
    private Boolean downEnable;
    private Boolean downWork;
    private Boolean leftEnable;
    private Boolean leftWork;
    private Boolean rightEnable;
    private Boolean rightWork;
    private Boolean frontEnable;
    private Boolean frontWork;
    private Boolean backEnable;
    private Boolean backWork;
    private Boolean verticalEnable;
    private Boolean verticalWork;
    private Boolean horizontalEnable;
    private Boolean horizontalWork;
}
