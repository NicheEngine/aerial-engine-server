package io.github.nicheengine.aerial.websocket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AerialMessageResponse<T> {
    @NotNull
    @JsonProperty("biz_code")
    private String bizCode;

    private String version = "1.0.0";

    @NotNull
    @Min(123456789012L)
    private Long timestamp;

    @NotNull
    private T data;
}