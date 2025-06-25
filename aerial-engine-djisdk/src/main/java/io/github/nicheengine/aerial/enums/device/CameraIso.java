package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CameraIso implements RestKey<Integer> {

    AUTO(0),

    AUTO_HIGH_SENSE(1),

    _50(2),

    _100(3),

    _200(4),

    _400(5),

    _800(6),

    _1600(7),

    _3200(8),

    _6400(9),

    _12800(10),

    _25600(11),

    FIXED(255),

    UNKNOWN(-1),
    ;

    private final Integer iso;

    CameraIso(Integer iso) {
        this.iso = iso;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.iso;
    }

    @JsonCreator
    public static CameraIso parseKey(Integer key) {
        CameraIso parsedKey = RestKey.parseKey(CameraIso.class, key);
        return Optional.ofNullable(parsedKey).orElse(CameraIso.UNKNOWN);
    }
}
