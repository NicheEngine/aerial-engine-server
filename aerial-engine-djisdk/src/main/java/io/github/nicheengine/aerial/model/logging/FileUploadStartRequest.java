package io.github.nicheengine.aerial.model.logging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nichetoolkit.ossfile.OssfileCredentials;
import io.github.nichetoolkit.ossfile.OssfileProviderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FileUploadStartRequest extends AerialDjisdkModel {
    @NotNull
    private String bucket;
    @NotNull
    @Valid
    private OssfileCredentials credentials;
    @NotNull
    private String endpoint;
    @NotNull
    private String fileStoreDir;
    @NotNull
    private OssfileProviderType provider;
    @NotNull
    private String fileType = "text_log";
    @NotNull
    @Valid
    private FileUploadStartParam params;
    @NotNull
    private String region;
}
