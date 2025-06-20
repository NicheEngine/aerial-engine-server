package io.github.nicheengine.aerial.mqtt.status;

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
public class StatusTopicResponse<T> extends MqttTopicResponse<T> {
    private String method;

    public static <P> StatusTopicResponse<P> ofResponse(StatusTopicResponse<?> source) {
        StatusTopicResponse<P> target = new StatusTopicResponse<>();
        target.setMethod(source.getMethod());
        target.setBid(source.getBid());
        target.setTid(source.getTid());
        target.setTimestamp(source.getTimestamp());
        return target;
    }
}