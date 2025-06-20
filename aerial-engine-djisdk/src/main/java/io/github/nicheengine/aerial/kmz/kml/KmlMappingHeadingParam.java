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

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "mappingHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "mappingHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlMappingHeadingParam implements Serializable {
    @JacksonXmlProperty(localName = "mappingHeadingMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "mappingHeadingMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String mappingHeadingMode;
    @JacksonXmlProperty(localName = "mappingHeadingAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "mappingHeadingAngle", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer mappingHeadingAngle;

    public static KmlMappingHeadingParam defaultInstance() {
        KmlMappingHeadingParam kmlMappingHeadingParam = new KmlMappingHeadingParam();
        kmlMappingHeadingParam.setMappingHeadingMode("followWayline");
        kmlMappingHeadingParam.setMappingHeadingAngle(0);
        return kmlMappingHeadingParam;
    }
}
