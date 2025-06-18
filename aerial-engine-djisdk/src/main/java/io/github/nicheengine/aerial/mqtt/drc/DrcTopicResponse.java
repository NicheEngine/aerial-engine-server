package io.github.nicheengine.aerial.mqtt.drc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.mqtt.AerialTopicResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class DrcTopicResponse<T> extends AerialTopicResponse<T> {
    private String method;
}