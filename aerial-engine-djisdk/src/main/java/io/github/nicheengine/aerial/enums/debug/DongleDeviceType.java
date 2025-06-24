package io.github.nicheengine.aerial.enums.debug;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DongleDeviceType implements RestKey<String>{

    DOCK("dock"),

    DRONE("drone"),

    UNKNOWN(""),

    ;
    private final String type;

    DongleDeviceType(String type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public String getKey() {
        return type;
    }

    @JsonCreator
    public static DongleDeviceType parseKey(String key) {
        DongleDeviceType parsedKey = RestKey.parseKey(DongleDeviceType.class, key);
        return Optional.ofNullable(parsedKey).orElse(DongleDeviceType.UNKNOWN);
    }

}
