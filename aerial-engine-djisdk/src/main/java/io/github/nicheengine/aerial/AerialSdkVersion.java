package io.github.nicheengine.aerial;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nichetoolkit.rest.RestKey;

/**
 * <code>AerialSdkVersion</code>
 * <p>The aerial sdk version interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestKey
 * @since Jdk1.8
 */
public interface AerialSdkVersion extends RestKey<String> {

    /**
     * <code>getVersion</code>
     * <p>The get version getter method.</p>
     * @return {@link java.lang.String} <p>The get version return object is <code>String</code> type.</p>
     * @see java.lang.String
     */
    @JsonValue
    default String getVersion() {
        return getKey();
    }

    /**
     * <code>isSupported</code>
     * <p>The is supported method.</p>
     * @param version {@link io.github.nicheengine.aerial.enums.version.CloudSdkVersion} <p>The version parameter is <code>CloudSdkVersion</code> type.</p>
     * @return boolean <p>The is supported return object is <code>boolean</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.version.CloudSdkVersion
     */
    default boolean isSupported(CloudSdkVersion version) {
        return this.getVersion().compareTo(version.getVersion()) >= 0;
    }

    /**
     * <code>isDeprecated</code>
     * <p>The is deprecated method.</p>
     * @param version {@link io.github.nicheengine.aerial.enums.version.CloudSdkVersion} <p>The version parameter is <code>CloudSdkVersion</code> type.</p>
     * @return boolean <p>The is deprecated return object is <code>boolean</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.version.CloudSdkVersion
     */
    default boolean isDeprecated(CloudSdkVersion version) {
        return this.getVersion().compareTo(version.getVersion()) >= 0;
    }
}
