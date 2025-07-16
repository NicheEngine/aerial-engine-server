package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.constant.I18nConstants;
import io.github.nicheengine.aerial.enums.WebsocketMethod;
import io.github.nicheengine.aerial.error.AerialWebSocketErrorException;
import io.github.nicheengine.aerial.service.WebSocketManageService;
import io.github.nicheengine.aerial.service.WebSocketMessageService;
import io.github.nicheengine.aerial.websocket.AerialWebSocketMessageResponse;
import io.github.nicheengine.aerial.websocket.WebSocketSessionDelegate;
import io.github.nichetoolkit.rest.error.lack.ConfigureLackError;
import io.github.nichetoolkit.rest.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.ServiceConfigurationError;

@Slf4j
@Service
public class WebSocketMessageServiceImpl implements WebSocketMessageService {

    private final WebSocketManageService manageService;

    public WebSocketMessageServiceImpl(WebSocketManageService manageService) {
        this.manageService = manageService;
    }

    private void sendOfSession(WebSocketSessionDelegate session, TextMessage message) {
        try {
            if (!session.isOpen()) {
                session.close();
                log.debug("It is failed during message send, the session has closed.");
            } else {
                session.sendMessage(message);
            }
        } catch (IOException exception) {
            log.error("It is failed during message send, error: {}", exception.getMessage());
            GeneralUtils.printStackTrace(exception);
        }
    }

    @Override
    public void send(WebSocketSessionDelegate session, AerialWebSocketMessageResponse<?> message) throws AerialWebSocketErrorException {
        if (GeneralUtils.isEmpty(session)) {
            return;
        }
        TextMessage textMessage = new TextMessage(JsonUtils.parseJsonAsBytes(message));
        sendOfSession(session, textMessage);
    }

    @Override
    public void send(Collection<WebSocketSessionDelegate> sessions, AerialWebSocketMessageResponse<?> message) throws AerialWebSocketErrorException {
        if (GeneralUtils.isEmpty(sessions)) {
            return;
        }
        TextMessage textMessage = new TextMessage(JsonUtils.parseJsonAsBytes(message));
        for (WebSocketSessionDelegate session : sessions) {
            sendOfSession(session, textMessage);
        }
    }

    @Override
    public void send(String workspaceId, Integer userScope, WebsocketMethod method, Object data) throws AerialWebSocketErrorException {
        OptionalUtils.ofNull(workspaceId, I18nUtils.message(I18nConstants.WORKSPACE_ID_NULL), AerialWebSocketErrorException::new);
        Collection<WebSocketSessionDelegate> sessions = GeneralUtils.isEmpty(userScope) ?
                manageService.get(workspaceId) : manageService.get(workspaceId, userScope);
        this.send(sessions, AerialWebSocketMessageResponse.builder()
                .data(GeneralUtils.isNotEmpty(data) ? data : "")
                .timestamp(System.currentTimeMillis())
                .method(method).build());
    }

    @Override
    public void send(String workspaceId, WebsocketMethod method, Object data) throws AerialWebSocketErrorException {
        this.send(workspaceId, null, method, data);
    }
}
