package io.github.nicheengine.aerial.mqtt.drc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.error.AerialErrorInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrcUpData<T> implements Serializable {
    private AerialErrorInfo result;
    private T output;
}
