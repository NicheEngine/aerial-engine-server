package io.github.nicheengine.aerial.kmz.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.kmz.action.XmlAction;
import io.github.nichetoolkit.rest.util.DeserializeUtils;
import io.github.nichetoolkit.rest.util.JacksonUtils;

import java.util.List;
import java.util.stream.Collectors;

public class XmlActionListDeserializer extends JsonDeserializer<List<XmlAction>> {
    @Override
    public List<XmlAction> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        List<JsonNode> actions = DeserializeUtils.deserializerList(jsonParser);
        return actions.stream().map(action -> JacksonUtils.parseConvert(action,XmlAction.class)).collect(Collectors.toList());
    }
}
