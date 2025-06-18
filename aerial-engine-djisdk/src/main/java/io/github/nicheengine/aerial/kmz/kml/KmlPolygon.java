package io.github.nicheengine.aerial.kmz.kml;

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
@JacksonXmlRootElement(localName =  "Polygon", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "Polygon", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlPolygon implements Serializable {
    @JacksonXmlProperty(localName = "outerBoundaryIs", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "outerBoundaryIs", namespace = KmzConstants.XMLNS_VALUE)
    protected KmlOuterBoundaryIs outerBoundaryIs;

    public static KmlPolygon defaultInstance() {
        KmlPolygon kmlPolygon = new KmlPolygon();
        kmlPolygon.setOuterBoundaryIs(KmlOuterBoundaryIs.defaultInstance());
        return kmlPolygon;
    }
}
