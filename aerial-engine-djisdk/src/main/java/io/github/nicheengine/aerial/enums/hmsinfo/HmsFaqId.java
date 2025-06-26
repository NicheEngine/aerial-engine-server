package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsFaqId implements RestKey<String> {

    DOCK_TIP("dock_tip_", DeviceDomain.DOCK),

    FPV_TIP("fpv_tip_", DeviceDomain.DRONE),

    UNKNOWN("", DeviceDomain.UNKNOWN),

    ;
    private final String text;

    private final DeviceDomain domain;

    HmsFaqId(String text, DeviceDomain domain) {
        this.text = text;
        this.domain = domain;
    }

    @JsonValue
    @Override
    public String getKey() {
        return text;
    }

    @JsonCreator
    public static HmsFaqId parseKey(String key) {
        HmsFaqId parsedKey = RestKey.parseKey(HmsFaqId.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsFaqId.UNKNOWN);
    }

}
