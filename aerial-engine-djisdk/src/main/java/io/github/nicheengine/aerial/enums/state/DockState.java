package io.github.nicheengine.aerial.enums.state;

import com.google.common.collect.Sets;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public enum DockState implements RestValue<Set<String>,Class<?>> {
    FIRMWARE_VERSION(Sets.newHashSet("firmware_version"), DockFirmwareVersion.class),

    LIVE_CAPACITY(Sets.newHashSet("live_capacity"), DockLivestreamAbilityUpdate.class),

    CONTROL_SOURCE(Sets.newHashSet("control_source","payloads"), DockDroneControlSource.class),

    LIVE_STATUS(Sets.newHashSet("live_status"), DockLiveStatus.class),

    WPMZ_VERSION(Sets.newHashSet("wpmz_version"), DockDroneWpmzVersion.class),

    THERMAL_SUPPORTED_PALETTE_STYLE(PayloadPosition.positionOfIndex(), DockDroneThermalSupportedPaletteStyle.class),

    RTH_MODE(Sets.newHashSet("rth_mode"), DockDroneRthMode.class),

    CURRENT_RTH_MODE(Sets.newHashSet("current_rth_mode"), DockDroneCurrentRthMode.class),

    COMMANDER_MODE_LOST_ACTION(Sets.newHashSet("commander_mode_lost_action"), DockDroneCommanderModeLostAction.class),

    COMMANDER_FLIGHT_MODE(Sets.newHashSet("commander_flight_mode"), DockDroneCommanderFlightMode.class),

    CURRENT_COMMANDER_FLIGHT_MODE(Sets.newHashSet("current_commander_flight_mode"), DockDroneCurrentCommanderFlightMode.class),

    COMMANDER_FLIGHT_HEIGHT(Sets.newHashSet("commander_flight_height"), DockDroneCommanderFlightHeight.class),

    MODE_CODE_REASON(Sets.newHashSet("mode_code_reason"), DockDroneModeCodeReason.class),

    OFFLINE_MAP_ENABLE(Sets.newHashSet("offline_map_enable"), DockDroneOfflineMapEnable.class),

    DONGLE_INFOS(Sets.newHashSet("dongle_infos"), DongleInfos.class),

    SILENT_MODE(Sets.newHashSet("silent_mode"), DockSilentMode.class),

    WIRELESS_LINK_TOPO(Sets.newHashSet("wireless_link_topo"), DockWirelessLinkTopo.class),

    AIR_TRANSFER_ENABLE(Sets.newHashSet("air_transfer_enable"), DockAirTransferEnable.class),

    FLYSAFE_DATABASE_VERSION(Sets.newHashSet("flysafe_database_version"), DockFlysafeDatabaseVersion.class),

    CAMERA_WATERMARK_SETTINGS(Sets.newHashSet("camera_watermark_settings"), DockCameraWatermarkSettings.class),

    UNKNOWN(Collections.emptySet(), null);

    @Getter
    private final Set<String> keys;

    private final Class<?> type;


    DockState(Set<String> keys, Class<?> type) {
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

    public static DockState parseState(Set<String> keys) {
        Optional<DockState> parsedKey = Arrays.stream(values()).filter(state -> !Collections.disjoint(keys, state.keys)).findAny();
        return parsedKey.orElse(DockState.UNKNOWN);
    }
}
