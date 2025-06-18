package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class AerialTopicRequest<T> extends AerialMqttMessage<T> {

    public boolean equalsOfResponse(AerialTopicResponse<?> response) {
        return Objects.equals(tid, response.tid) && Objects.equals(bid, response.bid);
    }

    public void ofResponse(AerialTopicResponse<?> response) {
        response.setBid(this.bid);
        response.setTid(this.tid);
        response.setTimestamp(System.currentTimeMillis());
    }
}
