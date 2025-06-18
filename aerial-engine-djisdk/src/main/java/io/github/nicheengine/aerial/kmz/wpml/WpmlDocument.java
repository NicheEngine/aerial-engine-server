package io.github.nicheengine.aerial.kmz.wpml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "Document", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Document", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class WpmlDocument implements Serializable {
    @JacksonXmlProperty(localName = "Folder", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "Folder", namespace = KmzConstants.XMLNS_VALUE)
    protected WpmlFolder Folder;

    @JacksonXmlProperty(localName = "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected WpmlMissionConfig missionConfig;

    public static WpmlDocument defaultInstance() {
        WpmlDocument kmlDocument = new WpmlDocument();
        kmlDocument.setFolder(WpmlFolder.defaultInstance());
        kmlDocument.setMissionConfig(WpmlMissionConfig.defaultInstance());
        return kmlDocument;
    }
}
