package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsInTheSky implements RestKey<String>{

    IN_THE_SKY("_in_the_sky"),

    UNKNOWN(""),

    ;
    private final String text;

    HmsInTheSky(String text) {
        this.text = text;
    }

    @JsonValue
    @Override
    public String getKey() {
        return text;
    }

    @JsonCreator
    public static HmsInTheSky parseKey(String key) {
        HmsInTheSky parsedKey = RestKey.parseKey(HmsInTheSky.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsInTheSky.UNKNOWN);
    }

}
