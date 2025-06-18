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
@JacksonXmlRootElement(localName =  "LineString", namespace = KmzConstants.XMLNS_VALUE)
@XmlRootElement(name = "LineString", namespace = KmzConstants.XMLNS_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlLineString implements Serializable {
    @JacksonXmlProperty(localName = "coordinates", namespace = KmzConstants.XMLNS_VALUE)
    @XmlElement(name = "coordinates", namespace = KmzConstants.XMLNS_VALUE)
    protected String coordinates;

    public final static KmlLineString defaultInstance = new KmlLineString();
}
