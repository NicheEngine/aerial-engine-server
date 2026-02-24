package io.github.nicheengine.aerial.kmz.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.kmz.action.XmlActionGroup;
import io.github.nichetoolkit.rest.util.DeserializeUtils;
import io.github.nichetoolkit.rest.util.JacksonUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class XmlActionGroupListDeserializer extends JsonDeserializer<List<XmlActionGroup>> {
    @Override
    public List<XmlActionGroup> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Map<String, JsonNode> actionGroupListMap = DeserializeUtils.deserializerBean(jsonParser);
        JsonNode jsonNode = actionGroupListMap.get("actionGroup");
        List<JsonNode> actionGroups = DeserializeUtils.deserializerList(jsonNode);
        return actionGroups.stream().map(actionGroup -> JacksonUtils.parseConvert(actionGroup, XmlActionGroup.class)).collect(Collectors.toList());
    }
}
