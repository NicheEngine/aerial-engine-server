package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.error.AerialErrorInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AerialMqttReply<T> implements Serializable {

    public static final int CODE_ERROR = -1;

    public static final int CODE_SUCCESS = 0;

    private Integer result;

    private T output;

    private AerialMqttReply() {
    }

    private AerialMqttReply(T output) {
        this.output = output;
    }

    private AerialMqttReply(Integer result, T output) {
        this.result = result;
        this.output = output;
    }


    public static AerialMqttReply<String> error(AerialErrorInfo errorInfo) {
        return new AerialMqttReply<>(errorInfo.getCode(), errorInfo.getMessage());
    }

    public static AerialMqttReply<String> error(String message) {
        return new AerialMqttReply<>(CODE_ERROR, message);
    }

    public static <T> AerialMqttReply<T> success(T data) {
        return new AerialMqttReply<T>(CODE_SUCCESS, data);
    }

    public static <T> AerialMqttReply<T> success() {
        AerialMqttReply<T> mqttReply = new AerialMqttReply<>();
        mqttReply.setResult(CODE_SUCCESS);
        return mqttReply;
    }

}
