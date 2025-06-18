package io.github.nicheengine.aerial.mqtt.events;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EventsTopicRequest<T> extends AerialTopicRequest<T> {
    private String method;
    private String gateway;
    private String from;
    private boolean needReply;

}
