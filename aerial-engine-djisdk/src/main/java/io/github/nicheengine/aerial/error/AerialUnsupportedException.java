package io.github.nicheengine.aerial.error;

import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.error.natives.ServiceErrorException;

public class AerialUnsupportedException extends ServiceErrorException {

    public AerialUnsupportedException() {
        super(DjisdkErrorStatus.AERIAL_UNSUPPORTED_ERROR);
    }

    public AerialUnsupportedException(RestStatus status) {
        super(status, RestError.error(status));
    }

    public AerialUnsupportedException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public AerialUnsupportedException(RestStatus status, String resource) {
        super(status, RestError.error(resource, status));
    }

    public AerialUnsupportedException(RestStatus status, String resource, String field) {
        super(status, RestError.error(resource, field, status));
    }

    @Override
    public AerialUnsupportedException get() {
        return new AerialUnsupportedException();
    }
}

