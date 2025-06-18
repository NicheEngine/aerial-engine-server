package io.github.nicheengine.aerial.kmz.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.kmz.KmzActionMode;
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
                KmzActionMode actionMode = KmzActionMode.parseKey(actionActuatorFunc);
                XmlActionActuatorFuncParam xmlActionActuatorFuncParam = funcParamOfActionMode(actionMode, jsonNode);
                action.setActionActuatorFuncParam(xmlActionActuatorFuncParam);
            }

        }
        return action;
    }

    private XmlActionActuatorFuncParam funcParamOfActionMode(KmzActionMode actionMode, JsonNode jsonNode) {
        switch (actionMode) {
            case TAKE_PHOTO:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionTakePhoto.class);
            case START_RECORD:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionStartRecord.class);
            case STOP_RECORD:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionStopRecord.class);
            case FOCUS:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionFocus.class);
            case ZOOM:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionZoom.class);
            case CUSTOM_DIR_NAME:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionCustomDirName.class);
            case GIMBAL_ROTATE:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionGimbalRotate.class);
            case ROTATE_YAW:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionRotateYaw.class);
            case HOVER:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionHover.class);
            case GIMBAL_EVENLY_ROTATE:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionGimbalEvenlyRotate.class);
            case ORIENTED_SHOOT:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionOrientedShoot.class);
            case PANO_SHOT:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionPanoShot.class);
            case RECORD_POINT_CLOUD:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionRecordPointCloud.class);
            case MEGAPHONE:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionMegaphone.class);
            case SEARCH_LIGHT:
                return JsonPurityUtils.parseConvert(jsonNode, XmlActionSearchLight.class);
        }
        return new XmlActionActuatorFuncParam();
    }

}
