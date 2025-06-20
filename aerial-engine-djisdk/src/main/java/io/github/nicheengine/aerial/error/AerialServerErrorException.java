package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.error.natives.ServiceErrorException;

public class AerialServerErrorException extends ServiceErrorException {

    public AerialServerErrorException() {
        super(AerialErrorStatus.AERIAL_ERROR);
    }

    public AerialServerErrorException(RestStatus status) {
        super(status, RestError.error(status));
    }

    public AerialServerErrorException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public AerialServerErrorException(RestStatus status, String resource) {
        super(status, RestError.error(resource, status));
    }

    public AerialServerErrorException(RestStatus status, String resource, String field) {
        super(status, RestError.error(resource, field, status));
    }

    @Override
    public AerialServerErrorException get() {
        return new AerialServerErrorException();
    }
}

