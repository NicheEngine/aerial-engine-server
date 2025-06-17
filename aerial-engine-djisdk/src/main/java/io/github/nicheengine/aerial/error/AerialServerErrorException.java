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

    public AerialServerErrorException(String error) {
        super(AerialErrorStatus.AERIAL_ERROR, error);
    }

    public AerialServerErrorException(String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_ERROR, error, cause);
    }

    public AerialServerErrorException(String resource, String error) {
        super(AerialErrorStatus.AERIAL_ERROR, resource, error);
    }

    public AerialServerErrorException(String resource, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_ERROR, resource, error, cause);
    }

    public AerialServerErrorException(String resource, String service, String error) {
        super(AerialErrorStatus.AERIAL_ERROR, resource, service, error);
    }

    public AerialServerErrorException(String resource, String service, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_ERROR, resource, service, error, cause);
    }

    @Override
    public AerialServerErrorException get() {
        return new AerialServerErrorException();
    }
}

