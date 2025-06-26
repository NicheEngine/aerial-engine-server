package io.github.nicheengine.aerial.enums.firmware;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum OtaProgressStep implements RestKey<Integer> {

    DOWNLOADING(1),

    UPGRADING(2),

    UNKNOWN(-1),
    ;

    private final Integer step;

    OtaProgressStep(Integer step) {
        this.step = step;
    }

    @Override
    public Integer getKey() {
        return this.step;
    }

    @JsonCreator
    public static OtaProgressStep parseKey(Integer key) {
        OtaProgressStep parsedKey = RestKey.parseKey(OtaProgressStep.class, key);
        return Optional.ofNullable(parsedKey).orElse(OtaProgressStep.UNKNOWN);
    }
}
