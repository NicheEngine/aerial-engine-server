package io.github.nicheengine.aerial.kmz.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.kmz.action.XmlActionGroup;
import io.github.nichetoolkit.rest.util.DeserializeUtils;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;

import java.util.List;
import java.util.stream.Collectors;

public class KmlActionGroupListDeserializer extends JsonDeserializer<List<XmlActionGroup>> {
    @Override
    public List<XmlActionGroup> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        List<JsonNode> actionGroups = DeserializeUtils.deserializerList(jsonParser);
        return actionGroups.stream().map(actionGroup -> JsonPurityUtils.parseConvert(actionGroup, XmlActionGroup.class)).collect(Collectors.toList());
    }
}
