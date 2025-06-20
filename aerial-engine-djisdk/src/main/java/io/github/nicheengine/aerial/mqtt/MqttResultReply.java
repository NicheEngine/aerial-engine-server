package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.error.AerialErrorInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MqttResultReply<T> implements Serializable {

    public static final int CODE_ERROR = -1;

    public static final int CODE_SUCCESS = 0;

    private Integer result;

    private T output;

    private MqttResultReply() {
    }

    private MqttResultReply(T output) {
        this.output = output;
    }

    private MqttResultReply(Integer result, T output) {
        this.result = result;
        this.output = output;
    }


    public static MqttResultReply<String> error(AerialErrorInfo errorInfo) {
        return new MqttResultReply<>(errorInfo.getCode(), errorInfo.getMessage());
    }

    public static MqttResultReply<String> error(String message) {
        return new MqttResultReply<>(CODE_ERROR, message);
    }

    public static <T> MqttResultReply<T> success(T data) {
        return new MqttResultReply<T>(CODE_SUCCESS, data);
    }

    public static <T> MqttResultReply<T> success() {
        MqttResultReply<T> mqttReply = new MqttResultReply<>();
        mqttReply.setResult(CODE_SUCCESS);
        return mqttReply;
    }

}
