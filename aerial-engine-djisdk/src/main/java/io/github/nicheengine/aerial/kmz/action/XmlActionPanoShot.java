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
public class XmlActionPanoShot extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "payloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String payloadLensIndex;
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "useGlobalPayloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useGlobalPayloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useGlobalPayloadLensIndex;
    @JacksonXmlProperty(localName = "panoShotSubMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "panoShotSubMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String panoShotSubMode;
    @JacksonXmlProperty(localName = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String actionUUID;


    public static XmlActionPanoShot defaultInstance() {
        XmlActionPanoShot xmlActionActuatorFuncParam = new XmlActionPanoShot();
        xmlActionActuatorFuncParam.setPayloadLensIndex("visable");
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        xmlActionActuatorFuncParam.setUseGlobalPayloadLensIndex(0);
        xmlActionActuatorFuncParam.setPanoShotSubMode("panoShot_360");
        xmlActionActuatorFuncParam.setActionUUID(KmzUuid.uuid_v4());
        return xmlActionActuatorFuncParam;
    }
}
