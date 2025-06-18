package io.github.nicheengine.aerial.kmz.xml;

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
@JacksonXmlRootElement(localName =  "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlWaypointHeadingParam implements Serializable {
    @JacksonXmlProperty(localName = "waypointPoiPoint", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointPoiPoint", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String waypointPoiPoint;
    @JacksonXmlProperty(localName = "waypointHeadingAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointHeadingAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointHeadingAngle;
    @JacksonXmlProperty(localName = "waypointHeadingMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointHeadingMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String waypointHeadingMode;
    @JacksonXmlProperty(localName = "waypointHeadingPoiIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointHeadingPoiIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointHeadingPoiIndex;
    @JacksonXmlProperty(localName = "waypointHeadingPathMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointHeadingPathMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String waypointHeadingPathMode;

    public static XmlWaypointHeadingParam defaultInstance() {
        XmlWaypointHeadingParam xmlWaypointHeadingParam = new XmlWaypointHeadingParam();
        xmlWaypointHeadingParam.setWaypointPoiPoint("0.000000,0.000000,0.000000");
        xmlWaypointHeadingParam.setWaypointHeadingAngle(0);
        xmlWaypointHeadingParam.setWaypointHeadingMode("followWayline");
        xmlWaypointHeadingParam.setWaypointHeadingPoiIndex(0);
        xmlWaypointHeadingParam.setWaypointHeadingPathMode("followBadArc");
        return xmlWaypointHeadingParam;
    }
}
