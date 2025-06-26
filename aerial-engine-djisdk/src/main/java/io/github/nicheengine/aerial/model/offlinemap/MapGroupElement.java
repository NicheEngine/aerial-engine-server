package io.github.nicheengine.aerial.model.offlinemap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.offlinemap.GroupType;
import io.github.nicheengine.aerial.model.offlinemap.element.ElementResource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MapGroupElement extends AerialDjisdkModel {
    @NotNull
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$")
    private String id;
    @NotNull
    private String name;
    @NotNull
    @JsonProperty(value = "create_time")
    @Min(123456789012L)
    private Long createTime;

    @NotNull
    @JsonProperty(value = "update_time")
    @Min(123456789012L)
    private Long updateTime;
    @NotNull
    @Valid
    private ElementResource resource;
}
