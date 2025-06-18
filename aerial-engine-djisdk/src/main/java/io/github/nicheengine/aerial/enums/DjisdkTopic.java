package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.RestValue;

import java.util.regex.Pattern;

import static io.github.nicheengine.aerial.mqtt.AerialTopicConstants.*;

public enum DjisdkTopic implements RestValue<Pattern, String> {

    STATUS(Pattern.compile("^" + BASIC_PRE + PRODUCT + REGEX_SN + STATUS_SUF + "$"), DjisdkChannels.INBOUND_STATUS),

    STATE(Pattern.compile("^" + THING_MODEL_PRE + PRODUCT + REGEX_SN + STATE_SUF + "$"), DjisdkChannels.INBOUND_STATE),

    SERVICE_REPLY(Pattern.compile("^" + THING_MODEL_PRE + PRODUCT + REGEX_SN + SERVICES_SUF + _REPLY_SUF + "$"), DjisdkChannels.INBOUND_SERVICES_REPLY),

    OSD(Pattern.compile("^" + THING_MODEL_PRE + PRODUCT + REGEX_SN + OSD_SUF + "$"), DjisdkChannels.INBOUND_OSD),

    REQUESTS(Pattern.compile("^" + THING_MODEL_PRE + PRODUCT + REGEX_SN + REQUESTS_SUF + "$"), DjisdkChannels.INBOUND_REQUESTS),

    EVENTS(Pattern.compile("^" + THING_MODEL_PRE + PRODUCT + REGEX_SN + EVENTS_SUF + "$"), DjisdkChannels.INBOUND_EVENTS),

    PROPERTY_SET_REPLY(Pattern.compile("^" + THING_MODEL_PRE + PRODUCT + REGEX_SN + PROPERTY_SUF + SET_SUF + _REPLY_SUF + "$"), DjisdkChannels.INBOUND_PROPERTY_SET_REPLY),

    DRC_UP(Pattern.compile("^" + THING_MODEL_PRE + PRODUCT + REGEX_SN + DRC + UP + "$"), DjisdkChannels.INBOUND_DRC_UP),

    UNKNOWN(Pattern.compile("^.*$"), MqttChannels.DEFAULT);

    private final Pattern key;
    private final String value;

    DjisdkTopic(Pattern key, String value) {
        this.key = key;
        this.value = value;
    }

    @JsonValue
    @Override
    public Pattern getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public Pattern getPattern() {
        return this.key;
    }

    public String getBeanName() {
        return this.value;
    }

    @JsonCreator
    public static DjisdkTopic parseKey(Pattern key) {
        DjisdkTopic parsedKey = RestKey.parseKey(DjisdkTopic.class, key);
        return RestOptional.ofNullable(parsedKey).orElse(DjisdkTopic.UNKNOWN);
    }

    public static DjisdkTopic parseValue(String value) {
        DjisdkTopic parsedValue = RestValue.parseValue(DjisdkTopic.class, value);
        return RestOptional.ofNullable(parsedValue).orElse(DjisdkTopic.UNKNOWN);
    }
}
