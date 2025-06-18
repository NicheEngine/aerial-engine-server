package io.github.nicheengine.aerial.kmz.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.KmzUuid;
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
public class XmlActionSearchLight extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String actionUUID;
    @JacksonXmlProperty(localName = "searchlightBrightness", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "searchlightBrightness", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer searchlightBrightness;

    public static XmlActionSearchLight defaultInstance() {
        XmlActionSearchLight xmlActionActuatorFuncParam = new XmlActionSearchLight();
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        xmlActionActuatorFuncParam.setActionUUID(KmzUuid.uuid_v4());
        xmlActionActuatorFuncParam.setSearchlightBrightness(50);
        return xmlActionActuatorFuncParam;
    }
}
