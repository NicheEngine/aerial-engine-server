package io.github.nicheengine.aerial.error.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import io.github.nichetoolkit.rest.util.I18nUtils;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LiveErrorStatus implements AerialErrorStatus, RestValue<Integer, String> {

    /* live */

    AERIAL_DJISDK_ERROR_513001(513001),
    AERIAL_DJISDK_ERROR_513002(513002),
    AERIAL_DJISDK_ERROR_513003(513003),

    AERIAL_DJISDK_ERROR_513004(513004),

    AERIAL_DJISDK_ERROR_513005(513005),
    AERIAL_DJISDK_ERROR_513006(513006),

    AERIAL_DJISDK_ERROR_513008(513008),

    AERIAL_DJISDK_ERROR_513009(513009),

    AERIAL_DJISDK_ERROR_513010(513010),
    AERIAL_DJISDK_ERROR_513011(513011),
    AERIAL_DJISDK_ERROR_513012(513012),
    AERIAL_DJISDK_ERROR_513013(513013),
    AERIAL_DJISDK_ERROR_513014(513014),
    AERIAL_DJISDK_ERROR_513015(513015),
    AERIAL_DJISDK_ERROR_513016(513016),
    AERIAL_DJISDK_ERROR_513017(513017),

    AERIAL_DJISDK_ERROR_513099(513099),

    AERIAL_UNKNOWN_ERROR(999999),
    ;

    private final Integer status;

    LiveErrorStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getCode() {
        return this.status;
    }

    @JsonCreator
    public static LiveErrorStatus parseKey(Integer key) {
        LiveErrorStatus parsedKey = RestKey.parseKey(LiveErrorStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(LiveErrorStatus.AERIAL_UNKNOWN_ERROR);
    }

}
