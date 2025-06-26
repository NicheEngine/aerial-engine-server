package io.github.nicheengine.aerial.error.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LoggingErrorStatus implements AerialErrorStatus {
    /* logging */
    AERIAL_DJISDK_ERROR_324001(324001),

    AERIAL_DJISDK_ERROR_324012(324012),
    AERIAL_DJISDK_ERROR_324013(324013),
    AERIAL_DJISDK_ERROR_324014(324014),
    AERIAL_DJISDK_ERROR_324015(324015),
    AERIAL_DJISDK_ERROR_324016(324016),
    AERIAL_DJISDK_ERROR_324017(324017),
    AERIAL_DJISDK_ERROR_324018(324018),
    AERIAL_DJISDK_ERROR_324019(324019),
    AERIAL_DJISDK_ERROR_324021(324021),
    AERIAL_DJISDK_ERROR_324030(324030),

    AERIAL_UNKNOWN_ERROR(999999),
    ;

    private final Integer status;
    private final String message;

    LoggingErrorStatus(Integer status) {
        this.status = status;
        this.message = I18nUtils.message(name());
    }

    @Override
    public Integer getCode() {
        return this.status;
    }

    @JsonCreator
    public static LoggingErrorStatus parseKey(Integer key) {
        LoggingErrorStatus parsedKey = RestKey.parseKey(LoggingErrorStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(LoggingErrorStatus.AERIAL_UNKNOWN_ERROR);
    }


}
