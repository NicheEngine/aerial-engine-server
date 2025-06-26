package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialSdkVersion;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum CloudsdkVersion implements AerialSdkVersion {

    DEFAULT("1.3.1"),

    V0_0_1("0.0.1"),

    V1_0_0("1.0.0"),

    V1_0_1("1.0.1"),

    V1_0_2("1.0.2"),

    V1_0_3("1.0.3"),

    V1_2_0("1.2.0"),

    V1_3_1("1.3.1"),

    V_MAX_99("99");

    private final String version;

    CloudsdkVersion(String version) {
        this.version = version;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.version;
    }

    @JsonCreator
    public static CloudsdkVersion parseKey(String key) {
        CloudsdkVersion cloudSdkVersion = RestKey.parseKey(CloudsdkVersion.class, key);
        return Optional.ofNullable(cloudSdkVersion).orElse(CloudsdkVersion.DEFAULT);
    }
}
