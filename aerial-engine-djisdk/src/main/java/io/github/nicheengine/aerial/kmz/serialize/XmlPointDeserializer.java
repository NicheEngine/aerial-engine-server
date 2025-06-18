package io.github.nicheengine.aerial.kmz.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.kmz.xml.XmlPoint;
import io.github.nichetoolkit.rest.util.DeserializeUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;

import java.util.Map;

public class XmlPointDeserializer extends JsonDeserializer<XmlPoint> {
    @Override
    public XmlPoint deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Map<String, JsonNode> pointMap = DeserializeUtils.deserializerBean(jsonParser);
        XmlPoint point = new XmlPoint();
        if (pointMap.containsKey("coordinates")) {
            String coordinates = pointMap.get("coordinates").asText();
            if (GeneralUtils.isNotEmpty(coordinates)) {
                String trim = coordinates.trim();
                point.setCoordinates(trim);
            }
        }
        return point;
    }
}
