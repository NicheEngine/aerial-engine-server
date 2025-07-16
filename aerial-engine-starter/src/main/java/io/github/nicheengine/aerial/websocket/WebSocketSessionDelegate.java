package io.github.nicheengine.aerial.websocket;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;

public class WebSocketSessionDelegate extends ConcurrentWebSocketSessionDecorator {
    private static final int SEND_BUFFER_SIZE_LIMIT = 1024 * 1024;

    private static final int SEND_TIME_LIMIT = 1000;

    private WebSocketSessionDelegate(WebSocketSession delegate, int sendTimeLimit, int bufferSizeLimit) {
        super(delegate, sendTimeLimit, bufferSizeLimit);
    }

    WebSocketSessionDelegate(WebSocketSession delegate) {
        this(delegate, SEND_TIME_LIMIT, SEND_BUFFER_SIZE_LIMIT);
    }

}
