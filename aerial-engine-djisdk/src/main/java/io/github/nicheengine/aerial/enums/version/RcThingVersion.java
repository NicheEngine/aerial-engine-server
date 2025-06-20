package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum RcThingVersion implements AerialThingVersion {
    V1_0_0("1.0.0", CloudSdkVersion.V0_0_1),

    V1_2_0("1.2.0", CloudSdkVersion.V1_2_0),

    V1_3_1("1.3.1", CloudSdkVersion.V1_3_1),

    ;
    private final String thingVersion;
    private final CloudSdkVersion cloudSdkVersion;

    RcThingVersion(String thingVersion, CloudSdkVersion cloudSdkVersion) {
        this.thingVersion = thingVersion;
        this.cloudSdkVersion = cloudSdkVersion;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.thingVersion;
    }

    @Override
    public CloudSdkVersion getValue() {
        return this.cloudSdkVersion;
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
