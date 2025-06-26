package io.github.nicheengine.aerial.error.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WaylineErrorStatus implements AerialErrorStatus {
    /* firmware */
    AERIAL_DJISDK_ERROR_312001(314001),

    AERIAL_DJISDK_ERROR_312704(314022),

    AERIAL_DJISDK_ERROR_312704(316001),

    AERIAL_DJISDK_ERROR_312704(316053),

    AERIAL_DJISDK_ERROR_312704(317001),

    AERIAL_DJISDK_ERROR_312704(317004),

    AERIAL_DJISDK_ERROR_312704(319001),

    AERIAL_DJISDK_ERROR_312704(319999),


    AERIAL_DJISDK_ERROR_312704(321000),

    AERIAL_DJISDK_ERROR_312704(321777),


    AERIAL_DJISDK_ERROR_312704(322282),

    AERIAL_DJISDK_ERROR_312704(324032),


    AERIAL_UNKNOWN_ERROR(999999),
    ;

    private final Integer status;
    private final String message;

    WaylineErrorStatus(Integer status) {
        this.status = status;
        this.message = I18nUtils.message(name());
    }

    @Override
    public Integer getCode() {
        return this.status;
    }

    @JsonCreator
    public static WaylineErrorStatus parseKey(Integer key) {
        WaylineErrorStatus parsedKey = RestKey.parseKey(WaylineErrorStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(WaylineErrorStatus.AERIAL_UNKNOWN_ERROR);
    }


}
