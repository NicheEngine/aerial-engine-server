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
public class XmlActionOrientedShoot extends XmlActionActuatorFuncParam {
    @JacksonXmlProperty(localName = "gimbalPitchRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalPitchRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalPitchRotateAngle;
    @JacksonXmlProperty(localName = "gimbalRollRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalRollRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalRollRotateAngle;
    @JacksonXmlProperty(localName = "gimbalYawRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalYawRotateAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalYawRotateAngle;
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
    @JacksonXmlProperty(localName = "focalLength", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "focalLength", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer focalLength;
    @JacksonXmlProperty(localName = "aircraftHeading", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "aircraftHeading", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer aircraftHeading;
    @JacksonXmlProperty(localName = "accurateFrameValid", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "accurateFrameValid", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer accurateFrameValid;
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "payloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String payloadLensIndex;
    @JacksonXmlProperty(localName = "useGlobalPayloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "useGlobalPayloadLensIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer useGlobalPayloadLensIndex;
    @JacksonXmlProperty(localName = "targetAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "targetAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer targetAngle;
    @JacksonXmlProperty(localName = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionUUID", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String actionUUID;
    @JacksonXmlProperty(localName = "imageWidth", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "imageWidth", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer imageWidth;
    @JacksonXmlProperty(localName = "imageHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "imageHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer imageHeight;
    @JacksonXmlProperty(localName = "AFPos", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "AFPos", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer AFPos;
    @JacksonXmlProperty(localName = "gimbalPort", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "gimbalPort", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer gimbalPort;
    @JacksonXmlProperty(localName = "orientedCameraType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedCameraType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orientedCameraType;
    @JacksonXmlProperty(localName = "orientedFilePath", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedFilePath", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String orientedFilePath;
    @JacksonXmlProperty(localName = "orientedFileMD5", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedFileMD5", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String orientedFileMD5;
    @JacksonXmlProperty(localName = "orientedFileSize", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedFileSize", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orientedFileSize;
    @JacksonXmlProperty(localName = "orientedFileSuffix", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedFileSuffix", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orientedFileSuffix;
    @JacksonXmlProperty(localName = "orientedCameraApertue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedCameraApertue", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orientedCameraApertue;
    @JacksonXmlProperty(localName = "orientedCameraLuminance", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedCameraLuminance", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orientedCameraLuminance;
    @JacksonXmlProperty(localName = "orientedCameraShutterTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedCameraShutterTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orientedCameraShutterTime;
    @JacksonXmlProperty(localName = "orientedCameraISO", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedCameraISO", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer orientedCameraISO;
    @JacksonXmlProperty(localName = "orientedPhotoMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "orientedPhotoMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String orientedPhotoMode;


    public static XmlActionOrientedShoot defaultInstance() {
        XmlActionOrientedShoot xmlActionActuatorFuncParam = new XmlActionOrientedShoot();
        xmlActionActuatorFuncParam.setGimbalPitchRotateAngle(0);
        xmlActionActuatorFuncParam.setGimbalRollRotateAngle(0);
        xmlActionActuatorFuncParam.setGimbalYawRotateAngle(0);
        xmlActionActuatorFuncParam.setFocusX(0.0d);
        xmlActionActuatorFuncParam.setFocusY(0.0d);
        xmlActionActuatorFuncParam.setFocusRegionWidth(0.0d);
        xmlActionActuatorFuncParam.setFocusRegionHeight(0.0d);
        xmlActionActuatorFuncParam.setFocalLength(24);
        xmlActionActuatorFuncParam.setAircraftHeading(0);
        xmlActionActuatorFuncParam.setAccurateFrameValid(0);
        xmlActionActuatorFuncParam.setPayloadPositionIndex(0);
        xmlActionActuatorFuncParam.setPayloadLensIndex("visable");
        xmlActionActuatorFuncParam.setUseGlobalPayloadLensIndex(1);
        xmlActionActuatorFuncParam.setTargetAngle(0);
        xmlActionActuatorFuncParam.setActionUUID(KmzUuid.uuid_v4());
        xmlActionActuatorFuncParam.setImageWidth(0);
        xmlActionActuatorFuncParam.setImageHeight(0);
        xmlActionActuatorFuncParam.setAFPos(0);
        xmlActionActuatorFuncParam.setGimbalPort(0);
        xmlActionActuatorFuncParam.setOrientedCameraType(80);
        xmlActionActuatorFuncParam.setOrientedFilePath(KmzUuid.uuid_v4());
        xmlActionActuatorFuncParam.setOrientedFileSize(0);
        xmlActionActuatorFuncParam.setOrientedPhotoMode("normalPhoto");
        return xmlActionActuatorFuncParam;
    }
}
