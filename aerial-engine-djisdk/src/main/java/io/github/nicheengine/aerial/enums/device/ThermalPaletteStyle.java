package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum ThermalPaletteStyle implements RestKey<Integer>{
    WHITE_HOT(0),

    BLACK_HOT(1),

    RED_HOT(2),

    GREEN_HOT(3),

    FUSION(4),

    RAINBOW(5),

    IRONBOW1(6),

    IRONBOW2(7),

    ICE_FIRE(8),

    SEPIA(9),

    GLOWBOW(10),

    COLOR1(11),

    COLOR2(12),

    RAIN(13),

    HOT_SPOT(14),

    RAINBOW2(15),

    GRAY(16),

    METAL(17),

    COLD_SPOT(18),

    UNKNOWN(-1),

    ;
    private final Integer style;

    ThermalPaletteStyle(Integer style) {
        this.style = style;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return style;
    }

    @JsonCreator
    public static ThermalPaletteStyle parseKey(Integer key) {
        ThermalPaletteStyle parsedKey = RestKey.parseKey(ThermalPaletteStyle.class, key);
        return Optional.ofNullable(parsedKey).orElse(ThermalPaletteStyle.UNKNOWN);
    }

}
