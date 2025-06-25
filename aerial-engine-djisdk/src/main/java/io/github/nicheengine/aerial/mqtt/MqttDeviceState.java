package io.github.nicheengine.aerial.mqtt;

import io.github.nicheengine.aerial.enums.state.DockState;
import io.github.nicheengine.aerial.enums.state.DroneState;
import io.github.nicheengine.aerial.enums.state.RcState;
import io.github.nichetoolkit.rest.RestValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

/**
 * <code>MqttDeviceState</code>
 * <p>The mqtt device state interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rest.RestValue
 * @since Jdk1.8
 */
public interface MqttDeviceState extends RestValue<Set<String>,Class<?>> {

    /**
     * <code>getKeys</code>
     * <p>The get keys getter method.</p>
     * @return {@link java.util.Set} <p>The get keys return object is <code>Set</code> type.</p>
     * @see java.util.Set
     */
    Set<String> getKeys();

    /**
     * <code>getType</code>
     * <p>The get type getter method.</p>
     * @return {@link java.lang.Class} <p>The get type return object is <code>Class</code> type.</p>
     * @see java.lang.Class
     */
    Class<?> getType();

    @Override
    default Class<?> getValue() {
        return getType();
    }

    @Override
    default Set<String> getKey() {
        return getKeys();
    }

    /**
     * <code>getJavaType</code>
     * <p>The get java type getter method.</p>
     * @param <T> {@link java.lang.Object} <p>The parameter can be of any type.</p>
     * @return {@link java.lang.Class} <p>The get java type return object is <code>Class</code> type.</p>
     * @see java.lang.Class
     * @see java.lang.SuppressWarnings
     */
    @SuppressWarnings("unchecked")
    default <T> Class<T> getJavaType() {
        return (Class<T>) getType();
    }

    static MqttDeviceState parseDockState(Set<String> keys) {
        Optional<MqttDeviceState> droneOptional = Arrays.stream(DroneState.values()).filter(state -> !Collections.disjoint(keys, state.getKeys())).findAny().map(Function.identity());
        return droneOptional.orElseGet(() -> {
            Optional<DockState> parsedKey = Arrays.stream(DockState.values()).filter(state -> !Collections.disjoint(keys, state.getKeys())).findAny();
            return parsedKey.orElse(DockState.UNKNOWN);
        });
    }

    static MqttDeviceState parseRcState(Set<String> keys) {
        Optional<MqttDeviceState> droneOptional = Arrays.stream(DroneState.values()).filter(state -> !Collections.disjoint(keys, state.getKeys())).findAny().map(Function.identity());
        return droneOptional.orElseGet(() -> {
            Optional<RcState> parsedKey = Arrays.stream(RcState.values()).filter(state -> !Collections.disjoint(keys, state.getKeys())).findAny();
            return parsedKey.orElse(RcState.UNKNOWN);
        });
    }
}
