package io.github.nicheengine.aerial.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.error.status.ControlErrorStatus;
import io.github.nicheengine.aerial.error.status.DebugErrorStatus;
import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
import io.github.nicheengine.aerial.error.status.DrcErrorStatus;
import io.github.nichetoolkit.rest.RestStatus;

public interface AerialErrorStatus extends RestStatus {

    Integer getCode();

    @Override
    String getMessage();

    @JsonCreator
    static AerialErrorStatus parseKey(Integer key) {
        if (key >= 327000 && key <= 327500) {
            return ControlErrorStatus.parseKey(key);
        } else if ((key >= 326002 && key <= 326107) || (key >= 514100 && key <= 514185)) {
            return DebugErrorStatus.parseKey(key);
        } else if (key >= 514300) {
            return DrcErrorStatus.parseKey(key);
        } else {
            return DjisdkErrorStatus.parseKey(key);
        }
    }

}
