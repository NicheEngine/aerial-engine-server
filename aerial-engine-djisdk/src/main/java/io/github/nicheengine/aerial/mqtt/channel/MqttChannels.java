package io.github.nicheengine.aerial.mqtt.channel;

/**
 * <code>MqttChannels</code>
 * <p>The mqtt channels interface.</p>
 * @author Cyan (snow22314@outlook.com)
 * @since Jdk1.8
 */
public interface MqttChannels {
    /**
     * <code>DEFAULT</code>
     * {@link java.lang.String} <p>The constant <code>DEFAULT</code> field.</p>
     * @see java.lang.String
     */
    String DEFAULT = "default";

    /**
     * <code>INBOUND</code>
     * {@link java.lang.String} <p>The constant <code>INBOUND</code> field.</p>
     * @see java.lang.String
     */
    String INBOUND = "inbound";

    /**
     * <code>OUTBOUND</code>
     * {@link java.lang.String} <p>The constant <code>OUTBOUND</code> field.</p>
     * @see java.lang.String
     */
    String OUTBOUND = "outbound";
}
