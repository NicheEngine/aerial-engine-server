package io.github.nicheengine.aerial.model.livestream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nichetoolkit.rest.error.lack.MethodLackError;
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
public class LivestreamAgoraUrl extends AerialDjisdkModel implements LivestreamUrl {
    @NotNull
    private String channel;
    @NotNull
    private String sn;
    @NotNull
    private String token;
    @NotNull
    private Integer uid;

    @Override
    public String toString() {
        String token = this.token;
        try {
            token = URLEncoder.encode(token, Charset.defaultCharset().toString());
        } catch (UnsupportedEncodingException ignored) {
        }
        return "channel=" + channel + "&sn=" + sn + "&token=" + token + "&uid=" + uid;
    }

    @Override
    public LivestreamAgoraUrl clone() {
        try {
            return (LivestreamAgoraUrl) super.clone();
        } catch (CloneNotSupportedException e) {
            return LivestreamAgoraUrl.builder().sn(sn).token(token).channel(channel).uid(uid).build();
        }
    }
}
