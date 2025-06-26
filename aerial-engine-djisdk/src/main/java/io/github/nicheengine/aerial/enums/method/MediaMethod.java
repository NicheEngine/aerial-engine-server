package io.github.nicheengine.aerial.enums.method;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MediaMethod implements RestKey<String>{

    UPLOAD_FLIGHTTASK_MEDIA_PRIORITIZE("upload_flighttask_media_prioritize"),

    UNKNOWN(""),

    ;
    private final String method;

    MediaMethod(String method) {
        this.method = method;
    }

    @JsonValue
    @Override
    public String getKey() {
        return method;
    }

    @JsonCreator
    public static MediaMethod parseKey(String key) {
        MediaMethod parsedKey = RestKey.parseKey(MediaMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(MediaMethod.UNKNOWN);
    }

}
