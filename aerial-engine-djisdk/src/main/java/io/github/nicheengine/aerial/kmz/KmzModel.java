package io.github.nicheengine.aerial.kmz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.File;
import java.io.Serializable;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class KmzModel implements Serializable {
    public static final String TEMPLATE_NAME = "template";
    public static final String WAYLINE_NAME = "wayline";
    public static final String TEMPLATE_SUFFIX = ".kml";
    public static final String WAYLINE_SUFFIX = ".wpml";

    @JsonIgnore
    protected File templateFile;
    @JsonIgnore
    protected File waylineFile;

    protected KmzTemplateKml template;
    protected KmzWaylineKml wayline;

    protected String templateXml;
    protected String waylineXml;
}
