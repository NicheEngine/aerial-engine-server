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
public class XmlActionMegaphone extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String actionUUID;
    @JacksonXmlProperty(localName = "megaphoneOperateType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneOperateType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer megaphoneOperateType;
    @JacksonXmlProperty(localName = "megaphoneOperateVolume", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneOperateVolume", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer megaphoneOperateVolume;
    @JacksonXmlProperty(localName = "megaphoneOperateLoop", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneOperateLoop", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer megaphoneOperateLoop;
    @JacksonXmlProperty(localName = "megaphoneOperateFilePath", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneOperateFilePath", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String megaphoneOperateFilePath;
    @JacksonXmlProperty(localName = "megaphoneFileName", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneFileName", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String megaphoneFileName;
    @JacksonXmlProperty(localName = "megaphoneFileOriginalName", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneFileOriginalName", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String megaphoneFileOriginalName;
    @JacksonXmlProperty(localName = "megaphoneFileMd5", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneFileMd5", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String megaphoneFileMd5;
    @JacksonXmlProperty(localName = "megaphoneFileBitrate", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "megaphoneFileBitrate", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer megaphoneFileBitrate;

    public static XmlActionMegaphone defaultInstance() {
        XmlActionMegaphone xmlActionActuatorFuncParam = new XmlActionMegaphone();
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        xmlActionActuatorFuncParam.setActionUUID(KmzUuid.uuid_v4());
        xmlActionActuatorFuncParam.setMegaphoneOperateVolume(50);
        xmlActionActuatorFuncParam.setMegaphoneOperateLoop(0);
        xmlActionActuatorFuncParam.setMegaphoneFileBitrate(4);
        return xmlActionActuatorFuncParam;
    }

    public static XmlActionMegaphone startMegaphone() {
        XmlActionMegaphone xmlActionActuatorFuncParam = defaultInstance();
        xmlActionActuatorFuncParam.setMegaphoneOperateType(0);
        return xmlActionActuatorFuncParam;
    }

    public static XmlActionMegaphone stopMegaphone() {
        XmlActionMegaphone xmlActionActuatorFuncParam = defaultInstance();
        xmlActionActuatorFuncParam.setMegaphoneOperateType(1);
        return xmlActionActuatorFuncParam;
    }
}
