package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;

import java.util.Optional;

public enum DroneThingVersion implements AerialThingVersion {
    V1_0_0("1.0.0", CloudsdkVersion.V0_0_1),

    V1_1_0("1.1.0", CloudsdkVersion.V1_0_0),

    V1_1_2("1.1.2", CloudsdkVersion.V1_0_0),

    V1_1_3("1.1.3", CloudsdkVersion.V1_0_2),

    V1_2_0("1.2.0", CloudsdkVersion.V1_0_3),

    V1_3_1("1.3.1", CloudsdkVersion.V1_3_1),

    ;
    private final String thingVersion;
    private final CloudsdkVersion cloudSdkVersion;

    DroneThingVersion(String thingVersion, CloudsdkVersion cloudSdkVersion) {
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
    public static DroneThingVersion parseKey(String key) {
        DroneThingVersion dock2ThingVersion = RestKey.parseKey(DroneThingVersion.class, key);
        return Optional.ofNullable(dock2ThingVersion).orElse(DroneThingVersion.V1_3_1);
    }

    public static DroneThingVersion parseValue(CloudsdkVersion value) {
        DroneThingVersion dock2ThingVersion = RestValue.parseValue(DroneThingVersion.class, value);
        return Optional.ofNullable(dock2ThingVersion).orElse(DroneThingVersion.V1_3_1);
    }
}
