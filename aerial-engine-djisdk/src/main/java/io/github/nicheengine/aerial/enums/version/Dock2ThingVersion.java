package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

@Getter
public enum Dock2ThingVersion implements AerialThingVersion {
    V1_1_2("1.1.2", CloudsdkVersion.V1_0_1),

    V1_2_0("1.2.0", CloudsdkVersion.V1_0_3),

    V1_3_1("1.3.1", CloudsdkVersion.V1_3_1)

    ;
    private final String thingVersion;
    private final CloudsdkVersion cloudSdkVersion;

    Dock2ThingVersion(String thingVersion, CloudsdkVersion cloudSdkVersion) {
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
    public static Dock2ThingVersion parseKey(String key) {
        Dock2ThingVersion dock2ThingVersion = RestKey.parseKey(Dock2ThingVersion.class, key);
        return RestOptional.ofNullable(dock2ThingVersion).orElse(Dock2ThingVersion.V1_3_1);
    }

    public static Dock2ThingVersion parseValue(CloudsdkVersion value) {
        Dock2ThingVersion parsedValue = RestValue.parseValue(Dock2ThingVersion.class, value);
        return RestOptional.ofNullable(parsedValue).orElse(Dock2ThingVersion.V1_3_1);
    }
}
