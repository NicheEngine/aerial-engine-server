package io.github.nicheengine.aerial.model.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.MediaSubFileType;
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
public class MediaUploadCallbackRequest extends AerialDjisdkModel {
    @NotNull
    @Valid
    private MediaFileExtension ext;
    @NotNull
    private String fingerprint;
    @NotNull
    private String name;
    private String path;
    @NotNull
    private String objectKey;
    @NotNull
    private MediaSubFileType subFileType;
    @Valid
    @NotNull
    private MediaFileMetadata metadata;
}
