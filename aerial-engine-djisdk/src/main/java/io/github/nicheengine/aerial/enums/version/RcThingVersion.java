package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;

import java.util.Optional;

public enum RcThingVersion implements AerialThingVersion {
    V1_0_0("1.0.0", CloudSdkVersion.V0_0_1),

    V1_2_0("1.2.0", CloudSdkVersion.V1_2_0),

    V1_3_1("1.3.1", CloudSdkVersion.V1_3_1),

    ;
    private final String key;
    private final CloudSdkVersion value;

    RcThingVersion(String key, CloudSdkVersion value) {
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
    public static RcThingVersion parseKey(String key) {
        RcThingVersion dock2ThingVersion = RestKey.parseKey(RcThingVersion.class, key);
        return Optional.ofNullable(dock2ThingVersion).orElse(RcThingVersion.V1_3_1);
    }

    public static RcThingVersion parseValue(CloudSdkVersion value) {
        RcThingVersion dock2ThingVersion = RestValue.parseValue(RcThingVersion.class, value);
        return Optional.ofNullable(dock2ThingVersion).orElse(RcThingVersion.V1_3_1);
    }
}
