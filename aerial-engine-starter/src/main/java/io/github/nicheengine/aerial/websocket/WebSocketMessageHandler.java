package io.github.nicheengine.aerial.websocket;

import io.github.nicheengine.aerial.websocket.service.WebSocketManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketHandler;

@Slf4j
public class WebSocketMessageHandler extends AerialWebSocketDefaultHandler {

    private final WebSocketManageService manageService;

    public WebSocketMessageHandler(WebSocketHandler delegate, WebSocketManageService manageService) {
        super(delegate);
        this.manageService = manageService;
    }
}
