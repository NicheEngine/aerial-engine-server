package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DockThingVersion implements AerialThingVersion {
    V1_0_0("1.0.0", CloudsdkVersion.V0_0_1),

    V1_1_0("1.1.0", CloudsdkVersion.V0_0_1),

    V1_1_2("1.1.2", CloudsdkVersion.V1_0_0),

    V1_1_3("1.1.3", CloudsdkVersion.V1_0_2),

    V1_3_1("1.3.1", CloudsdkVersion.V1_3_1)

    ;
    private final String thingVersion;
    private final CloudsdkVersion cloudSdkVersion;

    DockThingVersion(String thingVersion, CloudsdkVersion cloudSdkVersion) {
        this.thingVersion = thingVersion;
        this.cloudSdkVersion = cloudSdkVersion;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.thingVersion;
    }

    @Override
    public CloudsdkVersion getValue() {
        return this.cloudSdkVersion;
    }

    @JsonCreator
    public static DockThingVersion parseKey(String key) {
        DockThingVersion dock2ThingVersion = RestKey.parseKey(DockThingVersion.class, key);
        return Optional.ofNullable(dock2ThingVersion).orElse(DockThingVersion.V1_3_1);
    }

    public static DockThingVersion parseValue(CloudsdkVersion value) {
        DockThingVersion dock2ThingVersion = RestValue.parseValue(DockThingVersion.class, value);
        return Optional.ofNullable(dock2ThingVersion).orElse(DockThingVersion.V1_3_1);
    }
}
