package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.enums.MqttBroker;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.error.lack.ConfigureLackError;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.mqtt.support.MqttMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Slf4j
@AutoConfiguration
@IntegrationComponentScan
public class AerialMqttAutoConfigure {

    private final AerialMqttProperties mqttProperties;

    @Resource(name = MqttChannels.INBOUND)
    private MessageChannel inboundChannel;

    @Autowired
    public AerialMqttAutoConfigure(AerialMqttProperties mqttProperties) {
        log.debug("The auto configuration for [aerial-mqtt] initiated");
        this.mqttProperties = mqttProperties;
    }

    @Bean
    @ConditionalOnMissingBean(MqttConnectOptions.class)
    public MqttConnectOptions mqttConnectOptions() {
        AerialMqttProperties.BrokerClient brokerClient = this.mqttProperties.brokerClient(MqttBroker.BASIC);
        String mqttAddress = this.mqttProperties.mqttAddress(MqttBroker.BASIC,
                (client) -> GeneralUtils.isNotEmpty(client.getLocal()) ? client.getLocal() : client.getHost());
        MqttConnectOptions connectOptions = new MqttConnectOptions();
        connectOptions.setServerURIs(new String[]{ mqttAddress });
        connectOptions.setUserName(brokerClient.getUsername());
        connectOptions.setPassword(GeneralUtils.isNotEmpty(brokerClient.getPassword()) ?
                brokerClient.getPassword().toCharArray() : new char[0]);
        connectOptions.setAutomaticReconnect(this.mqttProperties.getAutomaticReconnect());
        connectOptions.setKeepAliveInterval(this.mqttProperties.getKeepaliveInterval());
        return connectOptions;
    }

    @Bean
    @ConditionalOnMissingBean(MqttPahoClientFactory.class)
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptions());
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean(MqttMessageConverter.class)
    public MqttMessageConverter messageConverter() {
        AerialMqttProperties.Message message = this.mqttProperties.getMessage();
        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter(message.getDefaultQos(), message.getDefaultRetained(), message.getCharset().getKey());
        converter.setPayloadAsBytes(message.getPayloadAsBytes());
        return converter;
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter channelAdapter(MqttMessageConverter converter, MqttPahoClientFactory  mqttClientFactory) {
        AerialMqttProperties.Inbound inbound = this.mqttProperties.getInbound();
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                inbound.getClientId(), mqttClientFactory, this.mqttProperties.getTopics());
        adapter.setConverter(converter);
        adapter.setQos(inbound.getQos());
        adapter.setManualAcks(inbound.getManualAcks());
        adapter.setCompletionTimeout(inbound.getTimeout());
        adapter.setDisconnectCompletionTimeout(inbound.getDisconnectTimeout());
        adapter.setRecoveryInterval(inbound.getRecoveryInterval());
        adapter.setOutputChannel(inboundChannel);
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = MqttChannels.OUTBOUND)
    public MessageHandler outboundHandler(MqttMessageConverter converter, MqttPahoClientFactory  mqttClientFactory) {
        AerialMqttProperties.Outbound outbound = this.mqttProperties.getOutbound();
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(outbound.getClientId(), mqttClientFactory);
        messageHandler.setAsync(outbound.getAsync());
        messageHandler.setAsyncEvents(outbound.getAsyncEvents());
        messageHandler.setDefaultQos(outbound.getDefaultQos());
        messageHandler.setCompletionTimeout(outbound.getTimeout());
        messageHandler.setDisconnectCompletionTimeout(outbound.getDisconnectTimeout());
        messageHandler.setDefaultRetained(outbound.getDefaultRetained());
        RestOptional.ofEmptyable(outbound.getQosExpression()).ifNotEmpty(messageHandler::setQosExpressionString);
        RestOptional.ofEmptyable(outbound.getRetainedExpression()).ifNotEmpty(messageHandler::setRetainedExpressionString);
        messageHandler.setConverter(converter);
        return messageHandler;
    }

    @Bean
    @ServiceActivator(inputChannel = MqttChannels.DEFAULT)
    public MessageHandler defaultHandler() {
        return message -> log.info("The default channel does not handle messages.\nTopic: {}\nPayload: {}\n", message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC), message.getPayload());
    }


}