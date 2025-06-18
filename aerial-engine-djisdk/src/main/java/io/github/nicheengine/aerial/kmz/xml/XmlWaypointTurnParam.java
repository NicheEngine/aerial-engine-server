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
@JacksonXmlRootElement(localName =  "waypointTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "waypointTurnParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlWaypointTurnParam implements Serializable {
    @JacksonXmlProperty(localName = "waypointTurnDampingDist", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointTurnDampingDist", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double waypointTurnDampingDist;
    @JacksonXmlProperty(localName = "waypointTurnMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointTurnMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String waypointTurnMode;

    public static XmlWaypointTurnParam defaultInstance() {
        XmlWaypointTurnParam xmlWaypointTurnParam = new XmlWaypointTurnParam();
        xmlWaypointTurnParam.setWaypointTurnDampingDist(0.2d);
        xmlWaypointTurnParam.setWaypointTurnMode("toPointAndStopWithDiscontinuityCurvature");
        return xmlWaypointTurnParam;
    }
}
