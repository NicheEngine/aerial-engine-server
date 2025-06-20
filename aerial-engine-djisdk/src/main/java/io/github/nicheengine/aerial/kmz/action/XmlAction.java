package io.github.nicheengine.aerial.kmz.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.serialize.XmlActionDeserializer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = XmlActionDeserializer.class)
@JacksonXmlRootElement(localName = "action", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "action", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlAction implements Serializable {
    @JacksonXmlProperty(localName = "actionId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer actionId;
    @JacksonXmlProperty(localName = "actionActuatorFunc", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionActuatorFunc", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String actionActuatorFunc;
    @JacksonXmlProperty(localName = "actionActuatorFuncParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElementRef(name = "actionActuatorFuncParam", type = XmlActionActuatorFuncParam.class, required = false, namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlActionActuatorFuncParam actionActuatorFuncParam;

    public XmlAction() {
    }


    public XmlAction(String actionActuatorFunc, XmlActionActuatorFuncParam actionActuatorFuncParam) {
        this.actionId = 0;
        this.actionActuatorFunc = actionActuatorFunc;
        this.actionActuatorFuncParam = actionActuatorFuncParam;
    }

    public static XmlAction defaultInstance() {
        XmlAction action = new XmlAction();
        action.setActionId(0);
        action.setActionActuatorFunc("gimbalRotate");
        return action;
    }

}
