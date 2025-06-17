package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nichetoolkit.rest.RestKey;

import java.util.Optional;

/**
 * <code>DeviceCamera</code>
 * <p>The device camera enumeration.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nicheengine.aerial.AerialDeviceType
 * @since Jdk1.8
 */
public enum DeviceCamera implements AerialDeviceType {

    /**
     * <code>L1_CAMERA</code>
     * <p>The l 1 camera device camera field.</p>
     */
    L1_CAMERA(90742),
    /**
     * <code>P1_CAMERA</code>
     * <p>The p 1 camera device camera field.</p>
     */
    P1_CAMERA(50),

    /**
     * <code>FPV_CAMERA</code>
     * <p>The fpv camera device camera field.</p>
     */
    FPV_CAMERA(39),
    /**
     * <code>FPV_SHADOW</code>
     * <p>The fpv shadow device camera field.</p>
     */
    FPV_SHADOW(176),

    /**
     * <code>Z30_CAMERA</code>
     * <p>The z 30 camera device camera field.</p>
     */
    Z30_CAMERA(20),
    /**
     * <code>XT2_CAMERA</code>
     * <p>The xt 2 camera device camera field.</p>
     */
    XT2_CAMERA(26),
    /**
     * <code>XTS_CAMERA</code>
     * <p>The xts camera device camera field.</p>
     */
    XTS_CAMERA(41),
    /**
     * <code>H20_CAMERA</code>
     * <p>The h 20 camera device camera field.</p>
     */
    H20_CAMERA(42),
    /**
     * <code>H20T_CAMERA</code>
     * <p>The h 20 t camera device camera field.</p>
     */
    H20T_CAMERA(43),
    /**
     * <code>H20N_CAMERA</code>
     * <p>The h 20 n camera device camera field.</p>
     */
    H20N_CAMERA(61),
    /**
     * <code>H30_CAMERA</code>
     * <p>The h 30 camera device camera field.</p>
     */
    H30_CAMERA(82),
    /**
     * <code>H30T_CAMERA</code>
     * <p>The h 30 t camera device camera field.</p>
     */
    H30T_CAMERA(83),

    /**
     * <code>M30_CAMERA</code>
     * <p>The m 30 camera device camera field.</p>
     */
    M30_CAMERA(52),
    /**
     * <code>M30T_CAMERA</code>
     * <p>The m 30 t camera device camera field.</p>
     */
    M30T_CAMERA(53),

    /**
     * <code>M4E_CAMERA</code>
     * <p>The m 4 e camera device camera field.</p>
     */
    M4E_CAMERA(88),
    /**
     * <code>M4T_CAMERA</code>
     * <p>The m 4 t camera device camera field.</p>
     */
    M4T_CAMERA(89),

    /**
     * <code>M3E_CAMERA</code>
     * <p>The m 3 e camera device camera field.</p>
     */
    M3E_CAMERA(66),
    /**
     * <code>M3T_CAMERA</code>
     * <p>The m 3 t camera device camera field.</p>
     */
    M3T_CAMERA(67),
    /**
     * <code>M3M_CAMERA</code>
     * <p>The m 3 m camera device camera field.</p>
     */
    M3M_CAMERA(68),

    /**
     * <code>M3D_CAMERA</code>
     * <p>The m 3 d camera device camera field.</p>
     */
    M3D_CAMERA(80),
    /**
     * <code>M3TD_CAMERA</code>
     * <p>The m 3 td camera device camera field.</p>
     */
    M3TD_CAMERA(81),

    /**
     * <code>M4D_CAMERA</code>
     * <p>The m 4 d camera device camera field.</p>
     */
    M4D_CAMERA(98),
    /**
     * <code>M4TD_CAMERA</code>
     * <p>The m 4 td camera device camera field.</p>
     */
    M4TD_CAMERA(99),
    /**
     * <code>DOCK_CAMERA</code>
     * <p>The dock camera device camera field.</p>
     */
    DOCK_CAMERA(165),

    /**
     * <code>UNKNOWN</code>
     * <p>The unknown device camera field.</p>
     */
    UNKNOWN(99999),
    ;

    /**
     * <code>key</code>
     * {@link java.lang.Integer} <p>The <code>key</code> field.</p>
     * @see java.lang.Integer
     */
    private final Integer key;

    /**
     * <code>DeviceCamera</code>
     * <p>Instantiates a new device camera.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @see java.lang.Integer
     */
    DeviceCamera(Integer key) {
        this.key = key;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.key;
    }

    /**
     * <code>parseKey</code>
     * <p>The parse key method.</p>
     * @param key {@link java.lang.Integer} <p>The key parameter is <code>Integer</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.enums.device.DeviceCamera} <p>The parse key return object is <code>DeviceCamera</code> type.</p>
     * @see java.lang.Integer
     * @see com.fasterxml.jackson.annotation.JsonCreator
     */
    @JsonCreator
    public static DeviceCamera parseKey(Integer key) {
        DeviceCamera parsedKey = RestKey.parseKey(DeviceCamera.class, key);
        return Optional.ofNullable(parsedKey).orElse(DeviceCamera.UNKNOWN);
    }
}
