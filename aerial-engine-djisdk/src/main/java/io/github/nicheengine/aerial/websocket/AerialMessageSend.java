package io.github.nicheengine.aerial.websocket;


import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.AerialWebSocketErrorException;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.helper.CloseableHelper;
import io.github.nichetoolkit.rest.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.Collection;

@Slf4j
public class AerialMessageSend {

    public void sendMessage(AerialWebSocketSession webSocketSession, AerialMessageResponse<?> message) throws RestException {
        RestOptional.ofNullable(webSocketSession).isNotNull(session -> {
            if (session.isOpen()) {
                byte[] bytes = JsonUtils.parseJsonAsBytes(message);
                try {
                    session.sendMessage(new TextMessage(bytes));
                } catch (IOException exception) {
                    throw new AerialWebSocketErrorException(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, exception.getMessage());
                }
            } else {
                CloseableHelper.close(session);
                log.debug("The web socket session is closed.");
            }
        });
    }

    public void sendBatch(Collection<AerialWebSocketSession> webSocketSessions, AerialMessageResponse<?> message) throws RestException {
        RestOptional.ofEmptyable(webSocketSessions).isNotEmpty(sessions -> {
            byte[] bytes = JsonUtils.parseJsonAsBytes(message);
            TextMessage textMessage = new TextMessage(bytes);
            for (AerialWebSocketSession session : sessions) {
                if (session.isOpen()) {
                    try {
                        session.sendMessage(textMessage);
                    } catch (IOException exception) {
                        throw new AerialWebSocketErrorException(AerialErrorStatus.AERIAL_WEBSOCKET_ERROR, exception.getMessage());
                    }
                } else {
                    CloseableHelper.close(session);
                    log.debug("The web socket session of batch is closed.");
                }
            }
        });
    }
}