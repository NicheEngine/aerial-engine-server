package io.github.nicheengine.aerial.error.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DrcErrorStatus implements AerialErrorStatus {
    /* drc */

    AERIAL_DJISDK_ERROR_514300(514300),
    AERIAL_DJISDK_ERROR_514301(514301),
    AERIAL_DJISDK_ERROR_514302(514302),
    AERIAL_DJISDK_ERROR_514303(514303),
    AERIAL_DJISDK_ERROR_514304(514304),


    AERIAL_UNKNOWN_ERROR(999999),
    ;

    private final Integer status;
    private final String message;

    DrcErrorStatus(Integer status) {
        this.status = status;
        this.message = I18nUtils.message(name());
    }

    @Override
    public Integer getCode() {
        return this.status;
    }

    @JsonCreator
    public static DrcErrorStatus parseKey(Integer key) {
        DrcErrorStatus parsedKey = RestKey.parseKey(DrcErrorStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(DrcErrorStatus.AERIAL_UNKNOWN_ERROR);
    }


}
