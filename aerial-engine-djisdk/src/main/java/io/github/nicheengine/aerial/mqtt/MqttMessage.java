package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MqttMessage<T> implements Serializable {
    protected String tid;
    protected String bid;
    protected Long timestamp;
    protected T data;

    public boolean ofEquals(MqttMessage<?> message) {
        return Objects.equals(tid, message.tid) && Objects.equals(bid, message.bid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MqttMessage<?> that = (MqttMessage<?>) o;
        return Objects.equals(tid, that.tid) && Objects.equals(bid, that.bid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, bid);
    }


}
