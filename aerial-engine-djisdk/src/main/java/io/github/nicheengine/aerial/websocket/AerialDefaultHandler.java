package io.github.nicheengine.aerial.websocket;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

@Slf4j
public class AerialDefaultHandler extends WebSocketHandlerDecorator {

    public AerialDefaultHandler(WebSocketHandler delegate) {
        super(delegate);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.debug("{} is connected.", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,@NonNull CloseStatus closeStatus) throws Exception {
        log.debug("{} is disconnected.", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("received message: {}, from: {}", message.getPayload(), session.getId());
    }

}