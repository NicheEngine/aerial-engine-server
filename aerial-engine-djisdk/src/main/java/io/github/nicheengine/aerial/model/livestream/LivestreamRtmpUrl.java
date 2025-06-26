package io.github.nicheengine.aerial.model.livestream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LivestreamRtmpUrl extends AerialDjisdkModel implements LivestreamUrl {
    @NotNull
    private String url;

    @Override
    public String toString() {
        return url;
    }

    @Override
    public LivestreamRtmpUrl clone() {
        try {
            return (LivestreamRtmpUrl) super.clone();
        } catch (CloneNotSupportedException e) {
            return LivestreamRtmpUrl.builder().url(url).build();
        }
    }
}
