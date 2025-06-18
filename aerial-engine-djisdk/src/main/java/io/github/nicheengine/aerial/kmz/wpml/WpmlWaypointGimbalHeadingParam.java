package io.github.nicheengine.aerial.kmz.wpml;

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
@JacksonXmlRootElement(localName =  "waypointGimbalHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "waypointGimbalHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class WpmlWaypointGimbalHeadingParam implements Serializable {
    @JacksonXmlProperty(localName = "waypointGimbalPitchAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointGimbalPitchAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointGimbalPitchAngle;
    @JacksonXmlProperty(localName = "waypointGimbalYawAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointGimbalYawAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointGimbalYawAngle;

    public static WpmlWaypointGimbalHeadingParam defaultInstance() {
        WpmlWaypointGimbalHeadingParam wpmlWaypointGimbalHeadingParam = new WpmlWaypointGimbalHeadingParam();
        wpmlWaypointGimbalHeadingParam.setWaypointGimbalPitchAngle(0);
        wpmlWaypointGimbalHeadingParam.setWaypointGimbalYawAngle(0);
        return wpmlWaypointGimbalHeadingParam;
    }
}
