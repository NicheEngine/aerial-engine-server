package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;

import java.util.Optional;

public enum DroneThingVersion implements AerialThingVersion {
    V1_0_0("1.0.0", CloudSdkVersion.V0_0_1),

    V1_1_0("1.1.0", CloudSdkVersion.V1_0_0),

    V1_1_2("1.1.2", CloudSdkVersion.V1_0_0),

    V1_1_3("1.1.3", CloudSdkVersion.V1_0_2),

    V1_2_0("1.2.0", CloudSdkVersion.V1_0_3),

    V1_3_1("1.3.1", CloudSdkVersion.V1_3_1),

    ;
    private final String key;
    private final CloudSdkVersion value;

    DroneThingVersion(String key, CloudSdkVersion value) {
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
    public static DroneThingVersion parseKey(String key) {
        DroneThingVersion dock2ThingVersion = RestKey.parseKey(DroneThingVersion.class, key);
        return Optional.ofNullable(dock2ThingVersion).orElse(DroneThingVersion.V1_3_1);
    }

    public static DroneThingVersion parseValue(CloudSdkVersion value) {
        DroneThingVersion dock2ThingVersion = RestValue.parseValue(DroneThingVersion.class, value);
        return Optional.ofNullable(dock2ThingVersion).orElse(DroneThingVersion.V1_3_1);
    }
}
