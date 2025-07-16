package io.github.nicheengine.aerial.error;

import io.github.nichetoolkit.rest.RestErrorStatus;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.util.I18nUtils;

public enum ServerErrorStatus implements RestStatus {

    HELLO_MESSAGE(RestErrorStatus.SUCCESS),

    WORKSPACE_ID_NULL(RestErrorStatus.FIELD_IS_NULL)
    ;
    private final Integer status;

    ServerErrorStatus(RestStatus restStatus) {
        this.status = restStatus.getStatus();
    }

    ServerErrorStatus(Integer status) {
        this.status = status;
    }


    @Override
    public Integer getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return I18nUtils.message(name());
    }
}
