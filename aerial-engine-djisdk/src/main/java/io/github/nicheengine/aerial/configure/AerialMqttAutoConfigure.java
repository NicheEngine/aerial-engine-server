package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nichetoolkit.rest.RestOptional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.mqtt.support.MqttMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import javax.annotation.Resource;

/**
 * <code>AerialMqttAutoConfigure</code>
 * <p>The aerial mqtt auto configure class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.boot.autoconfigure.AutoConfiguration
 * @see org.springframework.integration.annotation.IntegrationComponentScan
 * @since Jdk1.8
 */
@Slf4j
@AutoConfiguration
@IntegrationComponentScan
public class AerialMqttAutoConfigure {

    /**
     * <code>mqttProperties</code>
     * {@link io.github.nicheengine.aerial.configure.AerialMqttProperties} <p>The <code>mqttProperties</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialMqttProperties
     */
    private final AerialMqttProperties mqttProperties;

    /**
     * <code>mqttClientFactory</code>
     * {@link org.springframework.integration.mqtt.core.MqttPahoClientFactory} <p>The <code>mqttClientFactory</code> field.</p>
     * @see org.springframework.integration.mqtt.core.MqttPahoClientFactory
     * @see javax.annotation.Resource
     */
    @Resource
    private MqttPahoClientFactory mqttClientFactory;

    /**
     * <code>inboundChannel</code>
     * {@link org.springframework.messaging.MessageChannel} <p>The <code>inboundChannel</code> field.</p>
     * @see org.springframework.messaging.MessageChannel
     * @see javax.annotation.Resource
     */
    @Resource(name = MqttChannels.INBOUND)
    private MessageChannel inboundChannel;

    /**
     * <code>AerialMqttAutoConfigure</code>
     * <p>Instantiates a new aerial mqtt auto configure.</p>
     * @param mqttProperties {@link io.github.nicheengine.aerial.configure.AerialMqttProperties} <p>The mqtt properties parameter is <code>AerialMqttProperties</code> type.</p>
     * @see io.github.nicheengine.aerial.configure.AerialMqttProperties
     * @see org.springframework.beans.factory.annotation.Autowired
     */
    @Autowired
    public AerialMqttAutoConfigure(AerialMqttProperties mqttProperties) {
        log.debug("The auto configuration for [aerial-mqtt] initiated");
        this.mqttProperties = mqttProperties;
    }

    /**
     * <code>messageConverter</code>
     * <p>The message converter method.</p>
     * @return {@link org.springframework.integration.mqtt.support.MqttMessageConverter} <p>The message converter return object is <code>MqttMessageConverter</code> type.</p>
     * @see org.springframework.integration.mqtt.support.MqttMessageConverter
     * @see org.springframework.context.annotation.Bean
     * @see org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
     */
    @Bean
    @ConditionalOnMissingBean(MqttMessageConverter.class)
    public MqttMessageConverter messageConverter() {
        AerialMqttProperties.Message message = this.mqttProperties.getMessage();
        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter(message.getDefaultQos(), message.getDefaultRetained(), message.getCharset().getKey());
        converter.setPayloadAsBytes(message.getPayloadAsBytes());
        return converter;
    }

    /**
     * <code>channelAdapter</code>
     * <p>The channel adapter method.</p>
     * @param converter {@link org.springframework.integration.mqtt.support.MqttMessageConverter} <p>The converter parameter is <code>MqttMessageConverter</code> type.</p>
     * @return {@link org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter} <p>The channel adapter return object is <code>MqttPahoMessageDrivenChannelAdapter</code> type.</p>
     * @see org.springframework.integration.mqtt.support.MqttMessageConverter
     * @see org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter
     * @see org.springframework.context.annotation.Bean
     */
    @Bean
    public MqttPahoMessageDrivenChannelAdapter channelAdapter(MqttMessageConverter converter) {
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

    /**
     * <code>outboundHandler</code>
     * <p>The outbound handler method.</p>
     * @param converter {@link org.springframework.integration.mqtt.support.MqttMessageConverter} <p>The converter parameter is <code>MqttMessageConverter</code> type.</p>
     * @return {@link org.springframework.messaging.MessageHandler} <p>The outbound handler return object is <code>MessageHandler</code> type.</p>
     * @see org.springframework.integration.mqtt.support.MqttMessageConverter
     * @see org.springframework.messaging.MessageHandler
     * @see org.springframework.context.annotation.Bean
     * @see org.springframework.integration.annotation.ServiceActivator
     * @see io.github.nichetoolkit.rest.RestException
     */
    @Bean
    @ServiceActivator(inputChannel = MqttChannels.OUTBOUND)
    public MessageHandler outboundHandler(MqttMessageConverter converter) {
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

    /**
     * <code>defaultHandler</code>
     * <p>The default handler method.</p>
     * @return {@link org.springframework.messaging.MessageHandler} <p>The default handler return object is <code>MessageHandler</code> type.</p>
     * @see org.springframework.messaging.MessageHandler
     * @see org.springframework.context.annotation.Bean
     * @see org.springframework.integration.annotation.ServiceActivator
     */
    @Bean
    @ServiceActivator(inputChannel = MqttChannels.DEFAULT)
    public MessageHandler defaultHandler() {
        return message -> log.info("The default channel does not handle messages.\nTopic: {}\nPayload: {}\n", message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC), message.getPayload());
    }


}