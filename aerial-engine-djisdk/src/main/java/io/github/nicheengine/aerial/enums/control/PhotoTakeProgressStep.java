package io.github.nicheengine.aerial.enums.control;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum PhotoTakeProgressStep implements RestKey<Integer>{
    NORMAL(0),

    PANORAMA_NOT_STARTED_OR_ENDED(3000),

    PANORAMA_TAKING(3002),

    PANORAMA_COMPOSITING(3005),

    UNKNOWN(-1),

    ;
    private final Integer step;

    PhotoTakeProgressStep(Integer step) {
        this.step = step;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return step;
    }

    @JsonCreator
    public static PhotoTakeProgressStep parseKey(Integer key) {
        PhotoTakeProgressStep parsedKey = RestKey.parseKey(PhotoTakeProgressStep.class, key);
        return Optional.ofNullable(parsedKey).orElse(PhotoTakeProgressStep.UNKNOWN);
    }

}
