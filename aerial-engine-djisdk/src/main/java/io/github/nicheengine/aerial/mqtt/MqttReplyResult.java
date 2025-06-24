package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MqttReplyResult<T> implements Serializable {

    public static final int CODE_ERROR = -1;

    public static final int CODE_SUCCESS = 0;

    private Integer result;

    private T output;

    private MqttReplyResult() {
    }

    private MqttReplyResult(T output) {
        this.output = output;
    }

    private MqttReplyResult(Integer result, T output) {
        this.result = result;
        this.output = output;
    }


    public static MqttReplyResult<String> error(AerialErrorStatus errorStatus) {
        return new MqttReplyResult<>(errorStatus.getCode(), errorStatus.getMessage());
    }

    public static MqttReplyResult<String> error(String message) {
        return new MqttReplyResult<>(CODE_ERROR, message);
    }

    public static <T> MqttReplyResult<T> success(T data) {
        return new MqttReplyResult<T>(CODE_SUCCESS, data);
    }

    public static <T> MqttReplyResult<T> success() {
        MqttReplyResult<T> mqttReply = new MqttReplyResult<>();
        mqttReply.setResult(CODE_SUCCESS);
        return mqttReply;
    }

}
