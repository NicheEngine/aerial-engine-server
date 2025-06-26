package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsModule implements RestKey<Integer>{

    FLIGHT_MISSION(0),

    DEVICE_MANAGEMENT(1),

    MEDIA(2),

    HMS(3),

    UNKNOWN(-1),

    ;
    private final Integer module;

    HmsModule(Integer module) {
        this.module = module;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return module;
    }

    @JsonCreator
    public static HmsModule parseKey(Integer key) {
        HmsModule parsedKey = RestKey.parseKey(HmsModule.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsModule.UNKNOWN);
    }

}
