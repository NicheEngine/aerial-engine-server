package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class AerialTopicResponse<T> extends AerialMqttMessage<T> {



    public boolean equalsOfRequest(AerialTopicRequest<?> request) {
        return Objects.equals(tid, request.tid) && Objects.equals(bid, request.bid);
    }
}
