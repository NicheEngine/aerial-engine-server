package io.github.nicheengine.aerial.mqtt.drc;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.mqtt.AerialTopicRequest;
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
public class DrcTopicRequest<T> extends AerialTopicRequest<T> {
    private String method;
}
