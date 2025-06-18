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
@JacksonXmlRootElement(localName =  "payloadInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "payloadInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlPayloadInfo implements Serializable {
    @JacksonXmlProperty(localName = "payloadEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer autoRerouteInfo;
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "payloadSubEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadSubEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadSubEnumValue;

    public static XmlPayloadInfo defaultInstance() {
        XmlPayloadInfo xmlPayloadInfo = new XmlPayloadInfo();
        xmlPayloadInfo.setAutoRerouteInfo(80);
        xmlPayloadInfo.setPayloadPositionIndex(0);
        xmlPayloadInfo.setPayloadSubEnumValue(0);
        return xmlPayloadInfo;
    }
}
