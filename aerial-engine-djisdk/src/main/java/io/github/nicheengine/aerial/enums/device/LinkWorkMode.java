package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum LinkWorkMode implements RestKey<Integer>{

    SDR_ONLY(0),

    SDR_WITH_4G(1),

    UNKNOWN(-1),
    ;
    private final Integer mode;

    LinkWorkMode(Integer mode) {
        this.mode = mode;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return mode;
    }

    @JsonCreator
    public static LinkWorkMode parseKey(Integer key) {
        LinkWorkMode parsedKey = RestKey.parseKey(LinkWorkMode.class, key);
        return Optional.ofNullable(parsedKey).orElse(LinkWorkMode.UNKNOWN);
    }

}
