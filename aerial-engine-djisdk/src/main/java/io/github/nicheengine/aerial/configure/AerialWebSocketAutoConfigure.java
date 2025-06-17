package io.github.nicheengine.aerial.configure;

import io.github.nichetoolkit.rest.RestOptional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;
import org.springframework.web.socket.server.HandshakeHandler;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * <code>AerialWebSocketAutoConfigure</code>
 * <p>The aerial web socket auto configure class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.boot.autoconfigure.AutoConfiguration
 * @see org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
 * @since Jdk1.8
 */
@Slf4j
@AutoConfiguration
@EnableWebSocketMessageBroker
public class AerialWebSocketAutoConfigure implements WebSocketMessageBrokerConfigurer {

    /**
     * <code>handshakeHandler</code>
     * {@link org.springframework.web.socket.server.HandshakeHandler} <p>The <code>handshakeHandler</code> field.</p>
     * @see org.springframework.web.socket.server.HandshakeHandler
     * @see javax.annotation.Resource
     */
    @Resource
    private HandshakeHandler handshakeHandler;

    /**
     * <code>decoratorFactory</code>
     * {@link org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory} <p>The <code>decoratorFactory</code> field.</p>
     * @see org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory
     * @see javax.annotation.Resource
     */
    @Resource
    private WebSocketHandlerDecoratorFactory decoratorFactory;

    /**
     * <code>websocketProperties</code>
     * {@link io.github.nicheengine.aerial.configure.AerialWebsocketProperties} <p>The <code>websocketProperties</code> field.</p>
     * @see io.github.nicheengine.aerial.configure.AerialWebsocketProperties
     * @see javax.annotation.Resource
     */
    @Resource
    private AerialWebsocketProperties websocketProperties;

    /**
     * <code>AerialWebSocketAutoConfigure</code>
     * <p>Instantiates a new aerial web socket auto configure.</p>
     */
    public AerialWebSocketAutoConfigure() {
        log.debug("The auto configuration for [aerial-webSocket] initiated");
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        StompWebSocketEndpointRegistration registration = registry.addEndpoint(this.websocketProperties.getEndpoints())
                .setHandshakeHandler(handshakeHandler);
        RestOptional.ofEmptyable(websocketProperties.getAllowedOrigins())
                .ifNotEmpty(registration::setAllowedOrigins);
        RestOptional.ofEmptyable(websocketProperties.getAllowedOriginPatterns())
                .ifNotEmpty(registration::setAllowedOriginPatterns);
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.addDecoratorFactory(decoratorFactory);
    }


}