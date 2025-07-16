package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum MqttBroker implements RestKey<String> {

    BASIC("basic"),

    DRC("drc"),
    ;

    private final String broker;

    MqttBroker(String broker) {
        this.broker = broker;
    }

    @JsonValue
    @Override
    public String getKey() {
        return this.broker;
    }

    @JsonCreator
    public static MqttBroker parseKey(String key) {
        MqttBroker parsedKey = RestKey.parseKey(MqttBroker.class, key);
        return Optional.ofNullable(parsedKey).orElse(MqttBroker.BASIC);
    }
}
