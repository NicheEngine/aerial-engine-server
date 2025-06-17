package io.github.nicheengine.aerial;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nichetoolkit.rest.RestValue;

/**
 * <code>AerialThingVersion</code>
 * <p>The aerial thing version interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestValue
 * @since Jdk1.8
 */
public interface AerialThingVersion extends RestValue<String, CloudSdkVersion> {

    /**
     * <code>getThingVersion</code>
     * <p>The get thing version getter method.</p>
     * @return {@link java.lang.String} <p>The get thing version return object is <code>String</code> type.</p>
     * @see java.lang.String
     */
    @JsonValue
    default String getThingVersion() {
        return getKey();
    }

    /**
     * <code>getCloudVersion</code>
     * <p>The get cloud version getter method.</p>
     * @return {@link CloudSdkVersion} <p>The get cloud version return object is <code>AerialCloudVersion</code> type.</p>
     * @see CloudSdkVersion
     */
    default CloudSdkVersion getCloudSdkVersion() {
       return getValue();
   }
}
