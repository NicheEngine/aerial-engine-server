package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;

import java.util.function.Supplier;

public class AerialServiceLackError extends RestError {

    public AerialServiceLackError() {
        super(AerialErrorStatus.AERIAL_ERROR);
    }

    public AerialServiceLackError(Supplier<RestStatus> supplier) {
        super(supplier);
    }

    public AerialServiceLackError(String error) {
        super(error,AerialErrorStatus.AERIAL_ERROR);
    }

    public AerialServiceLackError(RestStatus status) {
        super(status);
    }

    public AerialServiceLackError(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    public AerialServiceLackError(RestStatus status, String resource) {
        super(status, RestError.error(resource, status));
    }

    public AerialServiceLackError(RestStatus status, String resource, String field) {
        super(status, RestError.error(resource, field, status));
    }



    @Override
    public AerialServiceLackError get() {
        return new AerialServiceLackError();
    }
}
