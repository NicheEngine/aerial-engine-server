package io.github.nicheengine.aerial.error.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum UploadErrorStatus implements AerialErrorStatus {
    /* upload */
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
    AERIAL_DJISDK_ERROR_324031(324031),
    AERIAL_DJISDK_ERROR_324032(324032),

    AERIAL_DJISDK_ERROR_324042(324042),

    AERIAL_UNKNOWN_ERROR(999999),
    ;

    private final Integer status;

    UploadErrorStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getCode() {
        return this.status;
    }

    @JsonCreator
    public static UploadErrorStatus parseKey(Integer key) {
        UploadErrorStatus parsedKey = RestKey.parseKey(UploadErrorStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(UploadErrorStatus.AERIAL_UNKNOWN_ERROR);
    }


}
