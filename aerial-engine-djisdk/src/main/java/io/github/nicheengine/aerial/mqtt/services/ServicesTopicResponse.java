package io.github.nicheengine.aerial.mqtt.services;

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
public class ServicesTopicResponse<T> extends MqttTopicResponse<T> {
    private String method;

    public static <P> ServicesTopicResponse<P> ofResponse(ServicesTopicResponse<?> source) {
        ServicesTopicResponse<P> target = new ServicesTopicResponse<>();
        target.setMethod(source.getMethod());
        target.setBid(source.getBid());
        target.setTid(source.getTid());
        target.setTimestamp(source.getTimestamp());
        return target;
    }
}