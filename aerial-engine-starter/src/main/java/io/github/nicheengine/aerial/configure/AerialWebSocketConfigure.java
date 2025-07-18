package io.github.nicheengine.aerial.configure;

import io.github.nicheengine.aerial.websocket.service.WebSocketManageService;
import io.github.nicheengine.aerial.websocket.AerialWebSocketDefaultFactory;
import io.github.nicheengine.aerial.websocket.WebSocketMessageHandler;
import io.github.nicheengine.aerial.websocket.WebSocketPrincipalHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.HandshakeHandler;

@Slf4j
@AutoConfiguration
@AutoConfigureBefore(AerialWebSocketAutoConfigure.class)
public class AerialWebSocketConfigure implements WebSocketMessageBrokerConfigurer {

    public AerialWebSocketConfigure() {
        log.debug("The auto configuration for [web-socket] initiated");
    }

    @Bean
    @ConditionalOnMissingBean(HandshakeHandler.class)
    public HandshakeHandler principalHandler() {
        return new WebSocketPrincipalHandler();
    }

    @Bean
    @Primary
    public AerialWebSocketDefaultFactory webSocketDefaultFactory(WebSocketManageService manageService) {
        return new AerialWebSocketDefaultFactory() {

            @NonNull
            @Override
            public WebSocketHandler decorate(@NonNull WebSocketHandler handler) {
                return new WebSocketMessageHandler(handler, manageService);
            }
        };
    }

}