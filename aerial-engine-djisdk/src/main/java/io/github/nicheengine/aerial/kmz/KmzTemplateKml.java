package io.github.nicheengine.aerial.kmz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.kml.KmlDocument;
import io.github.nicheengine.aerial.kmz.kml.KmlFolder;
import io.github.nicheengine.aerial.kmz.kml.KmlPlacemark;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "kml", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "kml", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmzTemplateKml implements Serializable {
    @JacksonXmlProperty(localName = "Document", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "Document", namespace = KmzConstants.XMLNS_VALUE)
    protected KmlDocument Document;

    public KmzTemplateKml() {
    }

    public static KmzTemplateKml defaultInstance() {
        KmzTemplateKml kmlKml = new KmzTemplateKml();
        kmlKml.setDocument(KmlDocument.defaultInstance());
        return kmlKml;
    }

    public KmlPlacemark addPlacemark(KmlPlacemark placemark) {
        KmlFolder folder = this.getDocument().getFolder();
        if (GeneralUtils.isEmpty(folder.getPlacemark())) {
            folder.setPlacemark(new ArrayList<>());
        }
        List<KmlPlacemark> placemarks = folder.getPlacemark();
        placemarks.add(placemark);
        return placemark;
    }

}
