package io.github.nicheengine.aerial.kmz.kml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.wpml.WpmlMissionConfig;
import io.github.nichetoolkit.rest.util.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "missionConfig", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = true)
public class KmlMissionConfig extends WpmlMissionConfig {
    @JacksonXmlProperty(localName = "takeOffRefPoint", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "takeOffRefPoint", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected String takeOffRefPoint;
    @JacksonXmlProperty(localName = "takeOffRefPointAGLHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "takeOffRefPointAGLHeight", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer takeOffRefPointAGLHeight;

    public static KmlMissionConfig defaultInstance() {
        KmlMissionConfig kmlMissionConfig = new KmlMissionConfig();
        WpmlMissionConfig wpmlMissionConfig = WpmlMissionConfig.defaultInstance();
        BeanUtils.copyNonnullProperties(wpmlMissionConfig, kmlMissionConfig);
        kmlMissionConfig.setTakeOffRefPoint("0.00,0.00,0");
        kmlMissionConfig.setTakeOffRefPointAGLHeight(0);
        return kmlMissionConfig;
    }
}
