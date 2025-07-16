package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MqttProtocol implements RestKey<String> {

    TCP("tcp"),

    SSL("ssl"),

    WS("ws"),

    WSS("wss");
    ;

    private final String protocol;

    MqttProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.protocol;
    }

    @JsonCreator
    public static MqttProtocol parseKey(String key) {
        MqttProtocol parsedKey = RestKey.parseKey(MqttProtocol.class, key);
        return Optional.ofNullable(parsedKey).orElse(MqttProtocol.TCP);
    }
}
