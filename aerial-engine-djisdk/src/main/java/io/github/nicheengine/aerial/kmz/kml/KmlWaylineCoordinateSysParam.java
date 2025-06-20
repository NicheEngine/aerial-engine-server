package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "waylineCoordinateSysParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "waylineCoordinateSysParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlWaylineCoordinateSysParam implements Serializable {
    @JacksonXmlProperty(localName = "coordinateMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "coordinateMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String coordinateMode;
    @JacksonXmlProperty(localName = "heightMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "heightMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String heightMode;
    @JacksonXmlProperty(localName = "positioningType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "positioningType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String positioningType;
    @JacksonXmlProperty(localName = "globalShootHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "globalShootHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double globalShootHeight;
    @JacksonXmlProperty(localName = "surfaceFollowModeEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "surfaceFollowModeEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer surfaceFollowModeEnable;
    @JacksonXmlProperty(localName = "surfaceRelativeHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "surfaceRelativeHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double surfaceRelativeHeight;

    public static KmlWaylineCoordinateSysParam defaultInstance() {
        KmlWaylineCoordinateSysParam kmlWaylineCoordinateSysParam = new KmlWaylineCoordinateSysParam();
        kmlWaylineCoordinateSysParam.setCoordinateMode("WGS84");
        kmlWaylineCoordinateSysParam.setHeightMode("EGM96");
        return kmlWaylineCoordinateSysParam;
    }

}
