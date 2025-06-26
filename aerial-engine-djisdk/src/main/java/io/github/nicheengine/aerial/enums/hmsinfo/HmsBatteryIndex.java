package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsBatteryIndex implements RestKey<Integer>{

    LEFT(0, "left", "左"),

    RIGHT(1, "right", "右"),

    UNKNOWN(-1,"unknown","未知"),

    ;
    private final Integer index;

    private final String en;

    private final String zh;

    HmsBatteryIndex(Integer index, String en, String zh) {
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
    public static HmsBatteryIndex parseKey(Integer key) {
        HmsBatteryIndex parsedKey = RestKey.parseKey(HmsBatteryIndex.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsBatteryIndex.UNKNOWN);
    }

}
