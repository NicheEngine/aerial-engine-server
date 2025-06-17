package io.github.nicheengine.aerial.configure;

import io.github.nichetoolkit.rest.type.CharsetType;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

/**
 * <code>AerialMqttProperties</code>
 * <p>The aerial mqtt properties class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.Getter
 * @see lombok.Setter
 * @see org.springframework.stereotype.Component
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 * @since Jdk1.8
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "nicheengine.aerial.mqtt")
public class AerialMqttProperties {
    /**
     * <code>topics</code>
     * {@link java.lang.String} <p>The <code>topics</code> field.</p>
     * @see java.lang.String
     */
    private String[] topics;

    /**
     * <code>message</code>
     * {@link io.github.nicheengine.aerial.configure.AerialMqttProperties.Message} <p>The <code>message</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialMqttProperties.Message
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Message message = new Message();
    /**
     * <code>inbound</code>
     * {@link io.github.nicheengine.aerial.configure.AerialMqttProperties.Inbound} <p>The <code>inbound</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialMqttProperties.Inbound
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Inbound inbound = new Inbound();
    /**
     * <code>outbound</code>
     * {@link io.github.nicheengine.aerial.configure.AerialMqttProperties.Outbound} <p>The <code>outbound</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialMqttProperties.Outbound
     * @see org.springframework.boot.context.properties.NestedConfigurationProperty
     */
    @NestedConfigurationProperty
    private Outbound outbound = new Outbound();

    /**
     * <code>Message</code>
     * <p>The message class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Message {
        /**
         * <code>defaultQos</code>
         * {@link java.lang.Integer} <p>The <code>defaultQos</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer defaultQos = 0;
        /**
         * <code>defaultRetained</code>
         * {@link java.lang.Boolean} <p>The <code>defaultRetained</code> field.</p>
         * @see java.lang.Boolean
         */
        private Boolean defaultRetained = false;
        /**
         * <code>payloadAsBytes</code>
         * {@link java.lang.Boolean} <p>The <code>payloadAsBytes</code> field.</p>
         * @see java.lang.Boolean
         */
        private Boolean payloadAsBytes = true;
        /**
         * <code>charset</code>
         * {@link io.github.nichetoolkit.rest.type.CharsetType} <p>The <code>charset</code> field.</p>
         * @see io.github.nichetoolkit.rest.type.CharsetType
         */
        private CharsetType charset = CharsetType.UTF_8;
    }

    /**
     * <code>Inbound</code>
     * <p>The inbound class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Inbound {
        /**
         * <code>qos</code>
         * {@link java.lang.Integer} <p>The <code>qos</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer[] qos = new Integer[]{1};
        /**
         * <code>defaultRetained</code>
         * {@link java.lang.Boolean} <p>The <code>defaultRetained</code> field.</p>
         * @see java.lang.Boolean
         */
        private Boolean defaultRetained = false;
        /**
         * <code>manualAcks</code>
         * {@link java.lang.Boolean} <p>The <code>manualAcks</code> field.</p>
         * @see java.lang.Boolean
         */
        private Boolean manualAcks = false;
        /**
         * <code>timeout</code>
         * {@link java.lang.Long} <p>The <code>timeout</code> field.</p>
         * @see java.lang.Long
         */
        private Long timeout = 30000L;
        /**
         * <code>disconnectTimeout</code>
         * {@link java.lang.Long} <p>The <code>disconnectTimeout</code> field.</p>
         * @see java.lang.Long
         */
        private Long disconnectTimeout = 5000L;
        /**
         * <code>clientId</code>
         * {@link java.lang.String} <p>The <code>clientId</code> field.</p>
         * @see java.lang.String
         */
        private String clientId = UUID.randomUUID().toString();
        /**
         * <code>recoveryInterval</code>
         * {@link java.lang.Integer} <p>The <code>recoveryInterval</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer recoveryInterval = 10000;

        /**
         * <code>getQos</code>
         * <p>The get qos method.</p>
         * @return int <p>The get qos return object is <code>int</code> type.</p>
         */
        public int[] getQos() {
            if (GeneralUtils.isEmpty(this.qos)) {
                return new int[0];
            }
            return Arrays.stream(this.qos).mapToInt(Integer::valueOf).toArray();
        }
    }

    /**
     * <code>Outbound</code>
     * <p>The outbound class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class Outbound {
        /**
         * <code>defaultQos</code>
         * {@link java.lang.Integer} <p>The <code>defaultQos</code> field.</p>
         * @see java.lang.Integer
         */
        private Integer defaultQos = 0;
        /**
         * <code>async</code>
         * {@link java.lang.Boolean} <p>The <code>async</code> field.</p>
         * @see java.lang.Boolean
         */
        private Boolean async = false;
        /**
         * <code>asyncEvents</code>
         * {@link java.lang.Boolean} <p>The <code>asyncEvents</code> field.</p>
         * @see java.lang.Boolean
         */
        private Boolean asyncEvents = false;
        /**
         * <code>clientId</code>
         * {@link java.lang.String} <p>The <code>clientId</code> field.</p>
         * @see java.lang.String
         */
        private String clientId = UUID.randomUUID().toString();
        /**
         * <code>timeout</code>
         * {@link java.lang.Long} <p>The <code>timeout</code> field.</p>
         * @see java.lang.Long
         */
        private Long timeout = 30000L;
        /**
         * <code>disconnectTimeout</code>
         * {@link java.lang.Long} <p>The <code>disconnectTimeout</code> field.</p>
         * @see java.lang.Long
         */
        private Long disconnectTimeout = 5000L;
        /**
         * <code>qosExpression</code>
         * {@link java.lang.String} <p>The <code>qosExpression</code> field.</p>
         * @see java.lang.String
         */
        private String qosExpression;
        /**
         * <code>defaultRetained</code>
         * {@link java.lang.Boolean} <p>The <code>defaultRetained</code> field.</p>
         * @see java.lang.Boolean
         */
        private Boolean defaultRetained = false;
        /**
         * <code>retainedExpression</code>
         * {@link java.lang.String} <p>The <code>retainedExpression</code> field.</p>
         * @see java.lang.String
         */
        private String retainedExpression;

    }
}
