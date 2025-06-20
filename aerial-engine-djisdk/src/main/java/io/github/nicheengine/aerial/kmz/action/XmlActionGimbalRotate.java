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
public class XmlActionGimbalRotate extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "gimbalHeadingYawBase", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalHeadingYawBase", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String gimbalHeadingYawBase;
    @JacksonXmlProperty(localName = "gimbalRotateMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalRotateMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String gimbalRotateMode;
    @JacksonXmlProperty(localName = "gimbalPitchRotateEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalPitchRotateEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalPitchRotateEnable;
    @JacksonXmlProperty(localName = "gimbalPitchRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalPitchRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double gimbalPitchRotateAngle;
    @JacksonXmlProperty(localName = "gimbalRollRotateEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalRollRotateEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalRollRotateEnable;
    @JacksonXmlProperty(localName = "gimbalRollRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalRollRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double gimbalRollRotateAngle;
    @JacksonXmlProperty(localName = "gimbalYawRotateEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalYawRotateEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalYawRotateEnable;
    @JacksonXmlProperty(localName = "gimbalYawRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalYawRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double gimbalYawRotateAngle;
    @JacksonXmlProperty(localName = "gimbalRotateTimeEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalRotateTimeEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalRotateTimeEnable;
    @JacksonXmlProperty(localName = "gimbalRotateTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalRotateTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalRotateTime;

    public static XmlActionGimbalRotate defaultInstance() {
        XmlActionGimbalRotate xmlActionActuatorFuncParam = new XmlActionGimbalRotate();
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        xmlActionActuatorFuncParam.setGimbalHeadingYawBase("north");
        xmlActionActuatorFuncParam.setGimbalRotateMode("absoluteAngle");
        xmlActionActuatorFuncParam.setGimbalPitchRotateEnable(0);
        xmlActionActuatorFuncParam.setGimbalPitchRotateAngle(0.0d);
        xmlActionActuatorFuncParam.setGimbalRollRotateEnable(0);
        xmlActionActuatorFuncParam.setGimbalRollRotateAngle(0.0d);
        xmlActionActuatorFuncParam.setGimbalYawRotateEnable(0);
        xmlActionActuatorFuncParam.setGimbalYawRotateAngle(0.0d);
        xmlActionActuatorFuncParam.setGimbalRotateTimeEnable(0);
        xmlActionActuatorFuncParam.setGimbalRotateTime(0);
        return xmlActionActuatorFuncParam;
    }
}
