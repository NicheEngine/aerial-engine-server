package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "Placemark", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Placemark", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class KmlPlacemarkPolygon extends KmlPlacemark {
    @JacksonXmlProperty(localName = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "caliFlightEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer caliFlightEnable;
    @JacksonXmlProperty(localName = "inclinedGimbalPitch", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "inclinedGimbalPitch", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer inclinedGimbalPitch;
    @JacksonXmlProperty(localName = "inclinedFlightSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "inclinedFlightSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double inclinedFlightSpeed;
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
    protected KmlOverlap overlap;
    @JacksonXmlProperty(localName = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "ellipsoidHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double ellipsoidHeight;
    @JacksonXmlProperty(localName = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "height", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double height;
    @JacksonXmlProperty(localName = "Polygon", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "Polygon", namespace = KmzConstants.XMLNS_VALUE)
    protected KmlPolygon Polygon;

    public static KmlPlacemarkPolygon defaultInstance() {
        KmlPlacemarkPolygon kmlPlacemarkPolygon = new KmlPlacemarkPolygon();
        kmlPlacemarkPolygon.setCaliFlightEnable(0);
        kmlPlacemarkPolygon.setInclinedGimbalPitch(0);
        kmlPlacemarkPolygon.setInclinedFlightSpeed(10.0d);
        kmlPlacemarkPolygon.setShootType("time");
        kmlPlacemarkPolygon.setDirection(0);
        kmlPlacemarkPolygon.setMargin(0);
        kmlPlacemarkPolygon.setOverlap(KmlOverlap.defaultInstance());
        kmlPlacemarkPolygon.setEllipsoidHeight(100.0d);
        kmlPlacemarkPolygon.setHeight(100.0d);
        kmlPlacemarkPolygon.setPolygon(KmlPolygon.defaultInstance());
        return kmlPlacemarkPolygon;
    }

}
