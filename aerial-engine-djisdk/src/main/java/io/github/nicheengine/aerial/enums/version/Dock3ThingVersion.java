package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.RestValue;

public enum Dock3ThingVersion implements AerialThingVersion {
    V1_3_1("1.3.1", CloudSdkVersion.V1_3_1)

    ;
    private final String key;
    private final CloudSdkVersion value;

    Dock3ThingVersion(String key, CloudSdkVersion value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public CloudSdkVersion getValue() {
        return this.value;
    }

    @JsonCreator
    public static Dock3ThingVersion parseKey(String key) {
        Dock3ThingVersion dock2ThingVersion = RestKey.parseKey(Dock3ThingVersion.class, key);
        return RestOptional.ofNullable(dock2ThingVersion).orElse(Dock3ThingVersion.V1_3_1);
    }

    public static Dock3ThingVersion parseValue(CloudSdkVersion value) {
        Dock3ThingVersion parsedValue = RestValue.parseValue(Dock3ThingVersion.class, value);
        return RestOptional.ofNullable(parsedValue).orElse(Dock3ThingVersion.V1_3_1);
    }
}
