package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AerialMqttMessage<T> implements Serializable {
    protected String tid;
    protected String bid;
    protected Long timestamp;
    protected T data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AerialMqttMessage<?> that = (AerialMqttMessage<?>) o;
        return Objects.equals(tid, that.tid) && Objects.equals(bid, that.bid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, bid);
    }


}
