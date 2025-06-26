package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsChargingRodIndex implements RestKey<Integer>{

    FRONT(0, "front", "前"),

    BACK(1, "back", "后"),

    LEFT(2, "left", "左"),

    RIGHT(3, "right", "右"),

    UNKNOWN(-1,"unknown","未知"),

    ;
    private final Integer index;

    private final String en;

    private final String zh;

    HmsChargingRodIndex(Integer index, String en, String zh) {
        this.index = index;
        this.en = en;
        this.zh = zh;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return index;
    }

    @JsonCreator
    public static HmsChargingRodIndex parseKey(Integer key) {
        HmsChargingRodIndex parsedKey = RestKey.parseKey(HmsChargingRodIndex.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsChargingRodIndex.UNKNOWN);
    }

}
