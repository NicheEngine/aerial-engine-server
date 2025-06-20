package io.github.nicheengine.aerial.kmz.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
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
@JacksonXmlRootElement(localName =  "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "actionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlActionTrigger implements Serializable {
    @JacksonXmlProperty(localName = "actionTriggerType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionTriggerType", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String actionTriggerType;
    @JacksonXmlProperty(localName = "actionTriggerParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionTriggerParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer actionTriggerParam;

    public static XmlActionTrigger defaultInstance() {
        XmlActionTrigger xmlActionTrigger = new XmlActionTrigger();
        xmlActionTrigger.setActionTriggerType("reachPoint");
        return xmlActionTrigger;
    }
}
