package io.github.nicheengine.aerial.kmz.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.nicheengine.aerial.kmz.KmzConstants;
import io.github.nichetoolkit.rest.util.BeanUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName =  "globalWaypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlRootElement(name = "globalWaypointHeadingParam", namespace = KmzConstants.XMLNS_WPML_VALUE)
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(callSuper = true)
public class XmlGlobalWaypointHeadingParam extends XmlWaypointHeadingParam {

    public static XmlGlobalWaypointHeadingParam defaultInstance() {
        XmlGlobalWaypointHeadingParam xmlGlobalWaypointHeadingParam = new XmlGlobalWaypointHeadingParam();
        XmlWaypointHeadingParam xmlWaypointHeadingParam = XmlWaypointHeadingParam.defaultInstance();
        BeanUtils.copyNonnullProperties(xmlWaypointHeadingParam, xmlGlobalWaypointHeadingParam);
        return xmlGlobalWaypointHeadingParam;
    }

    ;
}
