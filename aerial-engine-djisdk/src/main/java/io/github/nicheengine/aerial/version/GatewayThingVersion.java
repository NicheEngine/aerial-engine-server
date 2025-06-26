package io.github.nicheengine.aerial.version;

import io.github.nicheengine.aerial.AerialThingVersion;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.version.*;

import java.io.Serializable;

public class GatewayThingVersion implements Serializable {

    private AerialThingVersion thingVersion;

    public GatewayThingVersion(AerialThingVersion thingVersion) {
        this.thingVersion = thingVersion;
    }

    public GatewayThingVersion(GatewayThing gatewayThing, String thingVersion) {
        switch (gatewayThing) {
            case DOCK:
                this.thingVersion = DockThingVersion.parseKey(thingVersion);
                return;
            case DOCK2:
                this.thingVersion = Dock2ThingVersion.parseKey(thingVersion);
                break;
            case DOCK3:
                this.thingVersion = Dock3ThingVersion.parseKey(thingVersion);
                break;
            case REMOTER_CONTROL:
                this.thingVersion = RcThingVersion.parseKey(thingVersion);
                break;
        }
    }

    public String getThingVersion() {
        return thingVersion.getThingVersion();
    }

    public CloudsdkVersion getCloudSdkVersion() {
        return thingVersion.getCloudSdkVersion();
    }
}
