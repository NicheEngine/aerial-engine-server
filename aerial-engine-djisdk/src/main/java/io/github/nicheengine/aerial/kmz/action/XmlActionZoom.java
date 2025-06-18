package io.github.nicheengine.aerial.kmz.action;

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
@JacksonXmlRootElement(localName =  "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class XmlActionZoom extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "isUseFocalFactor", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "isUseFocalFactor", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer isUseFocalFactor;
    @JacksonXmlProperty(localName = "focalLength", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "focalLength", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer focalLength;

    public static XmlActionZoom defaultInstance() {
        XmlActionZoom xmlActionActuatorFuncParam = new XmlActionZoom();
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        xmlActionActuatorFuncParam.setIsUseFocalFactor(0);
        xmlActionActuatorFuncParam.setFocalLength(24);
        return xmlActionActuatorFuncParam;
    }
}
