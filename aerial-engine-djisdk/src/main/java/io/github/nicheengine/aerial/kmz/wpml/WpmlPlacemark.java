package io.github.nicheengine.aerial.kmz.wpml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.action.XmlActionGroup;
import io.github.nicheengine.aerial.kmz.serialize.XmlActionGroupListDeserializer;
import io.github.nicheengine.aerial.kmz.serialize.XmlPointDeserializer;
import io.github.nicheengine.aerial.kmz.xml.XmlPoint;
import io.github.nicheengine.aerial.kmz.xml.XmlWaypointTurnParam;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
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
public class WpmlPlacemark implements Serializable {
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
    @JacksonXmlProperty(localName = "executeHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "executeHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double executeHeight;
    @JacksonXmlProperty(localName = "waypointSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointSpeed;
    @JacksonXmlProperty(localName = "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected WpmlWaypointHeadingParam waypointHeadingParam;
    @JacksonXmlProperty(localName = "waypointTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlWaypointTurnParam waypointTurnParam;
    @JacksonXmlProperty(localName = "waypointGimbalHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointGimbalHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected WpmlWaypointGimbalHeadingParam waypointGimbalHeadingParam;
    @JacksonXmlProperty(localName = "useStraightLine", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useStraightLine", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useStraightLine;
    @JacksonXmlProperty(localName = "waypointWorkType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointWorkType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointWorkType;
    @XmlElements(
            @XmlElement(name = "actionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
    )
    @JacksonXmlProperty(localName = "actionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @JsonDeserialize(using = XmlActionGroupListDeserializer.class)
    @JacksonXmlElementWrapper(useWrapping = false)
    protected List<XmlActionGroup> actionGroup;

    public static WpmlPlacemark defaultInstance() {
        WpmlPlacemark kmlPlacemarkPoint = new WpmlPlacemark();
        kmlPlacemarkPoint.setIsRisky(0);
        kmlPlacemarkPoint.setIndex(0);
        kmlPlacemarkPoint.setWaypointSpeed(10);
        kmlPlacemarkPoint.setPoint(XmlPoint.defaultInstance);
        kmlPlacemarkPoint.setWaypointHeadingParam(WpmlWaypointHeadingParam.defaultInstance());
        kmlPlacemarkPoint.setWaypointTurnParam(XmlWaypointTurnParam.defaultInstance());
        kmlPlacemarkPoint.setUseStraightLine(0);
        kmlPlacemarkPoint.setWaypointGimbalHeadingParam(WpmlWaypointGimbalHeadingParam.defaultInstance());
        kmlPlacemarkPoint.setWaypointWorkType(0);
        kmlPlacemarkPoint.setActionGroup(new ArrayList<>());
        return kmlPlacemarkPoint;
    }
}
