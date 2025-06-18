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
public class KmlPlacemarkLineString extends KmlPlacemark {
    @JacksonXmlProperty(localName = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer caliFlightEnable;
    @JacksonXmlProperty(localName = "shootType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "shootType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String shootType;
    @JacksonXmlProperty(localName = "direction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "direction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer direction;
    @JacksonXmlProperty(localName = "margin", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "margin", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer margin;
    @JacksonXmlProperty(localName = "singleLineEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "singleLineEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer singleLineEnable;
    @JacksonXmlProperty(localName = "cuttingDistance", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "cuttingDistance", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer cuttingDistance;
    @JacksonXmlProperty(localName = "boundaryOptimEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "boundaryOptimEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer boundaryOptimEnable;
    @JacksonXmlProperty(localName = "leftExtend", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "leftExtend", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer leftExtend;
    @JacksonXmlProperty(localName = "rightExtend", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "rightExtend", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer rightExtend;
    @JacksonXmlProperty(localName = "includeCenterEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "includeCenterEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer includeCenterEnable;
    @JacksonXmlProperty(localName = "overlap", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "overlap", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected KmlOverlap overlap;
    @JacksonXmlProperty(localName = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double ellipsoidHeight;
    @JacksonXmlProperty(localName = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double height;
    @JacksonXmlProperty(localName = "stripUseTemplateAltitude", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "stripUseTemplateAltitude", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer stripUseTemplateAltitude;
    @JacksonXmlProperty(localName = "LineString", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "LineString", namespace = KmzConstants.XMLNS_VALUE)
    protected KmlLineString LineString;

    public static KmlPlacemarkLineString defaultInstance() {
        KmlPlacemarkLineString kmlPlacemarkLineString = new KmlPlacemarkLineString();
        kmlPlacemarkLineString.setCaliFlightEnable(0);
        kmlPlacemarkLineString.setShootType("time");
        kmlPlacemarkLineString.setDirection(0);
        kmlPlacemarkLineString.setMargin(0);
        kmlPlacemarkLineString.setSingleLineEnable(0);
        kmlPlacemarkLineString.setCuttingDistance(0);
        kmlPlacemarkLineString.setBoundaryOptimEnable(0);
        kmlPlacemarkLineString.setLeftExtend(0);
        kmlPlacemarkLineString.setRightExtend(0);
        kmlPlacemarkLineString.setIncludeCenterEnable(0);
        kmlPlacemarkLineString.setOverlap(KmlOverlap.defaultInstance());
        kmlPlacemarkLineString.setEllipsoidHeight(100.0d);
        kmlPlacemarkLineString.setHeight(100.0d);
        kmlPlacemarkLineString.setStripUseTemplateAltitude(0);
        kmlPlacemarkLineString.setLineString(KmlLineString.defaultInstance);
        return kmlPlacemarkLineString;
    }
}
