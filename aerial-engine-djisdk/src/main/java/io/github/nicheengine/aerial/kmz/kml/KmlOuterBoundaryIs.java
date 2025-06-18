package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.xml.XmlLinearRing;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "outerBoundaryIs", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "outerBoundaryIs", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlOuterBoundaryIs implements Serializable {
    @JacksonXmlProperty(localName = "LinearRing", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "LinearRing", namespace = KmzConstants.XMLNS_VALUE)
    protected XmlLinearRing LinearRing;

    public static KmlOuterBoundaryIs defaultInstance() {
        KmlOuterBoundaryIs kmlOuterBoundaryIs = new KmlOuterBoundaryIs();
        kmlOuterBoundaryIs.setLinearRing(XmlLinearRing.defaultInstance);
        return kmlOuterBoundaryIs;
    }
}
