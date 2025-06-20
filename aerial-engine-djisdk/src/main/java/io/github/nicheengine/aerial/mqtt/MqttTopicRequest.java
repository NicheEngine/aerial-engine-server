package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class MqttTopicRequest<T> extends MqttMessage<T> {

    public void ofResponse(MqttTopicResponse<?> response) {
        response.setBid(this.bid);
        response.setTid(this.tid);
        response.setTimestamp(System.currentTimeMillis());
    }
}
