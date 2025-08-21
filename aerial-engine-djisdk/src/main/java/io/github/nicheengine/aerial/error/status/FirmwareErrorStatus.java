package io.github.nicheengine.aerial.error.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FirmwareErrorStatus implements AerialErrorStatus {
    /* firmware */
    AERIAL_DJISDK_ERROR_312001(312001),
    AERIAL_DJISDK_ERROR_312002(312002),
    AERIAL_DJISDK_ERROR_312003(312003),
    AERIAL_DJISDK_ERROR_312004(312004),

    AERIAL_DJISDK_ERROR_312010(312010),
    AERIAL_DJISDK_ERROR_312012(312012),
    AERIAL_DJISDK_ERROR_312013(312013),

    AERIAL_DJISDK_ERROR_312014(312014),
    AERIAL_DJISDK_ERROR_312015(312015),
    AERIAL_DJISDK_ERROR_312016(312016),
    AERIAL_DJISDK_ERROR_312022(312022),
    AERIAL_DJISDK_ERROR_312023(312023),
    AERIAL_DJISDK_ERROR_312027(312027),
    AERIAL_DJISDK_ERROR_312028(312028),
    AERIAL_DJISDK_ERROR_312029(312029),
    AERIAL_DJISDK_ERROR_312030(312030),
    AERIAL_DJISDK_ERROR_312031(312031),

    AERIAL_DJISDK_ERROR_312307(312307),

    AERIAL_DJISDK_ERROR_312527(312527),
    AERIAL_DJISDK_ERROR_312534(312534),

    AERIAL_DJISDK_ERROR_312704(312704),


    AERIAL_UNKNOWN_ERROR(999999),
    ;

    private final Integer status;

    FirmwareErrorStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getCode() {
        return this.status;
    }

    @JsonCreator
    public static FirmwareErrorStatus parseKey(Integer key) {
        FirmwareErrorStatus parsedKey = RestKey.parseKey(FirmwareErrorStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(FirmwareErrorStatus.AERIAL_UNKNOWN_ERROR);
    }


}
