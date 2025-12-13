package io.github.nicheengine.aerial.enums.property;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.collect.Sets;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;
import io.github.nicheengine.aerial.model.device.dock.DockSilentMode;
import io.github.nicheengine.aerial.model.device.drone.DroneCommanderFlightHeight;
import io.github.nicheengine.aerial.model.device.drone.DroneCommanderModeLostAction;
import io.github.nicheengine.aerial.model.device.drone.DroneOfflineMapEnable;
import io.github.nicheengine.aerial.model.device.drone.DroneRthMode;
import io.github.nicheengine.aerial.model.property.*;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Getter
public enum PropertySet implements RestValue<String, Class<? extends AerialDjisdkModel>> {

    NIGHT_LIGHTS_STATE("night_lights_state", NightLightsStateSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    HEIGHT_LIMIT("height_limit", HeightLimitSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    DISTANCE_LIMIT_STATUS("distance_limit_status", DistanceLimitStatusSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    OBSTACLE_AVOIDANCE("obstacle_avoidance", ObstacleAvoidanceSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    RTH_ALTITUDE("rth_altitude", RthAltitudeSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    OUT_OF_CONTROL_ACTION("rc_lost_action", RcLostActionSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    EXIT_WAYLINE_WHEN_RC_LOST("exit_wayline_when_rc_lost", ExitWaylineWhenRcLostSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3), true),

    THERMAL_CURRENT_PALETTE_STYLE("thermal_current_palette_style", ThermalCurrentPaletteStyleSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    THERMAL_GAIN_MODE("thermal_gain_mode", ThermalGainModeSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    THERMAL_ISOTHERM_STATE("thermal_isotherm_state", ThermalIsothermStateSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    THERMAL_ISOTHERM_UPPER_LIMIT("thermal_isotherm_upper_limit", ThermalIsothermUpperLimitSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    THERMAL_ISOTHERM_LOWER_LIMIT("thermal_isotherm_lower_limit", ThermalIsothermLowerLimitSet.class, CloudsdkVersion.V0_0_1, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    RTH_MODE("rth_mode", DroneRthMode.class, CloudsdkVersion.V1_0_0, Sets.newHashSet(GatewayThing.DOCK2, GatewayThing.DOCK3)),

    USER_EXPERIENCE_IMPROVEMENT("user_experience_improvement", UserExperienceImprovementSet.class, CloudsdkVersion.V1_0_0, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    COMMANDER_MODE_LOST_ACTION("commander_mode_lost_action", DroneCommanderModeLostAction.class, CloudsdkVersion.V1_0_0, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    COMMANDER_FLIGHT_HEIGHT("commander_flight_height", DroneCommanderFlightHeight.class, CloudsdkVersion.V1_0_0, Sets.newHashSet(GatewayThing.DOCK, GatewayThing.DOCK2, GatewayThing.DOCK3)),

    OFFLINE_MAP_ENABLE("offline_map_enable", DroneOfflineMapEnable.class, CloudsdkVersion.V1_0_1, Sets.newHashSet(GatewayThing.DOCK2, GatewayThing.DOCK3)),

    SILENT_MODE("silent_mode", DockSilentMode.class, CloudsdkVersion.V1_0_2, Sets.newHashSet(GatewayThing.DOCK)),

    UNKNOWN("", AerialDjisdkModel.class, CloudsdkVersion.DEFAULT, Collections.emptySet());

    private final String property;

    private final Class<? extends AerialDjisdkModel> type;

    private final CloudsdkVersion since;

    private final Set<GatewayThing> supportedDevices;

    private boolean deprecated;

    PropertySet(String property, Class<? extends AerialDjisdkModel> type, CloudsdkVersion since, Set<GatewayThing> supportedDevices) {
        this.property = property;
        this.type = type;
        this.since = since;
        this.supportedDevices = supportedDevices;
    }

    PropertySet(String property, Class<? extends AerialDjisdkModel> type, CloudsdkVersion since, Set<GatewayThing> supportedDevices, boolean deprecated) {
        this.property = property;
        this.type = type;
        this.since = since;
        this.supportedDevices = supportedDevices;
        this.deprecated = deprecated;
    }

    @Override
    public Class<? extends AerialDjisdkModel> getValue() {
        return type;
    }

    @Override
    public String getKey() {
        return property;
    }

    @JsonCreator
    public static PropertySet parseKey(String key) {
        PropertySet parsedKey = RestKey.parseKey(PropertySet.class, key);
        return Optional.ofNullable(parsedKey).orElse(PropertySet.UNKNOWN);
    }
}
