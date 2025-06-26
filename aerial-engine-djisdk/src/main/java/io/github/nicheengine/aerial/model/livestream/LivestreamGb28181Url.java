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
public class LivestreamGb28181Url extends AerialDjisdkModel implements LivestreamUrl {
    private String serverIp;
    private Integer serverPort;
    private String serverId;
    private String serverPassword;
    private String localId;
    private Integer localPort;
    private String channel;
    private String authUsername;
    private String authPassword;

    @Override
    public String toString() {
        return "serverIp=" + serverIp +
                "&serverPort=" + serverPort +
                "&serverId=" + serverId +
                "&serverPassword=" + serverPassword +
                "&localId=" + localId +
                "&localPort=" + localPort +
                "&channel=" + channel;
    }

    @Override
    public LivestreamGb28181Url clone() {
        try {
            return (LivestreamGb28181Url) super.clone();
        } catch (CloneNotSupportedException e) {
            return LivestreamGb28181Url.builder()
                    .serverIp(serverIp)
                    .serverPort(serverPort)
                    .serverId(serverId)
                    .serverPassword(serverPassword)
                    .localId(localId)
                    .localPort(localPort)
                    .channel(channel)
                    .authUsername(authUsername)
                    .authUsername(authPassword)
                    .build();
        }
    }
}
