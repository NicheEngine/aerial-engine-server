package io.github.nicheengine.aerial.mqtt.state;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.mqtt.MqttTopicResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class StateTopicResponse<T> extends MqttTopicResponse<T> {

    public static <P> StateTopicResponse<P> ofResponse(StateTopicResponse<?> source) {
        StateTopicResponse<P> target = new StateTopicResponse<>();
        target.setBid(source.getBid());
        target.setTid(source.getTid());
        target.setTimestamp(source.getTimestamp());
        return target;
    }
}