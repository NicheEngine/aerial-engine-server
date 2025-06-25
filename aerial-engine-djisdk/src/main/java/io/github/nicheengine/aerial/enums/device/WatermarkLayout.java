package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum WatermarkLayout implements RestKey<Integer> {

    LEFT_TOP(0),

    LEFT_BOTTOM(1),

    RIGHT_TOP(2),

    RIGHT_BOTTOM(3),

    UNKNOWN(-1),
    ;

    private final Integer layout;

    WatermarkLayout(Integer layout) {
        this.layout = layout;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.layout;
    }

    @JsonCreator
    public static WatermarkLayout parseKey(Integer key) {
        WatermarkLayout parsedKey = RestKey.parseKey(WatermarkLayout.class, key);
        return Optional.ofNullable(parsedKey).orElse(WatermarkLayout.UNKNOWN);
    }
}
