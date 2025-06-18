package io.github.nicheengine.aerial.kmz;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;

import java.util.Optional;

public enum KmzActionMode implements RestValue<String,String> {
    TAKE_PHOTO("takePhoto","拍照"),
    START_RECORD("startRecord","开始录像"),
    STOP_RECORD("stopRecord","结束录像"),
    FOCUS("focus","对焦"),
    ZOOM("zoom","变焦"),
    CUSTOM_DIR_NAME("customDirName","创建新文件夹"),
    GIMBAL_ROTATE("gimbalRotate","旋转云台"),
    ROTATE_YAW("rotateYaw","飞行器偏航"),
    HOVER("hover","悬停"),
    GIMBAL_EVENLY_ROTATE("gimbalEvenlyRotate","航段间均匀转动云台"),
    ORIENTED_SHOOT("orientedShoot","定向拍照"),
    PANO_SHOT("panoShot","全景拍照"),
    RECORD_POINT_CLOUD("recordPointCloud","点云录制"),
    MEGAPHONE("megaphone","喊话"),
    SEARCH_LIGHT("searchLight","探照灯"),
    STOP_MULTIPLE("","停止间隔"),

    NONE(null,"无动作"),
    ;
    private final String key;
    private final String value;

    KmzActionMode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static KmzActionMode parseKey(String key) {
        KmzActionMode sortTypeEnum = RestKey.parseKey(KmzActionMode.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(KmzActionMode.NONE);
    }


    @JsonCreator
    public static KmzActionMode parseValue(String value) {
        KmzActionMode sortTypeEnum = RestValue.parseValue(KmzActionMode.class, value);
        return Optional.ofNullable(sortTypeEnum).orElse(KmzActionMode.NONE);
    }
}
