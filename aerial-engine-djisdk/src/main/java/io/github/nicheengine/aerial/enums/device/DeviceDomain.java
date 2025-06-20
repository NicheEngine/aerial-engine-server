package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DeviceDomain implements RestKey<Integer> {

    DRONE(0),

    PAYLOAD(1),

    REMOTER_CONTROL(2),

    DOCK(3),

    UNKNOWN(-1),
    ;

    private final Integer domain;

    DeviceDomain(Integer domain) {
        this.domain = domain;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.domain;
    }

    @JsonCreator
    public static DeviceDomain parseKey(Integer key) {
        DeviceDomain parsedKey = RestKey.parseKey(DeviceDomain.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceDomain.UNKNOWN);
    }
}
