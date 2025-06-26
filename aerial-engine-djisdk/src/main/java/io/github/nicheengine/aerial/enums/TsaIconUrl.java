package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

public enum TsaIconUrl implements RestKey<String> {

    SELECT_CAR("resource://pilot/drawable/tsa_car_select"),

    NORMAL_CAR("resource://pilot/drawable/tsa_car_normal"),

    SELECT_PERSON("resource://pilot/drawable/tsa_person_select"),

    NORMAL_PERSON("resource://pilot/drawable/tsa_person_normal"),

    SELECT_EQUIPMENT("resource://pilot/drawable/tsa_equipment_select"),

    NORMAL_EQUIPMENT("resource://pilot/drawable/tsa_equipment_normal"),

    UNKNOWN(""),
    ;
    private final String url;

    TsaIconUrl(String url) {
        this.url = url;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.url;
    }

    @JsonCreator
    public static TsaIconUrl parseKey(String key) {
        TsaIconUrl sortTypeEnum = RestKey.parseKey(TsaIconUrl.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(TsaIconUrl.UNKNOWN);
    }

}
