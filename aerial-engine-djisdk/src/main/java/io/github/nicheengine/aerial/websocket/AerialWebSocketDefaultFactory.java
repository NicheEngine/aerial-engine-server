package io.github.nicheengine.aerial.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

@Slf4j
public class AerialWebSocketDefaultFactory implements WebSocketHandlerDecoratorFactory {

    public AerialWebSocketDefaultFactory() {}

    @NonNull
    @Override
    public WebSocketHandler decorate(@NonNull WebSocketHandler handler) {
        return new AerialWebSocketDefaultHandler(handler);
    }

}