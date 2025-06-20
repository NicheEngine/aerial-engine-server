package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.error.natives.ServiceErrorException;

public class AerialWebSocketErrorException extends ServiceErrorException {

    public AerialWebSocketErrorException() {
        super(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR);
    }

    public AerialWebSocketErrorException(RestStatus status) {
        super(status, RestError.error(status));
    }

    public AerialWebSocketErrorException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public AerialWebSocketErrorException(RestStatus status, String resource) {
        super(status, RestError.error(resource, status));
    }

    public AerialWebSocketErrorException(RestStatus status, String resource, String field) {
        super(status, RestError.error(resource, field, status));
    }

    @Override
    public AerialWebSocketErrorException get() {
        return new AerialWebSocketErrorException();
    }
}

