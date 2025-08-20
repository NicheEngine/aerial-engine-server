package io.github.nicheengine.aerial.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.status.*;
import io.github.nichetoolkit.rest.RestStatus;
import io.github.nichetoolkit.rest.util.I18nUtils;

public interface AerialErrorStatus extends RestStatus {

    Integer getCode();

    @Override
    default String getMessage() {
        return I18nUtils.message(name());
    }


    @JsonCreator
    static AerialErrorStatus parseKey(Integer key) {
        if (key < 300000) {
            return EngineErrorStatus.parseKey(key);
        } else if (key >= 312001 && key <= 312704) {
            return FirmwareErrorStatus.parseKey(key);
        } else if (key >= 314000 && key <= 314200
                || (key >= 316001 && key <= 316053)
                || (key >= 317001 && key <= 322650)) {
            return WaylineErrorStatus.parseKey(key);
        } else if (key >= 324001 && key <= 324032) {
            return UploadErrorStatus.parseKey(key);
        } else if ((key >= 326002 && key <= 326107)
                || (key >= 514100 && key <= 514185)) {
            return DebugErrorStatus.parseKey(key);
        } else if (key >= 327000 && key <= 327500) {
            return ControlErrorStatus.parseKey(key);
        } else if ((key >= 513001 && key <= 513099)) {
            return LiveErrorStatus.parseKey(key);
        } else if (key >= 514300) {
            return DrcErrorStatus.parseKey(key);
        } else {
            return DjisdkErrorStatus.parseKey(key);
        }
    }

}
