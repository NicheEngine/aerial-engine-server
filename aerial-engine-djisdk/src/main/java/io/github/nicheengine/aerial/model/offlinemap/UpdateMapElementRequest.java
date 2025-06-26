package io.github.nicheengine.aerial.model.offlinemap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.offlinemap.OfflineMapSyncReason;
import io.github.nicheengine.aerial.enums.offlinemap.OfflineMapSyncStatus;
import io.github.nicheengine.aerial.model.offlinemap.element.ElementContent;
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
public class UpdateMapElementRequest extends AerialDjisdkModel {
    @NotNull
    private String name;
    @NotNull
    @Valid
    private ElementContent content;
}
