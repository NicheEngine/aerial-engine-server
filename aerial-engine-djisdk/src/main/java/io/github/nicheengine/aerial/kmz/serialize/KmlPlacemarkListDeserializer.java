package io.github.nicheengine.aerial.kmz.serialize;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.nicheengine.aerial.kmz.kml.*;
import io.github.nichetoolkit.rest.util.DeserializeUtils;
import io.github.nichetoolkit.rest.util.JsonPurityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KmlPlacemarkListDeserializer extends JsonDeserializer<List<KmlPlacemark>> {
    @Override
    public List<KmlPlacemark> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        Map<String, JsonNode> placemarkListMap = DeserializeUtils.deserializerBean(jsonParser);
        JsonNode jsonNode = placemarkListMap.get("Placemark");
        List<JsonNode> placemarks = DeserializeUtils.deserializerList(jsonNode);
        return placemarks.stream().map(placemark -> {
            Map<String, JsonNode> placemarkMap = DeserializeUtils.deserializerBean(placemark);
            return placemarkOfPlacemarkMap(placemarkMap, placemark);
        }).collect(Collectors.toList());
    }


    private KmlPlacemark placemarkOfPlacemarkMap(Map<String, JsonNode> placemarkMap, JsonNode jsonNode) {
        if (placemarkMap.containsKey("Polygon")) {
            JsonNode polygonNode = placemarkMap.get("Polygon");
            Map<String, JsonNode> polygonMap = DeserializeUtils.deserializerBean(polygonNode);
            if (polygonMap.containsKey("mappingHeadingParam")) {
                return JsonPurityUtils.parseConvert(jsonNode, KmlPlacemarkMapping.class);
            } else {
                return JsonPurityUtils.parseConvert(jsonNode, KmlPlacemarkPolygon.class);
            }
        } else if (placemarkMap.containsKey("LineString")) {
            return JsonPurityUtils.parseConvert(jsonNode, KmlPlacemarkLineString.class);
        } else if (placemarkMap.containsKey("Point")) {
            return JsonPurityUtils.parseConvert(jsonNode, KmlPlacemarkPoint.class);
        }
        return new KmlPlacemark();
    }

}
