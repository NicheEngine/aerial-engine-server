package io.github.nicheengine.aerial.kmz.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = false)
public class XmlActionFocus extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "isPointFocus", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "isPointFocus", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer isPointFocus;
    @JacksonXmlProperty(localName = "focusX", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "focusX", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double focusX;
    @JacksonXmlProperty(localName = "focusY", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "focusY", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double focusY;
    @JacksonXmlProperty(localName = "focusRegionWidth", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "focusRegionWidth", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double focusRegionWidth;
    @JacksonXmlProperty(localName = "focusRegionHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "focusRegionHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double focusRegionHeight;
    @JacksonXmlProperty(localName = "isInfiniteFocus", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "isInfiniteFocus", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer isInfiniteFocus;

    public static XmlActionFocus defaultInstance() {
        XmlActionFocus xmlActionActuatorFuncParam = new XmlActionFocus();
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        xmlActionActuatorFuncParam.setIsPointFocus(0);
        xmlActionActuatorFuncParam.setFocusX(0.25d);
        xmlActionActuatorFuncParam.setFocusY(0.25d);
        xmlActionActuatorFuncParam.setFocusRegionWidth(0.5d);
        xmlActionActuatorFuncParam.setFocusRegionHeight(0.5d);
        xmlActionActuatorFuncParam.setIsInfiniteFocus(0);
        return xmlActionActuatorFuncParam;
    }
}
