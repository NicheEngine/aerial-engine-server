package io.github.nicheengine.aerial.kmz.kml;

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
import java.util.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "Document", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Document", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlDocument implements Serializable {
    @JacksonXmlProperty(localName = "Folder", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "Folder", namespace = KmzConstants.XMLNS_VALUE)
    protected KmlFolder Folder;
    @JacksonXmlProperty(localName = "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected KmlMissionConfig missionConfig;
    @JacksonXmlProperty(localName = "author", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "author", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String author;
    @JacksonXmlProperty(localName = "createTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "createTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Long createTime;
    @JacksonXmlProperty(localName = "updateTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "updateTime", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Long updateTime;

    public KmlDocument() {
    }

    public static KmlDocument defaultInstance() {
        KmlDocument kmlDocument = new KmlDocument();
        kmlDocument.setFolder(KmlFolder.defaultInstance());
        kmlDocument.setMissionConfig(KmlMissionConfig.defaultInstance());
        kmlDocument.setAuthor("jrsoft");
        kmlDocument.setCreateTime(new Date().getTime());
        kmlDocument.setUpdateTime(new Date().getTime());
        return kmlDocument;
    }
}
