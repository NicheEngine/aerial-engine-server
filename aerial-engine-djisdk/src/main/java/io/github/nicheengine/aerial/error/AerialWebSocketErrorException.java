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

    public AerialWebSocketErrorException(String error) {
        super(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, error);
    }

    public AerialWebSocketErrorException(String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, error, cause);
    }

    public AerialWebSocketErrorException(String resource, String error) {
        super(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, resource, error);
    }

    public AerialWebSocketErrorException(String resource, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, resource, error, cause);
    }

    public AerialWebSocketErrorException(String resource, String service, String error) {
        super(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, resource, service, error);
    }

    public AerialWebSocketErrorException(String resource, String service, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, resource, service, error, cause);
    }

    @Override
    public AerialWebSocketErrorException get() {
        return new AerialWebSocketErrorException();
    }
}

