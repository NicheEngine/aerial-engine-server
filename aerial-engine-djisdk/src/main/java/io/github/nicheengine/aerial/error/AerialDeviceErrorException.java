package io.github.nicheengine.aerial.error;

import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;

public class AerialDeviceErrorException extends AerialServerErrorException {
    public AerialDeviceErrorException() {
        super(DjisdkErrorStatus.AERIAL_DEVICE_ERROR);
    }

    public AerialDeviceErrorException(RestStatus status) {
        super(status, RestError.error(status));
    }

    public AerialDeviceErrorException(RestStatus status, String resource) {
        super(status, RestError.error(resource, status));
    }

    public AerialDeviceErrorException(RestStatus status, String resource, String field) {
        super(status, RestError.error(resource, field, status));
    }

    public AerialDeviceErrorException(RestStatus status, Throwable cause) {
        super(status, cause);
    }

    @Override
    public AerialDeviceErrorException get() {
        return new AerialDeviceErrorException();
    }
}

