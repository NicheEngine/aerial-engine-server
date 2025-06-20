package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.serialize.KmlPlacemarkListDeserializer;
import io.github.nicheengine.aerial.kmz.xml.XmlGlobalWaypointHeadingParam;
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
@JacksonXmlRootElement(localName =  "Folder", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Folder", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlFolder implements Serializable {
    @JacksonXmlProperty(localName = "templateId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "templateId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer templateId;
    @JacksonXmlProperty(localName = "templateType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "templateType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String templateType;
    @JacksonXmlProperty(localName = "autoFlightSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "autoFlightSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer autoFlightSpeed;
    @JacksonXmlProperty(localName = "waylineCoordinateSysParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waylineCoordinateSysParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected KmlWaylineCoordinateSysParam waylineCoordinateSysParam;
    @JacksonXmlProperty(localName = "payloadParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected KmlPayloadParam payloadParam;
    @JacksonXmlProperty(localName = "globalWaypointTurnMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "globalWaypointTurnMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String globalWaypointTurnMode;
    @JacksonXmlProperty(localName = "globalUseStraightLine", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "globalUseStraightLine", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer globalUseStraightLine;
    @JacksonXmlProperty(localName = "gimbalPitchMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalPitchMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String gimbalPitchMode;
    @JacksonXmlProperty(localName = "globalHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "globalHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer globalHeight;
    @JacksonXmlProperty(localName = "globalWaypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "globalWaypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlGlobalWaypointHeadingParam globalWaypointHeadingParam;
    @JacksonXmlProperty(localName = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer caliFlightEnable;

    @XmlElementRefs({
            @XmlElementRef(name = "Placemark", type=KmlPlacemark.class, namespace = KmzConstants.XMLNS_VALUE, required = false)
    })
    @JsonDeserialize(using = KmlPlacemarkListDeserializer.class)
    @JacksonXmlProperty(localName = "Placemark", namespace = KmzConstants.XMLNS_VALUE)
    @JacksonXmlElementWrapper(useWrapping = false)
    protected List<KmlPlacemark> Placemark;

    public static KmlFolder defaultInstance() {
        KmlFolder kmlFolder = new KmlFolder();
        kmlFolder.setTemplateId(0);
        kmlFolder.setTemplateType("waypoint");
        kmlFolder.setAutoFlightSpeed(10);
        kmlFolder.setWaylineCoordinateSysParam(KmlWaylineCoordinateSysParam.defaultInstance());
        kmlFolder.setPayloadParam(KmlPayloadParam.defaultInstance());
        kmlFolder.setGlobalWaypointTurnMode("toPointAndStopWithDiscontinuityCurvature");
        kmlFolder.setGlobalUseStraightLine(1);
        kmlFolder.setGimbalPitchMode("manual");
        kmlFolder.setGlobalHeight(100);
        kmlFolder.setGlobalWaypointHeadingParam(XmlGlobalWaypointHeadingParam.defaultInstance());
        kmlFolder.setCaliFlightEnable(0);
        kmlFolder.setPlacemark(new ArrayList<>());
        return kmlFolder;
    }
}
