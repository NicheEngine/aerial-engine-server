package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "Placemark", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Placemark", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class KmlPlacemarkMapping  extends KmlPlacemark{
    @JacksonXmlProperty(localName = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer caliFlightEnable;
    @JacksonXmlProperty(localName = "elevationOptimizeEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "elevationOptimizeEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer elevationOptimizeEnable;
    @JacksonXmlProperty(localName = "smartObliqueEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "smartObliqueEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer smartObliqueEnable;
    @JacksonXmlProperty(localName = "smartObliqueGimbalPitch", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "smartObliqueGimbalPitch", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer smartObliqueGimbalPitch;
    @JacksonXmlProperty(localName = "shootType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "shootType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String shootType;
    @JacksonXmlProperty(localName = "direction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "direction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer direction;
    @JacksonXmlProperty(localName = "margin", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "margin", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer margin;
    @JacksonXmlProperty(localName = "overlap", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "overlap", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer overlap;
    @JacksonXmlProperty(localName = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double ellipsoidHeight;
    @JacksonXmlProperty(localName = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double height;
    @JacksonXmlProperty(localName = "facadeWaylineEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "facadeWaylineEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer facadeWaylineEnable;
    @JacksonXmlProperty(localName = "Polygon", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "Polygon", namespace = KmzConstants.XMLNS_VALUE)
    protected KmlPolygon Polygon;
    @JacksonXmlProperty(localName = "mappingHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "mappingHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected KmlMappingHeadingParam mappingHeadingParam;
    @JacksonXmlProperty(localName = "gimbalPitchMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalPitchMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String gimbalPitchMode;
    @JacksonXmlProperty(localName = "gimbalPitchAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalPitchAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalPitchAngle;
    @JacksonXmlProperty(localName = "quickOrthoMappingEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "quickOrthoMappingEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer quickOrthoMappingEnable;
    @JacksonXmlProperty(localName = "quickOrthoMappingPitch", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "quickOrthoMappingPitch", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer quickOrthoMappingPitch;

    public static KmlPlacemarkMapping defaultInstance() {
        KmlPlacemarkMapping kmlPlacemarkMapping = new KmlPlacemarkMapping();
        kmlPlacemarkMapping.setCaliFlightEnable(0);
        kmlPlacemarkMapping.setElevationOptimizeEnable(0);
        kmlPlacemarkMapping.setSmartObliqueEnable(0);
        kmlPlacemarkMapping.setSmartObliqueGimbalPitch(0);
        kmlPlacemarkMapping.setShootType("time");
        kmlPlacemarkMapping.setDirection(0);
        kmlPlacemarkMapping.setMargin(0);
        kmlPlacemarkMapping.setOverlap(0);
        kmlPlacemarkMapping.setEllipsoidHeight(100.0d);
        kmlPlacemarkMapping.setHeight(100.0d);
        kmlPlacemarkMapping.setFacadeWaylineEnable(0);
        kmlPlacemarkMapping.setPolygon(KmlPolygon.defaultInstance());
        kmlPlacemarkMapping.setMappingHeadingParam(KmlMappingHeadingParam.defaultInstance());
        kmlPlacemarkMapping.setGimbalPitchMode("manual");
        kmlPlacemarkMapping.setGimbalPitchAngle(0);
        kmlPlacemarkMapping.setQuickOrthoMappingEnable(0);
        kmlPlacemarkMapping.setQuickOrthoMappingPitch(0);
        return kmlPlacemarkMapping;
    }
}
