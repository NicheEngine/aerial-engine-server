package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.enums.MqttBroker;
import io.github.nicheengine.aerial.enums.MqttProtocol;
import io.github.nicheengine.aerial.model.control.DrcMqttBroker;
import io.github.nichetoolkit.rest.error.lack.ConfigureLackError;
import io.github.nichetoolkit.rest.type.CharsetType;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

/**
 * <code>AerialMqttProperties</code>
 * <p>The aerial mqtt properties class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.Getter
 * @see lombok.Setter
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 * @since Jdk1.8
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "nicheengine.aerial.mqtt")
public class AerialMqttProperties {
    /**
     * <code>topics</code>
     * {@link java.lang.String} <p>The <code>topics</code> field.</p>
     * @see java.lang.String
     */
    private String[] topics;
    /**
     * <code>brokers</code>
     * {@link java.util.Map} <p>The <code>brokers</code> field.</p>
     * @see java.util.Map
     */
    private Map<MqttBroker, BrokerClient> brokers = new HashMap<>();
    /**
     * <code>automaticReconnect</code>
     * {@link java.lang.Boolean} <p>The <code>automaticReconnect</code> field.</p>
     * @see java.lang.Boolean
     */
    private Boolean automaticReconnect = true;
    /**
     * <code>keepaliveInterval</code>
     * {@link java.lang.Integer} <p>The <code>keepaliveInterval</code> field.</p>
     * @see java.lang.Integer
     */
    private Integer keepaliveInterval = 10;
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
     * <code>BrokerClient</code>
     * <p>The broker client class.</p>
     * @author Cyan (snow22314@outlook.com)
     * @see lombok.Getter
     * @see lombok.Setter
     * @since Jdk1.8
     */
    @Getter
    @Setter
    public static class BrokerClient {
        /**
         * <code>protocol</code>
         * {@link io.github.nicheengine.aerial.enums.MqttProtocol} <p>The <code>protocol</code> field.</p>
         * @see io.github.nicheengine.aerial.enums.MqttProtocol
         */
        private MqttProtocol protocol;
        /**
         * <code>host</code>
         * {@link java.lang.String} <p>The <code>host</code> field.</p>
         * @see java.lang.String
         */
        private String host;
        /**
         * <code>local</code>
         * {@link java.lang.String} <p>The <code>local</code> field.</p>
         * @see java.lang.String
         */
        private String local;
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
         * <code>clientId</code>
         * {@link java.lang.String} <p>The <code>clientId</code> field.</p>
         * @see java.lang.String
         */
        private String clientId;
        /**
         * <code>path</code>
         * {@link java.lang.String} <p>The <code>path</code> field.</p>
         * @see java.lang.String
         */
        private String path;
        /**
         * <code>topic</code>
         * {@link java.lang.String} <p>The <code>topic</code> field.</p>
         * @see java.lang.String
         */
        private String topic;
    }

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

    /**
     * <code>brokerClient</code>
     * <p>The broker client method.</p>
     * @param brokerType {@link io.github.nicheengine.aerial.enums.MqttBroker} <p>The broker type parameter is <code>MqttBroker</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.configure.AerialMqttProperties.BrokerClient} <p>The broker client return object is <code>BrokerClient</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.MqttBroker
     * @see io.github.nicheengine.aerial.configure.AerialMqttProperties.BrokerClient
     */
    public BrokerClient brokerClient(MqttBroker brokerType) {
        BrokerClient brokerClient = this.brokers.get(brokerType);
        OptionalUtils.ofNullError(brokerClient, () -> new ConfigureLackError("Please configure the [" + brokerType.getBroker() + "] mqtt connection parameters first, otherwise application cannot be started."));
        return brokerClient;
    }

    /**
     * <code>mqttAddress</code>
     * <p>The mqtt address method.</p>
     * @param brokerType {@link io.github.nicheengine.aerial.enums.MqttBroker} <p>The broker type parameter is <code>MqttBroker</code> type.</p>
     * @param function   {@link java.util.function.Function} <p>The function parameter is <code>Function</code> type.</p>
     * @return {@link java.lang.String} <p>The mqtt address return object is <code>String</code> type.</p>
     * @see io.github.nicheengine.aerial.enums.MqttBroker
     * @see java.util.function.Function
     * @see java.lang.String
     */
    public String mqttAddress(MqttBroker brokerType, Function<BrokerClient, String> function) {
        BrokerClient brokerClient = brokerClient(brokerType);
        MqttProtocol protocol = brokerClient.getProtocol();
        StringBuilder address = new StringBuilder()
                .append(protocol)
                .append("://")
                .append(function.apply(brokerClient).trim())
                .append(":")
                .append(brokerClient.getPort());
        if ((protocol == MqttProtocol.WS || protocol == MqttProtocol.WSS) && GeneralUtils.isNotEmpty(brokerClient.getPath())) {
            address.append(brokerClient.getPath());
        }
        return address.toString();
    }

    /**
     * <code>drcBroker</code>
     * <p>The drc broker method.</p>
     * @param clientId {@link java.lang.String} <p>The client id parameter is <code>String</code> type.</p>
     * @param offset   {@link java.lang.Long} <p>The offset parameter is <code>Long</code> type.</p>
     * @return {@link io.github.nicheengine.aerial.model.control.DrcMqttBroker} <p>The drc broker return object is <code>DrcMqttBroker</code> type.</p>
     * @see java.lang.String
     * @see java.lang.Long
     * @see io.github.nicheengine.aerial.model.control.DrcMqttBroker
     */
    public DrcMqttBroker drcBroker(String clientId, Long offset) {
        BrokerClient brokerClient = brokerClient(MqttBroker.DRC);
        String mqttAddress = mqttAddress(MqttBroker.DRC,
                (client) -> GeneralUtils.isNotEmpty(client.getHost()) ? client.getHost() : client.getLocal());
        return DrcMqttBroker.builder()
                .address(mqttAddress)
                .username(brokerClient.getUsername())
                .clientId(clientId)
                .expireTime(System.currentTimeMillis() / 1000 + offset)
                .password(brokerClient.getPassword())
                .enableTls(false)
                .build();
    }
}
