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
public class XmlActionHover extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "hoverTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "hoverTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer hoverTime;

    public static XmlActionHover defaultInstance() {
        XmlActionHover xmlActionActuatorFuncParam = new XmlActionHover();
        xmlActionActuatorFuncParam.setHoverTime(10);
        return xmlActionActuatorFuncParam;
    }
}
