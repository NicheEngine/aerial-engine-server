package io.github.nicheengine.aerial.enums.state;

import com.google.common.collect.Sets;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;


public enum RcState implements RestValue<Set<String>,Class<?>> {

    WPMZ_VERSION(Sets.newHashSet("wpmz_version"), WpmzVersion.class),

    FIRMWARE_VERSION(Sets.newHashSet("firmware_version"), FirmwareVersion.class),

    LIVE_CAPACITY(Sets.newHashSet("live_capacity"), RcLivestreamAbilityUpdate.class),

    CONTROL_SOURCE(Sets.newHashSet("control_source"), RcDroneControlSource.class),

    LIVE_STATUS(Sets.newHashSet("live_status"), RcLiveStatus.class),

    COMMANDER_FLIGHT_MODE(Sets.newHashSet("commander_flight_mode"), RcCommanderFlightMode.class),

    COMMANDER_FLIGHT_HEIGHT(Sets.newHashSet("commander_flight_height"), RcCommanderFlightHeight.class),

    COMMANDER_MODE_LOST_ACTION(Sets.newHashSet("commander_mode_lost_action"), RcCommanderModeLostAction.class),

    CAPABILITY_SET(Sets.newHashSet("capability_set"), Object.class),

    RTH_MODE(Sets.newHashSet("rth_mode"), RcRthMode.class),

    IS_CLOUD_CONTROL_AUTH(Sets.newHashSet("is_cloud_control_auth"), RcIsCloudControlAuth.class),

    DONGLE_INFOS(Sets.newHashSet("dongle_infos"), DongleInfos.class),

    PAYLOAD_FIRMWARE(PayloadPosition.positionOfModel(), PayloadFirmwareVersion.class),

    UNKNOWN(Collections.emptySet(), null);

    @Getter
    private final Set<String> keys;

    private final Class<?> type;

    RcState(Set<String> keys, Class<?> type) {
        this.keys = keys;
        this.type = type;
    }

    @Override
    public Class<?> getValue() {
        return this.type;
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> getType() {
        return (Class<T>) this.type;
    }

    @Override
    public Set<String> getKey() {
        return this.keys;
    }

    public static RcState parseState(Set<String> keys) {
        Optional<RcState> parsedKey = Arrays.stream(values()).filter(state -> !Collections.disjoint(keys, state.keys)).findAny();
        return parsedKey.orElse(RcState.UNKNOWN);
    }
}
