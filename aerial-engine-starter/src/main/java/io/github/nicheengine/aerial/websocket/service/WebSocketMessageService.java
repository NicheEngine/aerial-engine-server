package io.github.nicheengine.aerial.websocket.service;

import io.github.nicheengine.aerial.enums.WebsocketMethod;
import io.github.nicheengine.aerial.error.AerialWebSocketErrorException;
import io.github.nicheengine.aerial.websocket.AerialWebSocketMessageResponse;
import io.github.nicheengine.aerial.websocket.WebSocketSessionDelegate;

import java.util.Collection;

public interface WebSocketMessageService {

    void send(WebSocketSessionDelegate session, AerialWebSocketMessageResponse<?> message) throws AerialWebSocketErrorException;

    void send(Collection<WebSocketSessionDelegate> sessions, AerialWebSocketMessageResponse<?> message) throws AerialWebSocketErrorException;

    void send(String workspaceId, Integer userType, WebsocketMethod method, Object data) throws AerialWebSocketErrorException;

    void send(String workspaceId, WebsocketMethod method, Object data) throws AerialWebSocketErrorException;
}
