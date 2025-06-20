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
public class XmlActionRecordPointCloud extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "recordPointCloudOperate", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "recordPointCloudOperate", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String recordPointCloudOperate;

    public static XmlActionRecordPointCloud defaultInstance() {
        XmlActionRecordPointCloud xmlActionActuatorFuncParam = new XmlActionRecordPointCloud();
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        return xmlActionActuatorFuncParam;
    }

    public static XmlActionRecordPointCloud startRecord() {
        XmlActionRecordPointCloud xmlActionActuatorFuncParam = defaultInstance();
        xmlActionActuatorFuncParam.setRecordPointCloudOperate("startRecord");
        return xmlActionActuatorFuncParam;
    }

    public static XmlActionRecordPointCloud pauseRecord() {
        XmlActionRecordPointCloud xmlActionActuatorFuncParam = defaultInstance();
        xmlActionActuatorFuncParam.setRecordPointCloudOperate("pauseRecord");
        return xmlActionActuatorFuncParam;
    }

    public static XmlActionRecordPointCloud resumeRecord() {
        XmlActionRecordPointCloud xmlActionActuatorFuncParam = defaultInstance();
        xmlActionActuatorFuncParam.setRecordPointCloudOperate("resumeRecord");
        return xmlActionActuatorFuncParam;
    }

    public static XmlActionRecordPointCloud stopRecord() {
        XmlActionRecordPointCloud xmlActionActuatorFuncParam = defaultInstance();
        xmlActionActuatorFuncParam.setRecordPointCloudOperate("stopRecord");
        return xmlActionActuatorFuncParam;
    }
}
