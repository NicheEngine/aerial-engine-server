package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nicheengine.aerial.AerialGatewayThing;
import io.github.nicheengine.aerial.enums.device.DeviceThing;

import java.util.Arrays;
import java.util.Optional;

/**
 * <code>GatewayThing</code>
 * <p>The gateway thing enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nicheengine.aerial.AerialGatewayThing
 * @since Jdk1.8
 */
public enum GatewayThing implements AerialGatewayThing {

    /**
     * <code>REMOTER_CONTROL</code>
     * <p>The remoter control gateway thing field.</p>
     */
    REMOTER_CONTROL(DeviceThing.RC, DeviceThing.RC_PLUS, DeviceThing.RC_PRO, DeviceThing.RC_PLUS_2),

    /**
     * <code>DOCK</code>
     * <p>The dock gateway thing field.</p>
     */
    DOCK(DeviceThing.DOCK),

    /**
     * <code>DOCK2</code>
     * <p>The dock 2 gateway thing field.</p>
     */
    DOCK2(DeviceThing.DOCK2),

    /**
     * <code>DOCK3</code>
     * <p>The dock 3 gateway thing field.</p>
     */
    DOCK3(DeviceThing.DOCK3),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown gateway thing field.</p>
     */
    UNKNOWN(),
    ;

    /**
     * <code>key</code>
     * {@link io.github.nicheengine.aerial.enums.device.DeviceThing} <p>The <code>key</code> field.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceThing
     */
    private final DeviceThing[] key;

    /**
     * <code>GatewayThing</code>
     * <p>Instantiates a new gateway thing.</p>
     * @param things {@link io.github.nicheengine.aerial.enums.device.DeviceThing} <p>The things parameter is <code>DeviceThing</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceThing
     */
    GatewayThing(DeviceThing... things) {
        this.key = things;
    }

    @Override
    public DeviceThing[] getKey() {
        return this.key;
    }

    /**
     * <code>parseGateway</code>
     * <p>The parse gateway method.</p>
     * @param deviceThing {@link io.github.nicheengine.aerial.enums.device.DeviceThing} <p>The device thing parameter is <code>DeviceThing</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.GatewayThing} <p>The parse gateway return object is <code>GatewayThing</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.device.DeviceThing
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static GatewayThing parseGateway(DeviceThing deviceThing) {
        Optional<GatewayThing> gatewayOptional = Arrays.stream(values())
                .filter(gatewayThing -> gatewayThing.getDeviceThings().contains(deviceThing))
                .findAny();
        return gatewayOptional.orElse(GatewayThing.UNKNOWN);
    }

}
