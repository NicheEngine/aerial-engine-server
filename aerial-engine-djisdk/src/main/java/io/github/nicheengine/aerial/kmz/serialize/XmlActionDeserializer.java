package io.github.nicheengine.aerial.kmz.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.enums.ActionMode;
import io.github.nicheengine.aerial.kmz.action.*;
import io.github.nichetoolkit.rest.util.DeserializeUtils;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;

import java.util.Map;

public class XmlActionDeserializer extends JsonDeserializer<XmlAction> {
    @Override
    public XmlAction deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Map<String, JsonNode> actionMap = DeserializeUtils.deserializerBean(jsonParser);
        XmlAction action = new XmlAction();
        if (actionMap.containsKey("actionId")) {
            action.setActionId(actionMap.get("actionId").asInt());
        }
        if (actionMap.containsKey("actionActuatorFunc")) {
            JsonNode jsonNodeActuatorFunc = actionMap.get("actionActuatorFunc");
            String actionActuatorFunc = jsonNodeActuatorFunc.asText();
            action.setActionActuatorFunc(actionActuatorFunc);

            if (actionMap.containsKey("actionActuatorFuncParam")) {
                JsonNode jsonNode = actionMap.get("actionActuatorFuncParam");
                ActionMode actionMode = ActionMode.parseKey(actionActuatorFunc);
                XmlActionActuatorFuncParam xmlActionActuatorFuncParam = funcParamOfActionMode(actionMode, jsonNode);
                action.setActionActuatorFuncParam(xmlActionActuatorFuncParam);
            }

        }
        return action;
    }

    private XmlActionActuatorFuncParam funcParamOfActionMode(ActionMode actionMode, JsonNode jsonNode) {
        switch (actionMode) {
            case ACTION_TAKE_PHOTO:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionTakePhoto.class);
            case ACTION_START_RECORD:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionStartRecord.class);
            case ACTION_STOP_RECORD:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionStopRecord.class);
            case ACTION_FOCUS:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionFocus.class);
            case ACTION_ZOOM:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionZoom.class);
            case ACTION_CUSTOM_DIR_NAME:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionCustomDirName.class);
            case ACTION_GIMBAL_ROTATE:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionGimbalRotate.class);
            case ACTION_ROTATE_YAW:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionRotateYaw.class);
            case ACTION_HOVER:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionHover.class);
            case ACTION_GIMBAL_EVENLY_ROTATE:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionGimbalEvenlyRotate.class);
            case ACTION_ORIENTED_SHOOT:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionOrientedShoot.class);
            case ACTION_PANO_SHOT:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionPanoShot.class);
            case ACTION_RECORD_POINT_CLOUD:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionRecordPointCloud.class);
            case ACTION_MEGAPHONE:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionMegaphone.class);
            case ACTION_SEARCH_LIGHT:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionSearchLight.class);
        }
        return new XmlActionActuatorFuncParam();
    }

}
