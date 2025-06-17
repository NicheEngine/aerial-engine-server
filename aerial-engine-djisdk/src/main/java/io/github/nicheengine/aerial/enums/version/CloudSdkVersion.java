package io.github.nicheengine.aerial.enums.version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialSdkVersion;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>CloudSdkVersion</code>
 * <p>The cloud sdk version enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see AerialSdkVersion
 * @since Jdk1.8
 */
public enum CloudSdkVersion implements AerialSdkVersion {

    /**
     * <code>DEFAULT</code>
     * <p>The default cloud sdk version field.</p>
     */
    DEFAULT("1.3.1"),

    /**
     * <code>V0_0_1</code>
     * <p>The v 0 0 1 cloud sdk version field.</p>
     */
    V0_0_1("0.0.1"),

    /**
     * <code>V1_0_0</code>
     * <p>The v 1 0 0 cloud sdk version field.</p>
     */
    V1_0_0("1.0.0"),

    /**
     * <code>V1_0_1</code>
     * <p>The v 1 0 1 cloud sdk version field.</p>
     */
    V1_0_1("1.0.1"),

    /**
     * <code>V1_0_2</code>
     * <p>The v 1 0 2 cloud sdk version field.</p>
     */
    V1_0_2("1.0.2"),

    /**
     * <code>V1_0_3</code>
     * <p>The v 1 0 3 cloud sdk version field.</p>
     */
    V1_0_3("1.0.3"),

    /**
     * <code>V1_2_0</code>
     * <p>The v 1 2 0 cloud sdk version field.</p>
     */
    V1_2_0("1.2.0"),

    /**
     * <code>V1_3_1</code>
     * <p>The v 1 3 1 cloud sdk version field.</p>
     */
    V1_3_1("1.3.1"),

    /**
     * <code>V_MAX_99</code>
     * <p>The v max 99 cloud sdk version field.</p>
     */
    V_MAX_99("99");

    /**
     * <code>key</code>
     * {@link java.lang.String} <p>The <code>key</code> field.</p>
     * @see java.lang.String
     */
    private final String key;

    /**
     * <code>CloudSdkVersion</code>
     * <p>Instantiates a new cloud sdk version.</p>
     * @param key {@link java.lang.String} <p>The key parameter is <code>String</code> type.</p>
     * @see java.lang.String
     */
    CloudSdkVersion(String key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.key;
    }

    /**
     * <code>parseKey</code>
     * <p>The parse key method.</p>
     * @param key {@link java.lang.String} <p>The key parameter is <code>String</code> type.</p>
     * @return {@link CloudSdkVersion} <p>The parse key return object is <code>CloudSdkVersion</code> type.</p>
     * @see java.lang.String
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static CloudSdkVersion parseKey(String key) {
        CloudSdkVersion cloudSdkVersion = RestKey.parseKey(CloudSdkVersion.class, key);
        return Optional.ofNullable(cloudSdkVersion).orElse(CloudSdkVersion.DEFAULT);
    }
}
