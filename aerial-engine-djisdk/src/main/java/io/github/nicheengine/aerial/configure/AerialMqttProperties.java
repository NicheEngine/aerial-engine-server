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
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "nicheengine.aerial.mqtt")
public class AerialMqttProperties {
    private String[] topics;
    private Map<MqttBroker, BrokerClient> brokers = new HashMap<>();
    private Boolean automaticReconnect = true;
    private Integer keepaliveInterval = 10;
    @NestedConfigurationProperty
    private Message message = new Message();
    @NestedConfigurationProperty
    private Inbound inbound = new Inbound();
    @NestedConfigurationProperty
    private Outbound outbound = new Outbound();

    @Getter
    @Setter
    public static class BrokerClient {
        private MqttProtocol protocol;
        private String host;
        private String local;
        private Integer port;
        private String username;
        private String password;
        private String clientId;
        private String path;
        private String topic;
    }

    @Getter
    @Setter
    public static class Message {
        private Integer defaultQos = 0;
        private Boolean defaultRetained = false;
        private Boolean payloadAsBytes = true;
        private CharsetType charset = CharsetType.UTF_8;
    }

    @Getter
    @Setter
    public static class Inbound {
        private Integer[] qos = new Integer[]{1};
        private Boolean defaultRetained = false;
        private Boolean manualAcks = false;
        private Long timeout = 30000L;
        private Long disconnectTimeout = 5000L;
        private String clientId = UUID.randomUUID().toString();
        private Integer recoveryInterval = 10000;

        public int[] getQos() {
            if (GeneralUtils.isEmpty(this.qos)) {
                return new int[0];
            }
            return Arrays.stream(this.qos).mapToInt(Integer::valueOf).toArray();
        }
    }

    @Getter
    @Setter
    public static class Outbound {
        private Integer defaultQos = 0;
        private Boolean async = false;
        private Boolean asyncEvents = false;
        private String clientId = UUID.randomUUID().toString();
        private Long timeout = 30000L;
        private Long disconnectTimeout = 5000L;
        private String qosExpression;
        private Boolean defaultRetained = false;
        private String retainedExpression;

    }

    public BrokerClient brokerClient(MqttBroker brokerType) {
        BrokerClient brokerClient = this.brokers.get(brokerType);
        OptionalUtils.ofNullError(brokerClient, () -> new ConfigureLackError("Please configure the [" + brokerType.getBroker() + "] mqtt connection parameters first, otherwise application cannot be started."));
        return brokerClient;
    }

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
