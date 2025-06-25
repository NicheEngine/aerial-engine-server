package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum BatteryIndex implements RestKey<Integer> {

    LEFT(0),

    RIGHT(1),

    UNKNOWN(-1),
    ;

    private final Integer index;

    BatteryIndex(Integer index) {
        this.index = index;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.index;
    }

    @JsonCreator
    public static BatteryIndex parseKey(Integer key) {
        BatteryIndex parsedKey = RestKey.parseKey(BatteryIndex.class, key);
        return Optional.ofNullable(parsedKey).orElse(BatteryIndex.UNKNOWN);
    }
}
