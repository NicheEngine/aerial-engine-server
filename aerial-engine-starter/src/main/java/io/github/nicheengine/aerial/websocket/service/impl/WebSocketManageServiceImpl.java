package io.github.nicheengine.aerial.websocket.service.impl;

import io.github.nicheengine.aerial.constant.RedisConstants;
import io.github.nicheengine.aerial.enums.UserScope;
import io.github.nicheengine.aerial.error.AerialWebSocketErrorException;
import io.github.nicheengine.aerial.manager.RedisManager;
import io.github.nicheengine.aerial.websocket.service.WebSocketManageService;
import io.github.nicheengine.aerial.websocket.WebSocketSessionDelegate;
import io.github.nichetoolkit.rest.error.lack.FieldLackError;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WebSocketManageServiceImpl implements WebSocketManageService {

    private static final ConcurrentHashMap<String, WebSocketSessionDelegate> SESSIONS_CACHE = new ConcurrentHashMap<>(16);

    private void optionalKey(String...names) {
        OptionalUtils.ofFalse(names.length == 3,() -> new FieldLackError("The key is out of format. [{workspaceId}/{userScope}/{userId}]"));
    }

    @Override
    public void add(String key, WebSocketSessionDelegate value) throws AerialWebSocketErrorException {
        String[] keys = key.split("/");
        optionalKey(keys);
        String sessionId = value.getId();
        String workspaceKey = RedisConstants.WEBSOCKET_PREFIX + keys[0];
        String userScopeKey = RedisConstants.WEBSOCKET_PREFIX + UserScope.parseKey(Integer.parseInt(keys[1])).getValue();
        RedisManager.setOfHash(workspaceKey, sessionId, keys[2]);
        RedisManager.setOfHash(userScopeKey, sessionId, keys[2]);
        SESSIONS_CACHE.put(sessionId, value);
        RedisManager.expire(workspaceKey, RedisConstants.WEBSOCKET_ALIVE_SECOND);
        RedisManager.expire(userScopeKey, RedisConstants.WEBSOCKET_ALIVE_SECOND);
    }

    @Override
    public void delete(String key, String sessionId) throws AerialWebSocketErrorException {
        String[] keys = key.split("/");
        optionalKey(keys);
        RedisManager.deleteOfHash(RedisConstants.WEBSOCKET_PREFIX + keys[0], new String[] {sessionId});
        RedisManager.deleteOfHash(RedisConstants.WEBSOCKET_PREFIX + UserScope.parseKey(Integer.parseInt(keys[1])).getValue(), new String[] {sessionId});
        SESSIONS_CACHE.remove(sessionId);
    }

    @Override
    public Collection<WebSocketSessionDelegate> get(String workspaceId) throws AerialWebSocketErrorException {
        if (GeneralUtils.isEmpty(workspaceId)) {
            return Collections.emptyList();
        }
        String key = RedisConstants.WEBSOCKET_PREFIX + workspaceId;
        return RedisManager.keysOfHash(key)
                .stream()
                .map(SESSIONS_CACHE::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<WebSocketSessionDelegate> get(String workspaceId, Integer userScope) throws AerialWebSocketErrorException {
        String key = RedisConstants.WEBSOCKET_PREFIX + UserScope.parseKey(userScope).getValue();
        return RedisManager.keysOfHash(key)
                .stream()
                .map(SESSIONS_CACHE::get)
                .filter(get(workspaceId)::contains)
                .collect(Collectors.toSet());
    }

    @Override
    public Long size() throws AerialWebSocketErrorException {
        return SESSIONS_CACHE.mappingCount();
    }
}
