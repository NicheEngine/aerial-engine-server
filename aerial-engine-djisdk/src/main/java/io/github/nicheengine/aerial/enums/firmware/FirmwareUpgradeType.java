package io.github.nicheengine.aerial.enums.firmware;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FirmwareUpgradeType implements RestKey<Integer>{

    NORMAL_UPGRADE(2),

    CONSISTENT_UPGRADE(3),

    UNKNOWN(-1),

    ;
    private final Integer type;

    FirmwareUpgradeType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static FirmwareUpgradeType parseKey(Integer key) {
        FirmwareUpgradeType parsedKey = RestKey.parseKey(FirmwareUpgradeType.class, key);
        return Optional.ofNullable(parsedKey).orElse(FirmwareUpgradeType.UNKNOWN);
    }

}
