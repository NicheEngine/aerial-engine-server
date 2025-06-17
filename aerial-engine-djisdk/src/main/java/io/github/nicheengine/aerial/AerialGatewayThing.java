package io.github.nicheengine.aerial;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.util.GeneralUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <code>AerialGatewayThing</code>
 * <p>The aerial gateway thing interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestKey
 * @since Jdk1.8
 */
public interface AerialGatewayThing extends RestKey<DeviceThing[]> {

    /**
     * <code>getGateway</code>
     * <p>The get gateway getter method.</p>
     * @return {@link java.util.List} <p>The get gateway return object is <code>List</code> type.</p>
     * @see java.util.List
     */
    @JsonValue
    default List<DeviceThing> getDeviceThings() {
        DeviceThing[] deviceThings = getKey();
        if (GeneralUtils.isNotEmpty(deviceThings)) {
            return new ArrayList<>(Arrays.asList(deviceThings));
        }
        return Collections.emptyList();
    }


}
