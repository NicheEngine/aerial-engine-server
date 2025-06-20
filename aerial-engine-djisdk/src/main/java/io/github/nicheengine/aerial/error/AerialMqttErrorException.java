package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.error.natives.ServiceErrorException;

public class AerialMqttErrorException extends ServiceErrorException {

    public AerialMqttErrorException() {
        super(AerialErrorStatus.AERIAL_MQTT_ERROR);
    }

    public AerialMqttErrorException(RestStatus status) {
        super(status, RestError.error(status));
    }

    public AerialMqttErrorException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public AerialMqttErrorException(RestStatus status, String resource) {
        super(status, RestError.error(resource, status));
    }

    public AerialMqttErrorException(RestStatus status, String resource, String field) {
        super(status, RestError.error(resource, field, status));
    }

    @Override
    public AerialMqttErrorException get() {
        return new AerialMqttErrorException();
    }
}

