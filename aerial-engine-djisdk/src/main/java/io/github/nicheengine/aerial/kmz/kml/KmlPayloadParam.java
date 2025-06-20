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
@JacksonXmlRootElement(localName =  "payloadParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "payloadParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
public class KmlPayloadParam implements Serializable {
    @JacksonXmlProperty(localName = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "payloadPositionIndex", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer payloadPositionIndex;
    @JacksonXmlProperty(localName = "focusMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "focusMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String focusMode;
    @JacksonXmlProperty(localName = "meteringMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "meteringMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String meteringMode;
    @JacksonXmlProperty(localName = "dewarpingEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "dewarpingEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer dewarpingEnable;
    @JacksonXmlProperty(localName = "returnMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "returnMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String returnMode;
    @JacksonXmlProperty(localName = "samplingRate", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "samplingRate", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer samplingRate;
    @JacksonXmlProperty(localName = "scanningMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "scanningMode", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String scanningMode;
    @JacksonXmlProperty(localName = "modelColoringEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "modelColoringEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer modelColoringEnable;

    public static KmlPayloadParam defaultInstance() {
        KmlPayloadParam kmlPayloadParam = new KmlPayloadParam();
        kmlPayloadParam.setPayloadPositionIndex(0);
        kmlPayloadParam.setFocusMode("firstPoint");
        kmlPayloadParam.setMeteringMode("average");
        kmlPayloadParam.setReturnMode("singleReturnFirst");
        kmlPayloadParam.setSamplingRate(240000);
        kmlPayloadParam.setScanningMode("repetitive");
        return kmlPayloadParam;
    }
}
