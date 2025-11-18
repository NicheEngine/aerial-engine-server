package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.enums.livestream.VideoUrlType;
import io.github.nicheengine.aerial.model.livestream.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * <code>AerialLiveProperties</code>
 * <p>The aerial live properties class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.Getter
 * @see lombok.Setter
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 * @since Jdk1.8
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "nicheengine.aerial.live")
public class AerialLiveProperties {

    /**
     * <code>urlType</code>
     * {@link io.github.nicheengine.aerial.enums.livestream.VideoUrlType} <p>The <code>urlType</code> field.</p>
     * @see io.github.nicheengine.aerial.enums.livestream.VideoUrlType
     */
    private VideoUrlType urlType = VideoUrlType.AGORA;

    /**
     * <code>agora</code>
     * {@link io.github.nicheengine.aerial.configure.AerialLiveProperties.Agora} <p>The <code>agora</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialLiveProperties.Agora
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Agora agora = new Agora();
    /**
     * <code>gb28181</code>
     * {@link io.github.nicheengine.aerial.configure.AerialLiveProperties.Gb28181} <p>The <code>gb28181</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialLiveProperties.Gb28181
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Gb28181 gb28181 = new Gb28181();
    /**
     * <code>rtmp</code>
     * {@link io.github.nicheengine.aerial.configure.AerialLiveProperties.Rtmp} <p>The <code>rtmp</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialLiveProperties.Rtmp
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Rtmp rtmp = new Rtmp();
    /**
     * <code>rtsp</code>
     * {@link io.github.nicheengine.aerial.configure.AerialLiveProperties.Rtsp} <p>The <code>rtsp</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialLiveProperties.Rtsp
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Rtsp rtsp = new Rtsp();
    /**
     * <code>whip</code>
     * {@link io.github.nicheengine.aerial.configure.AerialLiveProperties.Whip} <p>The <code>whip</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialLiveProperties.Whip
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Whip whip = new Whip();

    /**
     * <code>Agora</code>
     * <p>The agora class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Agora {
        /**
         * <code>sn</code>
         * {@link java.lang.String} <p>The <code>sn</code> field.</p>
         * @see java.lang.String
         */
        private String sn;
        /**
         * <code>channel</code>
         * {@link java.lang.String} <p>The <code>channel</code> field.</p>
         * @see java.lang.String
         */
        private String channel;
        /**
         * <code>token</code>
         * {@link java.lang.String} <p>The <code>token</code> field.</p>
         * @see java.lang.String
         */
        private String token;
        /**
         * <code>uid</code>
         * {@link java.lang.Integer} <p>The <code>uid</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer uid;

        /**
         * <code>toUrl</code>
         * <p>The to url method.</p>
         * @return {@link io.github.nicheengine.aerial.model.livestream.LivestreamUrl} <p>The to url return object is <code>LivestreamUrl</code> type.</p>
         * @see io.github.nicheengine.aerial.model.livestream.LivestreamUrl
         */
        public LivestreamUrl toUrl() {
           return LivestreamAgoraUrl.builder()
                    .sn(sn).channel(channel)
                    .token(token).uid(uid).build();
        }
    }

    /**
     * <code>Gb28181</code>
     * <p>The gb 28181 class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Gb28181 {
        /**
         * <code>serverIp</code>
         * {@link java.lang.String} <p>The <code>serverIp</code> field.</p>
         * @see java.lang.String
         */
        private String serverIp;
        /**
         * <code>serverPort</code>
         * {@link java.lang.Integer} <p>The <code>serverPort</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer serverPort;
        /**
         * <code>serverId</code>
         * {@link java.lang.String} <p>The <code>serverId</code> field.</p>
         * @see java.lang.String
         */
        private String serverId;
        /**
         * <code>serverPassword</code>
         * {@link java.lang.String} <p>The <code>serverPassword</code> field.</p>
         * @see java.lang.String
         */
        private String serverPassword;
        /**
         * <code>localId</code>
         * {@link java.lang.String} <p>The <code>localId</code> field.</p>
         * @see java.lang.String
         */
        private String localId;
        /**
         * <code>localPort</code>
         * {@link java.lang.Integer} <p>The <code>localPort</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer localPort;
        /**
         * <code>channel</code>
         * {@link java.lang.String} <p>The <code>channel</code> field.</p>
         * @see java.lang.String
         */
        private String channel;
        /**
         * <code>authUsername</code>
         * {@link java.lang.String} <p>The <code>authUsername</code> field.</p>
         * @see java.lang.String
         */
        private String authUsername;
        /**
         * <code>authPassword</code>
         * {@link java.lang.String} <p>The <code>authPassword</code> field.</p>
         * @see java.lang.String
         */
        private String authPassword;

        /**
         * <code>toUrl</code>
         * <p>The to url method.</p>
         * @return {@link io.github.nicheengine.aerial.model.livestream.LivestreamUrl} <p>The to url return object is <code>LivestreamUrl</code> type.</p>
         * @see io.github.nicheengine.aerial.model.livestream.LivestreamUrl
         */
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

    /**
     * <code>Rtmp</code>
     * <p>The rtmp class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Rtmp {
        /**
         * <code>url</code>
         * {@link java.lang.String} <p>The <code>url</code> field.</p>
         * @see java.lang.String
         */
        private String url;

        /**
         * <code>toUrl</code>
         * <p>The to url method.</p>
         * @return {@link io.github.nicheengine.aerial.model.livestream.LivestreamUrl} <p>The to url return object is <code>LivestreamUrl</code> type.</p>
         * @see io.github.nicheengine.aerial.model.livestream.LivestreamUrl
         */
        public LivestreamUrl toUrl() {
            return LivestreamRtmpUrl.builder().url(url).build();
        }
    }


    /**
     * <code>Rtsp</code>
     * <p>The rtsp class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Rtsp {
        /**
         * <code>port</code>
         * {@link java.lang.Integer} <p>The <code>port</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer port;
        /**
         * <code>username</code>
         * {@link java.lang.String} <p>The <code>username</code> field.</p>
         * @see java.lang.String
         */
        private String username;
        /**
         * <code>password</code>
         * {@link java.lang.String} <p>The <code>password</code> field.</p>
         * @see java.lang.String
         */
        private String password;

        /**
         * <code>toUrl</code>
         * <p>The to url method.</p>
         * @return {@link io.github.nicheengine.aerial.model.livestream.LivestreamUrl} <p>The to url return object is <code>LivestreamUrl</code> type.</p>
         * @see io.github.nicheengine.aerial.model.livestream.LivestreamUrl
         */
        public LivestreamUrl toUrl() {
            return LivestreamRtspUrl.builder().username(username).password(password).port(port).build();
        }
    }


    /**
     * <code>Whip</code>
     * <p>The whip class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Whip {
        /**
         * <code>url</code>
         * {@link java.lang.String} <p>The <code>url</code> field.</p>
         * @see java.lang.String
         */
        private String url;

        /**
         * <code>secret</code>
         * {@link java.lang.String} <p>The <code>secret</code> field.</p>
         * @see java.lang.String
         */
        private String secret;

        /**
         * <code>toUrl</code>
         * <p>The to url method.</p>
         * @return {@link io.github.nicheengine.aerial.model.livestream.LivestreamUrl} <p>The to url return object is <code>LivestreamUrl</code> type.</p>
         * @see io.github.nicheengine.aerial.model.livestream.LivestreamUrl
         */
        public LivestreamUrl toUrl() {
            return LivestreamWhipUrl.builder().url(url).secret(secret).build();
        }
    }
}
