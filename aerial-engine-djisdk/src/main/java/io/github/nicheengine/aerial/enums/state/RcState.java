package io.github.nicheengine.aerial.enums.state;

import com.google.common.collect.Sets;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nicheengine.aerial.model.device.rc.RcPayloadFirmwareVersion;
import io.github.nicheengine.aerial.mqtt.MqttDeviceState;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;

@Getter
public enum RcState implements MqttDeviceState {

    PAYLOAD_FIRMWARE(PayloadPosition.positionOfModel(), RcPayloadFirmwareVersion.class),

    CAPABILITY_SET(Sets.newHashSet("capability_set"), Object.class),

    IS_CLOUD_CONTROL_AUTH(Sets.newHashSet("is_cloud_control_auth"), RcIsCloudControlAuth.class),

    UNKNOWN(Collections.emptySet(), null);

    private final Set<String> keys;

    private final Class<?> type;

    RcState(Set<String> keys, Class<?> type) {
        this.keys = keys;
        this.type = type;
    }

}
