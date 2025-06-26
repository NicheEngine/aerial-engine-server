package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.enums.livestream.VideoUrlType;
import io.github.nicheengine.aerial.model.livestream.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "nicheengine.aerial.live")
public class AerialLiveProperties {

    private VideoUrlType urlType = VideoUrlType.AGORA;

    @NestedConfigurationProperty
    private Agora agora = new Agora();
    @NestedConfigurationProperty
    private Gb28181 gb28181 = new Gb28181();
    @NestedConfigurationProperty
    private Rtmp rtmp = new Rtmp();
    @NestedConfigurationProperty
    private Rtsp rtsp = new Rtsp();
    @NestedConfigurationProperty
    private Whip whip = new Whip();

    @Getter
    @Setter
    public static class Agora {
        private String sn;
        private String channel;
        private String token;
        private Integer uid;

        public LivestreamUrl toUrl() {
           return LivestreamAgoraUrl.builder()
                    .sn(sn).channel(channel)
                    .token(token).uid(uid).build();
        }
    }

    @Getter
    @Setter
    public static class Gb28181 {
        private String serverIp;
        private Integer serverPort;
        private String serverId;
        private String serverPassword;
        private String localId;
        private Integer localPort;
        private String channel;
        private String authUsername;
        private String authPassword;

        public LivestreamUrl toUrl() {
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

    @Getter
    @Setter
    public static class Rtmp {
        private String url;

        public LivestreamUrl toUrl() {
            return LivestreamRtmpUrl.builder().url(url).build();
        }
    }


    @Getter
    @Setter
    public static class Rtsp {
        private Integer port;
        private String username;
        private String password;

        public LivestreamUrl toUrl() {
            return LivestreamRtspUrl.builder().username(username).password(password).port(port).build();
        }
    }


    @Getter
    @Setter
    public static class Whip {
        private String url;

        public LivestreamUrl toUrl() {
            return LivestreamWhipUrl.builder().url(url).build();
        }
    }
}
