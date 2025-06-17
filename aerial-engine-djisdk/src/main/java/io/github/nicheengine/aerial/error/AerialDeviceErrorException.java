package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestError;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.error.natives.ServiceErrorException;

public class AerialDeviceErrorException extends ServiceErrorException {

    public AerialDeviceErrorException() {
        super(AerialErrorStatus.AERIAL_DEVICE_ERROR);
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

    public AerialDeviceErrorException(String error) {
        super(AerialErrorStatus.AERIAL_DEVICE_ERROR, error);
    }

    public AerialDeviceErrorException(String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_DEVICE_ERROR, error, cause);
    }

    public AerialDeviceErrorException(String resource, String error) {
        super(AerialErrorStatus.AERIAL_DEVICE_ERROR, resource, error);
    }

    public AerialDeviceErrorException(String resource, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_DEVICE_ERROR, resource, error, cause);
    }

    public AerialDeviceErrorException(String resource, String service, String error) {
        super(AerialErrorStatus.AERIAL_DEVICE_ERROR, resource, service, error);
    }

    public AerialDeviceErrorException(String resource, String service, String error, Throwable cause) {
        super(AerialErrorStatus.AERIAL_DEVICE_ERROR, resource, service, error, cause);
    }

    @Override
    public AerialDeviceErrorException get() {
        return new AerialDeviceErrorException();
    }
}

