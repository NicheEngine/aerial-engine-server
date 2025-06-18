package io.github.nicheengine.aerial.kmz.wpml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.action.XmlActionGroup;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "Folder", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Folder", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class WpmlFolder implements Serializable {
    @JacksonXmlProperty(localName = "templateId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "templateId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer templateId;
    @JacksonXmlProperty(localName = "waylineId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waylineId", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waylineId;
    @JacksonXmlProperty(localName = "autoFlightSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "autoFlightSpeed", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double autoFlightSpeed;
    @JacksonXmlProperty(localName = "executeHeightMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "executeHeightMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String executeHeightMode;

    @XmlElements(
            @XmlElement(name = "Placemark", namespace = KmzConstants.XMLNS_VALUE)
    )
    @JacksonXmlProperty(localName = "Placemark", namespace = KmzConstants.XMLNS_VALUE)
    @JacksonXmlElementWrapper(useWrapping = false)
    protected List<WpmlPlacemark> Placemark;

    @JacksonXmlProperty(localName = "startActionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "startActionGroup", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected XmlActionGroup startActionGroup;

    @JacksonXmlProperty(localName = "distance", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "distance", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double distance;

    @JacksonXmlProperty(localName = "duration", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "duration", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Double duration;


    public static WpmlFolder defaultInstance() {
        WpmlFolder wpmlFolder = new WpmlFolder();
        wpmlFolder.setTemplateId(0);
        wpmlFolder.setWaylineId(0);
        wpmlFolder.setAutoFlightSpeed(10.0d);
        wpmlFolder.setExecuteHeightMode("relativeToStartPoint");
        wpmlFolder.setPlacemark(new ArrayList<>());
        return wpmlFolder;
    }
}
