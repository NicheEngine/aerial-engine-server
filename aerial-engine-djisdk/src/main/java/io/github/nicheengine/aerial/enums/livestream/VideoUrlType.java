package io.github.nicheengine.aerial.enums.livestream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum VideoUrlType implements RestKey<Integer>{
    AGORA(0),

    RTMP(1),

    RTSP(2),

    GB28181(3),

    WHIP(4),

    UNKNOWN(-1),

    ;
    private final Integer type;

    VideoUrlType(Integer type) {
        this.type = type;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return type;
    }

    @JsonCreator
    public static VideoUrlType parseKey(Integer key) {
        VideoUrlType parsedKey = RestKey.parseKey(VideoUrlType.class, key);
        return Optional.ofNullable(parsedKey).orElse(VideoUrlType.UNKNOWN);
    }

}
