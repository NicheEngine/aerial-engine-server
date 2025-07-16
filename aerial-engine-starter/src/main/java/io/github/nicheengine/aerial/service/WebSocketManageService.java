package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.error.AerialWebSocketErrorException;
import io.github.nicheengine.aerial.websocket.WebSocketSessionDelegate;

import java.util.Collection;

public interface WebSocketManageService {

    void add(String key, WebSocketSessionDelegate value) throws AerialWebSocketErrorException;

    void delete(String key, String sessionId) throws AerialWebSocketErrorException;

    Collection<WebSocketSessionDelegate> get(String workspaceId) throws AerialWebSocketErrorException;

    Collection<WebSocketSessionDelegate> get(String workspaceId, Integer userScope) throws AerialWebSocketErrorException;

    Long size() throws AerialWebSocketErrorException;
}
