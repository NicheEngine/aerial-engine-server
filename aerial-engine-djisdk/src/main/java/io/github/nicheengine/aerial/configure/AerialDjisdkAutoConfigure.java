package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.websocket.AerialWebSocketDefaultFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * <code>AerialDjisdkAutoConfigure</code>
 * <p>The aerial djisdk auto configure class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.boot.autoconfigure.AutoConfiguration
 * @see org.springframework.boot.context.properties.EnableConfigurationProperties
 * @see org.springframework.boot.autoconfigure.ImportAutoConfiguration
 * @since Jdk1.8
 */
@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(AerialLiveProperties.class)
@ImportAutoConfiguration(value = {AerialMqttAutoConfigure.class, AerialWebSocketAutoConfigure.class})
public class AerialDjisdkAutoConfigure {
    /**
     * <code>AerialDjisdkAutoConfigure</code>
     * <p>Instantiates a new aerial djisdk auto configure.</p>
     */
    public AerialDjisdkAutoConfigure() {
        log.debug("The auto configuration for [aerial-djisdk] initiated");
    }

    /**
     * <code>decoratorFactory</code>
     * <p>The decorator factory method.</p>
     * @return {@link org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory} <p>The decorator factory return object is <code>WebSocketHandlerDecoratorFactory</code> type.</p>
     * @see org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory
     * @see org.springframework.context.annotation.Bean
     * @see org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
     */
    @Bean
    @ConditionalOnMissingBean(WebSocketHandlerDecoratorFactory.class)
    public WebSocketHandlerDecoratorFactory decoratorFactory() {
        return new AerialWebSocketDefaultFactory();
    }
}
