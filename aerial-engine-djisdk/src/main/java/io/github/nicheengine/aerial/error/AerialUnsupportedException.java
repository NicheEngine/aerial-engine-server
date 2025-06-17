package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.error.natives.ServiceErrorException;

public class AerialUnsupportedException extends ServiceErrorException {

    public AerialUnsupportedException() {
        super(AerialErrorStatus.AERIAL_UNSUPPORTED_ERROR);
    }

    public AerialUnsupportedException(RestStatus status) {
        super(status, RestError.error(status));
    }

    public AerialUnsupportedException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public AerialUnsupportedException(String error) {
        super(AerialErrorStatus.AERIAL_UNSUPPORTED_ERROR, error);
    }

    public AerialUnsupportedException(String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_UNSUPPORTED_ERROR, error, cause);
    }

    public AerialUnsupportedException(String resource, String error) {
        super(AerialErrorStatus.AERIAL_UNSUPPORTED_ERROR, resource, error);
    }

    public AerialUnsupportedException(String resource, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_UNSUPPORTED_ERROR, resource, error, cause);
    }

    public AerialUnsupportedException(String resource, String service, String error) {
        super(AerialErrorStatus.AERIAL_UNSUPPORTED_ERROR, resource, service, error);
    }

    public AerialUnsupportedException(String resource, String service, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_UNSUPPORTED_ERROR, resource, service, error, cause);
    }

    @Override
    public AerialUnsupportedException get() {
        return new AerialUnsupportedException();
    }
}

