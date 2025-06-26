package io.github.nicheengine.aerial.enums.hmsinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum HmsMessageLanguage implements RestKey<String>{

    EN("en"),

    ZH("zh"),

    UNKNOWN(""),

    ;
    private final String language;

    HmsMessageLanguage(String language) {
        this.language = language;
    }

    @JsonValue
    @Override
    public String getKey() {
        return language;
    }

    @JsonCreator
    public static HmsMessageLanguage parseKey(String key) {
        HmsMessageLanguage parsedKey = RestKey.parseKey(HmsMessageLanguage.class, key);
        return Optional.ofNullable(parsedKey).orElse(HmsMessageLanguage.UNKNOWN);
    }

}
