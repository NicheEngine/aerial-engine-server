package io.github.nicheengine.aerial.kmz.wpml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nicheengine.aerial.kmz.xml.XmlWaypointHeadingParam;
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
@JacksonXmlRootElement(localName =  "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "waypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = true)
public class WpmlWaypointHeadingParam extends XmlWaypointHeadingParam {
    @JacksonXmlProperty(localName = "waypointHeadingAngleEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    @XmlElement(name = "waypointHeadingAngleEnable", namespace = KmzConstants.XMLNS_WPML_VALUE)
    protected Integer waypointHeadingAngleEnable;

    public static WpmlWaypointHeadingParam defaultInstance() {
        WpmlWaypointHeadingParam wpmlWaypointHeadingParam = new WpmlWaypointHeadingParam();
        XmlWaypointHeadingParam xmlWaypointHeadingParam = XmlWaypointHeadingParam.defaultInstance();
        BeanUtils.copyNonnullProperties(xmlWaypointHeadingParam, wpmlWaypointHeadingParam);
        wpmlWaypointHeadingParam.setWaypointHeadingAngleEnable(0);
        return wpmlWaypointHeadingParam;
    }
}
