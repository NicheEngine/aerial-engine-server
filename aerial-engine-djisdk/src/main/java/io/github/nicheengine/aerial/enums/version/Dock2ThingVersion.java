package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.RestValue;

public enum Dock2ThingVersion implements AerialThingVersion {
    V1_1_2("1.1.2", CloudSdkVersion.V1_0_1),

    V1_2_0("1.2.0", CloudSdkVersion.V1_0_3),

    V1_3_1("1.3.1", CloudSdkVersion.V1_3_1)

    ;
    private final String key;
    private final CloudSdkVersion value;

    Dock2ThingVersion(String key, CloudSdkVersion value) {
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
    public static Dock2ThingVersion parseKey(String key) {
        Dock2ThingVersion dock2ThingVersion = RestKey.parseKey(Dock2ThingVersion.class, key);
        return RestOptional.ofNullable(dock2ThingVersion).orElse(Dock2ThingVersion.V1_3_1);
    }

    public static Dock2ThingVersion parseValue(CloudSdkVersion value) {
        Dock2ThingVersion parsedValue = RestValue.parseValue(Dock2ThingVersion.class, value);
        return RestOptional.ofNullable(parsedValue).orElse(Dock2ThingVersion.V1_3_1);
    }
}
