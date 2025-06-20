package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import io.github.nichetoolkit.rest.util.I18nUtils;

import java.util.Optional;

public enum ActionMode implements RestValue<String,String> {
    ACTION_TAKE_PHOTO("takePhoto"),
    ACTION_START_RECORD("startRecord"),
    ACTION_STOP_RECORD("stopRecord"),
    ACTION_FOCUS("focus"),
    ACTION_ZOOM("zoom"),
    ACTION_CUSTOM_DIR_NAME("customDirName"),
    ACTION_GIMBAL_ROTATE("gimbalRotate"),
    ACTION_ROTATE_YAW("rotateYaw"),
    ACTION_HOVER("hover"),
    ACTION_GIMBAL_EVENLY_ROTATE("gimbalEvenlyRotate"),
    ACTION_ORIENTED_SHOOT("orientedShoot"),
    ACTION_PANO_SHOT("panoShot"),
    ACTION_RECORD_POINT_CLOUD("recordPointCloud"),
    ACTION_MEGAPHONE("megaphone"),
    ACTION_SEARCH_LIGHT("searchLight"),
    ACTION_STOP_MULTIPLE(""),

    ACTION_NONE(null),
    ;
    private final String action;
    private final String modeName;

    ActionMode(String action) {
        this.action = action;
        this.modeName = I18nUtils.message(name());
    }

    ActionMode(String action, String modeName) {
        this.action = action;
        this.modeName = modeName;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.action;
    }

    @Override
    public String getValue() {
        return this.modeName;
    }

    public static ActionMode parseKey(String key) {
        ActionMode sortTypeEnum = RestKey.parseKey(ActionMode.class, key);
        return Optional.ofNullable(sortTypeEnum).orElse(ActionMode.ACTION_NONE);
    }


    @JsonCreator
    public static ActionMode parseValue(String value) {
        ActionMode parsedKey = RestValue.parseValue(ActionMode.class, value);
        return Optional.ofNullable(parsedKey).orElse(ActionMode.ACTION_NONE);
    }
}
