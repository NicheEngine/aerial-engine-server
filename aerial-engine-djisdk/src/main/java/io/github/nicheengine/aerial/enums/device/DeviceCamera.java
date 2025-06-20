package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum DeviceCamera implements AerialDeviceType {

    L1_CAMERA(90742),
    P1_CAMERA(50),

    FPV_CAMERA(39),
    FPV_SHADOW(176),

    Z30_CAMERA(20),
    XT2_CAMERA(26),
    XTS_CAMERA(41),
    H20_CAMERA(42),
    H20T_CAMERA(43),
    H20N_CAMERA(61),
    H30_CAMERA(82),
    H30T_CAMERA(83),

    M30_CAMERA(52),
    M30T_CAMERA(53),

    M4E_CAMERA(88),
    M4T_CAMERA(89),

    M3E_CAMERA(66),
    M3T_CAMERA(67),
    M3M_CAMERA(68),

    M3D_CAMERA(80),
    M3TD_CAMERA(81),

    M4D_CAMERA(98),
    M4TD_CAMERA(99),
    DOCK_CAMERA(165),

    UNKNOWN(-1),
    ;

    private final Integer type;

    DeviceCamera(Integer type) {
        this.type = type;
    }

    @JsonCreator
    public static DeviceCamera parseKey(Integer key) {
        DeviceCamera parsedKey = RestKey.parseKey(DeviceCamera.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceCamera.UNKNOWN);
    }
}
