package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "overlap", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "overlap", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlOverlap implements Serializable {
    @JacksonXmlProperty(localName = "orthoLidarOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orthoLidarOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orthoLidarOverlapH;
    @JacksonXmlProperty(localName = "orthoLidarOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orthoLidarOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orthoLidarOverlapW;
    @JacksonXmlProperty(localName = "orthoCameraOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orthoCameraOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orthoCameraOverlapH;
    @JacksonXmlProperty(localName = "orthoCameraOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orthoCameraOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orthoCameraOverlapW;
    @JacksonXmlProperty(localName = "inclinedLidarOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "inclinedLidarOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer inclinedLidarOverlapH;
    @JacksonXmlProperty(localName = "inclinedLidarOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "inclinedLidarOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer inclinedLidarOverlapW;
    @JacksonXmlProperty(localName = "inclinedCameraOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "inclinedCameraOverlapH", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer inclinedCameraOverlapH;
    @JacksonXmlProperty(localName = "inclinedCameraOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "inclinedCameraOverlapW", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer inclinedCameraOverlapW;

    public static KmlOverlap defaultInstance() {
        KmlOverlap kmlOverlap = new KmlOverlap();
        kmlOverlap.setOrthoLidarOverlapH(0);
        kmlOverlap.setOrthoLidarOverlapW(0);
        kmlOverlap.setOrthoCameraOverlapH(0);
        kmlOverlap.setOrthoCameraOverlapW(0);
        kmlOverlap.setInclinedLidarOverlapH(0);
        kmlOverlap.setInclinedLidarOverlapW(0);
        kmlOverlap.setInclinedCameraOverlapH(0);
        kmlOverlap.setInclinedCameraOverlapW(0);
        return kmlOverlap;
    }

}
