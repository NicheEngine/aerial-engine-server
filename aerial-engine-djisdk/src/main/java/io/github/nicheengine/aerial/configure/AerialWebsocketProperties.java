package io.github.nicheengine.aerial.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <code>AerialWebsocketProperties</code>
 * <p>The aerial websocket properties class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.Getter
 * @see lombok.Setter
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 * @since Jdk1.8
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "nicheengine.aerial.websocket")
public class AerialWebsocketProperties {
    /**
     * <code>endpoints</code>
     * {@link java.lang.String} <p>The <code>endpoints</code> field.</p>
     * @see java.lang.String
     */
    private String[] endpoints;

    /**
     * <code>allowedOrigins</code>
     * {@link java.lang.String} <p>The <code>allowedOrigins</code> field.</p>
     * @see java.lang.String
     */
    private String[] allowedOrigins;

    /**
     * <code>allowedOriginPatterns</code>
     * {@link java.lang.String} <p>The <code>allowedOriginPatterns</code> field.</p>
     * @see java.lang.String
     */
    private String[] allowedOriginPatterns = new String[]{"*"};
}
