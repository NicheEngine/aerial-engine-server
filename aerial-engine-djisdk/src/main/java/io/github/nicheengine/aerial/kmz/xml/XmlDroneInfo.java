package io.github.nicheengine.aerial.kmz.xml;

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
@JacksonXmlRootElement(localName =  "droneInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "droneInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlDroneInfo implements Serializable {
    @JacksonXmlProperty(localName = "droneEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "droneEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer droneEnumValue;
    @JacksonXmlProperty(localName = "droneSubEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "droneSubEnumValue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer droneSubEnumValue;

    public static XmlDroneInfo defaultInstance() {
        XmlDroneInfo xmlDroneInfo = new XmlDroneInfo();
        xmlDroneInfo.setDroneEnumValue(91);
        xmlDroneInfo.setDroneSubEnumValue(0);
        return xmlDroneInfo;
    };

}
