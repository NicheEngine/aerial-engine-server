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
@JacksonXmlRootElement(localName =  "autoRerouteInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "autoRerouteInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlAutoRerouteInfo implements Serializable {
    @JacksonXmlProperty(localName = "transitionalAutoRerouteMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "transitionalAutoRerouteMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer transitionalAutoRerouteMode;
    @JacksonXmlProperty(localName = "missionAutoRerouteMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "missionAutoRerouteMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer missionAutoRerouteMode;

    public static XmlAutoRerouteInfo defaultInstance() {
        XmlAutoRerouteInfo xmlAutoRerouteInfo = new XmlAutoRerouteInfo();
        xmlAutoRerouteInfo.setTransitionalAutoRerouteMode(1);
        xmlAutoRerouteInfo.setMissionAutoRerouteMode(1);
        return xmlAutoRerouteInfo;
    }

}
