package io.github.nicheengine.aerial.error;

import io.github.nicheengine.aerial.error.status.EngineErrorStatus;
import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;

public class AerialWebSocketErrorException extends AerialServerErrorException {

    public AerialWebSocketErrorException() {
        super(EngineErrorStatus.AERIAL_WEBSOCKET_ERROR);
    }

    public AerialWebSocketErrorException(RestStatus status) {
        super(status, RestError.error(status));
    }

    public AerialWebSocketErrorException(String message) {
        super(EngineErrorStatus.AERIAL_WEBSOCKET_ERROR, RestError.error(EngineErrorStatus.AERIAL_WEBSOCKET_ERROR,message));
    }

    public AerialWebSocketErrorException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public AerialWebSocketErrorException(Throwable cause) {
        super(EngineErrorStatus.AERIAL_WEBSOCKET_ERROR, cause);
    }

    public AerialWebSocketErrorException(RestStatus status, String message) {
        super(status, RestError.error(status,message));
    }

    public AerialWebSocketErrorException(RestStatus status, String resource, String message) {
        super(status, RestError.error(resource, status, message));
    }

    public AerialWebSocketErrorException(String resource, String message) {
        super(EngineErrorStatus.AERIAL_WEBSOCKET_ERROR, RestError.error(resource, EngineErrorStatus.AERIAL_WEBSOCKET_ERROR, message));
    }

    @Override
    public AerialWebSocketErrorException get() {
        return new AerialWebSocketErrorException();
    }
}

