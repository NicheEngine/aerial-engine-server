package io.github.nicheengine.aerial.kmz.wpml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.xml.XmlAutoRerouteInfo;
import io.github.nicheengine.aerial.kmz.xml.XmlDroneInfo;
import io.github.nicheengine.aerial.kmz.xml.XmlPayloadInfo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class WpmlMissionConfig implements Serializable {
    @JacksonXmlProperty(localName = "flyToWaylineMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "flyToWaylineMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String flyToWaylineMode;
    @JacksonXmlProperty(localName = "finishAction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "finishAction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String finishAction;
    @JacksonXmlProperty(localName = "exitOnRCLost", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "exitOnRCLost", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String exitOnRCLost;
    @JacksonXmlProperty(localName = "executeRCLostAction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "executeRCLostAction", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String executeRCLostAction;
    @JacksonXmlProperty(localName = "takeOffSecurityHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "takeOffSecurityHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer takeOffSecurityHeight;
    @JacksonXmlProperty(localName = "globalTransitionalSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "globalTransitionalSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer globalTransitionalSpeed;
    @JacksonXmlProperty(localName = "droneInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "droneInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlDroneInfo droneInfo;
    @JacksonXmlProperty(localName = "payloadInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlPayloadInfo payloadInfo;
    @JacksonXmlProperty(localName = "globalRTHHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "globalRTHHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer globalRTHHeight;
    @JacksonXmlProperty(localName = "autoRerouteInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "autoRerouteInfo", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlAutoRerouteInfo autoRerouteInfo;
    @JacksonXmlProperty(localName = "waylineAvoidLimitAreaMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waylineAvoidLimitAreaMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waylineAvoidLimitAreaMode;

    public static WpmlMissionConfig defaultInstance() {
        WpmlMissionConfig wpmlMissionConfig = new WpmlMissionConfig();
        wpmlMissionConfig.setFlyToWaylineMode("safely");
        wpmlMissionConfig.setFinishAction("goHome");
        wpmlMissionConfig.setExitOnRCLost("executeLostAction");
        wpmlMissionConfig.setExecuteRCLostAction("goBack");
        wpmlMissionConfig.setTakeOffSecurityHeight(50);
        wpmlMissionConfig.setGlobalTransitionalSpeed(10);
        wpmlMissionConfig.setDroneInfo(XmlDroneInfo.defaultInstance());
        wpmlMissionConfig.setPayloadInfo(XmlPayloadInfo.defaultInstance());
        wpmlMissionConfig.setGlobalRTHHeight(100);
        wpmlMissionConfig.setAutoRerouteInfo(XmlAutoRerouteInfo.defaultInstance());
        wpmlMissionConfig.setWaylineAvoidLimitAreaMode(0);
        return wpmlMissionConfig;
    }
}
