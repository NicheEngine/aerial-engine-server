package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

@Getter
public enum Dock3ThingVersion implements AerialThingVersion {
    V1_3_1("1.3.1", CloudsdkVersion.V1_3_1)

    ;

    private final String thingVersion;
    private final CloudsdkVersion cloudSdkVersion;

    Dock3ThingVersion(String thingVersion, CloudsdkVersion cloudSdkVersion) {
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
    public static Dock3ThingVersion parseKey(String key) {
        Dock3ThingVersion dock2ThingVersion = RestKey.parseKey(Dock3ThingVersion.class, key);
        return RestOptional.ofNullable(dock2ThingVersion).orElse(Dock3ThingVersion.V1_3_1);
    }

    public static Dock3ThingVersion parseValue(CloudsdkVersion value) {
        Dock3ThingVersion parsedValue = RestValue.parseValue(Dock3ThingVersion.class, value);
        return RestOptional.ofNullable(parsedValue).orElse(Dock3ThingVersion.V1_3_1);
    }
}
