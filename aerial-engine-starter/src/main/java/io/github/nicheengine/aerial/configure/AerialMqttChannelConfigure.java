package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.messaging.MessageChannel;

import java.util.concurrent.Executor;

@Slf4j
@AutoConfiguration
@ComponentScan(basePackages = {"io.github.nicheengine.aerial"})
public class AerialMqttChannelConfigure {

    private final Executor threadPool;

    public AerialMqttChannelConfigure(Executor threadPool) {
        log.debug("The auto configuration for [mqtt-channel] initiated");
        this.threadPool = threadPool;
    }

    @Bean(name = MqttChannels.INBOUND)
    public MessageChannel inboundChannel() {
        return new ExecutorChannel(threadPool);
    }

    @Bean(name = MqttChannels.DEFAULT)
    public MessageChannel defaultChannel() {
        return new DirectChannel();
    }

    @Bean(name = DjisdkChannels.INBOUND_STATUS)
    public MessageChannel statusChannel() {
        return new DirectChannel();
    }

    @Bean(name = DjisdkChannels.INBOUND_STATE)
    public MessageChannel stateChannel() {
        return new DirectChannel();
    }

    @Bean(name = DjisdkChannels.INBOUND_SERVICES_REPLY)
    public MessageChannel serviceReplyChannel() {
        return new DirectChannel();
    }

    @Bean(name = DjisdkChannels.INBOUND_OSD)
    public MessageChannel osdChannel() {
        return new ExecutorChannel(threadPool);
    }

    @Bean(name = DjisdkChannels.INBOUND_REQUESTS)
    public MessageChannel requestsChannel() {
        return new DirectChannel();
    }

    @Bean(name = DjisdkChannels.INBOUND_EVENTS)
    public MessageChannel eventsChannel() {
        return new DirectChannel();
    }

    @Bean(name = DjisdkChannels.INBOUND_PROPERTY_SET_REPLY)
    public MessageChannel propertySetReplyChannel() {
        return new DirectChannel();
    }

    @Bean(name = DjisdkChannels.INBOUND_DRC_UP)
    public MessageChannel drcUpChannel() {
        return new DirectChannel();
    }
}
