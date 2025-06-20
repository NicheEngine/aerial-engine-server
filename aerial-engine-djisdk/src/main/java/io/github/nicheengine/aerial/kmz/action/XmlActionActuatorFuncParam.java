package io.github.nicheengine.aerial.kmz.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({XmlActionTakePhoto.class,
        XmlActionStartRecord.class,
        XmlActionStopRecord.class,
        XmlActionFocus.class,
        XmlActionZoom.class,
        XmlActionCustomDirName.class,
        XmlActionGimbalRotate.class,
        XmlActionRotateYaw.class,
        XmlActionHover.class,
        XmlActionGimbalEvenlyRotate.class,
        XmlActionOrientedShoot.class,
        XmlActionPanoShot.class,
        XmlActionRecordPointCloud.class,
        XmlActionMegaphone.class,
        XmlActionSearchLight.class
})
public class XmlActionActuatorFuncParam implements Serializable {
}
