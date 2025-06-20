package io.github.nicheengine.aerial.kmz.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.serialize.XmlActionListDeserializer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "actionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "actionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlActionGroup implements Serializable {
    @JacksonXmlProperty(localName = "actionGroupId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionGroupId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer actionGroupId;
    @JacksonXmlProperty(localName = "actionGroupStartIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionGroupStartIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer actionGroupStartIndex;
    @JacksonXmlProperty(localName = "actionGroupEndIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionGroupEndIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer actionGroupEndIndex;
    @JacksonXmlProperty(localName = "actionGroupMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionGroupMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String actionGroupMode;
    @JacksonXmlProperty(localName = "actionTrigger", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "actionTrigger", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlActionTrigger actionTrigger;
    @XmlElements(
            @XmlElement(name = "action", namespace = KmzConstants.XMLNS_WPML_VALUE)
    )
    @JacksonXmlProperty(localName = "action", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @JsonDeserialize(using = XmlActionListDeserializer.class)
    protected List<XmlAction> action;

    public static XmlActionGroup defaultInstance() {
        XmlActionGroup actionGroup = new XmlActionGroup();
        actionGroup.setActionGroupId(0);
        actionGroup.setActionGroupStartIndex(0);
        actionGroup.setActionGroupEndIndex(0);
        actionGroup.setActionGroupMode("sequence");
        actionGroup.setActionTrigger(XmlActionTrigger.defaultInstance());
        actionGroup.setAction(new ArrayList<>());
        return actionGroup;
    }


}
