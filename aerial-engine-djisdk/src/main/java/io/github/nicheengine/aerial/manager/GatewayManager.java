package io.github.nicheengine.aerial.manager;

import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.enums.version.DroneThingVersion;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nicheengine.aerial.version.GatewayThingVersion;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;

@Getter
@Setter
@Builder
public class GatewayManager implements Serializable {
    private String gatewaySn;
    private GatewayThingVersion gatewayThingVersion;
    private DroneThingVersion droneThingVersion;
    private GatewayThing gatewayThing;
    private CloudSdkVersion sdkVersion;
    private String droneSn;

    private GatewayManager(String gatewaySn, String droneSn, GatewayThing gatewayThing) {
        this.gatewaySn = gatewaySn;
        this.gatewayThing = gatewayThing;
        this.droneSn = droneSn;
    }

    public GatewayManager(String gatewaySn, String droneSn, GatewayThing gatewayThing, String gatewayThingVersion, String droneThingVersion) {
        this(gatewaySn, droneSn, gatewayThing);
        this.gatewayThingVersion = new GatewayThingVersion(gatewayThing, gatewayThingVersion);
        if (GatewayThing.REMOTER_CONTROL == gatewayThing) {
            this.sdkVersion = CloudSdkVersion.V0_0_1;
            return;
        }
        if (GeneralUtils.isEmpty(droneThingVersion)) {
            this.sdkVersion = this.gatewayThingVersion.getCloudSdkVersion();
            return;
        }
        this.droneThingVersion = DroneThingVersion.parseKey(droneThingVersion);
        this.sdkVersion = this.gatewayThingVersion.getCloudSdkVersion().isSupported(this.droneThingVersion.getCloudSdkVersion()) ?
                this.droneThingVersion.getCloudSdkVersion() : this.gatewayThingVersion.getCloudSdkVersion();
    }

    public boolean isTypeSupport(DjisdkVersion version) {
        return GeneralUtils.isNotEmpty(version) && !Arrays.asList(version.exclude()).contains(this.gatewayThing)
                && (GeneralUtils.isEmpty(version.include()) || Arrays.asList(version.include()).contains(this.gatewayThing));
    }

    public boolean isVersionSupport(DjisdkVersion version) {
        return GeneralUtils.isNotEmpty(version) && this.sdkVersion.isSupported(version.since()) && !isDeprecated(version);
    }

    public boolean isDeprecated(DjisdkVersion version) {
        return GeneralUtils.isNotEmpty(version) && this.sdkVersion.isDeprecated(version.deprecated());
    }

    public boolean isPropertyValid(DjisdkVersion version) {
        return GeneralUtils.isEmpty(version) ||
                (!this.sdkVersion.isDeprecated(version.since()) && this.sdkVersion.isSupported(version.since()));
    }
}
