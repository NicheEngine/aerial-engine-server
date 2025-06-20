package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.action.XmlActionGroup;
import io.github.nicheengine.aerial.kmz.serialize.KmlActionGroupListDeserializer;
import io.github.nicheengine.aerial.kmz.serialize.XmlPointDeserializer;
import io.github.nicheengine.aerial.kmz.xml.XmlPoint;
import io.github.nicheengine.aerial.kmz.xml.XmlWaypointHeadingParam;
import io.github.nicheengine.aerial.kmz.xml.XmlWaypointTurnParam;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "Placemark", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Placemark", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = true)
public class KmlPlacemarkPoint extends KmlPlacemark {
    @JacksonXmlProperty(localName = "isRisky", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "isRisky", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer isRisky;
    @JacksonXmlProperty(localName = "index", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "index", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer index;
    @JacksonXmlProperty(localName = "Point", namespace = KmzConstants.XMLNS_VALUE)
    @JsonDeserialize(using = XmlPointDeserializer.class)
    @XmlElement(name = "Point", namespace = KmzConstants.XMLNS_VALUE)
    protected XmlPoint Point;
    @JacksonXmlProperty(localName = "useGlobalHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useGlobalHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useGlobalHeight;
    @JacksonXmlProperty(localName = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double ellipsoidHeight;
    @JacksonXmlProperty(localName = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double height;
    @JacksonXmlProperty(localName = "useGlobalSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useGlobalSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useGlobalSpeed;
    @JacksonXmlProperty(localName = "waypointSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointSpeed;
    @JacksonXmlProperty(localName = "useGlobalHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useGlobalHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useGlobalHeadingParam;
    @JacksonXmlProperty(localName = "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlWaypointHeadingParam waypointHeadingParam;
    @JacksonXmlProperty(localName = "useGlobalTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useGlobalTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useGlobalTurnParam;
    @JacksonXmlProperty(localName = "waypointTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlWaypointTurnParam waypointTurnParam;
    @JacksonXmlProperty(localName = "useStraightLine", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useStraightLine", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useStraightLine;
    @XmlElements(
            @XmlElement(name = "actionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
    )
    @JacksonXmlProperty(localName = "actionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @JsonDeserialize(using = KmlActionGroupListDeserializer.class)
    protected List<XmlActionGroup> actionGroup;

    public static KmlPlacemarkPoint defaultInstance() {
        KmlPlacemarkPoint kmlPlacemarkPoint = new KmlPlacemarkPoint();
        kmlPlacemarkPoint.setIsRisky(0);
        kmlPlacemarkPoint.setIndex(0);
        kmlPlacemarkPoint.setPoint(XmlPoint.defaultInstance);
        kmlPlacemarkPoint.setUseGlobalHeight(0);
        kmlPlacemarkPoint.setEllipsoidHeight(100.0);
        kmlPlacemarkPoint.setHeight(100.0d);
        kmlPlacemarkPoint.setUseGlobalSpeed(1);
        kmlPlacemarkPoint.setWaypointSpeed(10);
        kmlPlacemarkPoint.setUseGlobalHeadingParam(1);
        kmlPlacemarkPoint.setWaypointHeadingParam(XmlWaypointHeadingParam.defaultInstance());
        kmlPlacemarkPoint.setUseGlobalTurnParam(1);
        kmlPlacemarkPoint.setWaypointTurnParam(XmlWaypointTurnParam.defaultInstance());
        kmlPlacemarkPoint.setUseStraightLine(1);
//        kmlPlacemarkPoint.setActionGroup(new ArrayList<>());
        return kmlPlacemarkPoint;
    }
}
