package io.github.nicheengine.aerial.enums.state;

import com.google.common.collect.Sets;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nicheengine.aerial.model.device.dock.DockFlysafeDatabaseVersion;
import io.github.nicheengine.aerial.model.device.dock.DockSilentMode;
import io.github.nicheengine.aerial.model.device.dock.DockThermalSupportedPaletteStyle;
import io.github.nicheengine.aerial.mqtt.MqttDeviceState;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Getter
public enum DockState implements MqttDeviceState {

    THERMAL_SUPPORTED_PALETTE_STYLE(PayloadPosition.positionOfIndex(), DockThermalSupportedPaletteStyle.class),

    SILENT_MODE(Sets.newHashSet("silent_mode"), DockSilentMode.class),

    WIRELESS_LINK_TOPO(Sets.newHashSet("wireless_link_topo"), DockWirelessLinkTopo.class),

    AIR_TRANSFER_ENABLE(Sets.newHashSet("air_transfer_enable"), DockAirTransferEnable.class),

    FLYSAFE_DATABASE_VERSION(Sets.newHashSet("flysafe_database_version"), DockFlysafeDatabaseVersion.class),

    UNKNOWN(Collections.emptySet(), null);

    private final Set<String> keys;
    private final Class<?> type;

    DockState(Set<String> keys, Class<?> type) {
        this.keys = keys;
        this.type = type;
    }

}
