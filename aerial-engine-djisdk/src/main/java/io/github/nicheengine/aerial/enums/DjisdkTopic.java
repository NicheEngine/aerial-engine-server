package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.mqtt.channel.DjisdkChannels;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

import static io.github.nicheengine.aerial.mqtt.MqttTopicConstants.*;

@Getter
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

    private final Pattern pattern;
    private final String beanName;

    DjisdkTopic(Pattern pattern, String beanName) {
        this.pattern = pattern;
        this.beanName = beanName;
    }

    @JsonValue
    @Override
    public Pattern getKey() {
        return this.pattern;
    }

    @Override
    public String getValue() {
        return this.beanName;
    }

    public static DjisdkTopic parseTopic(String key) {
        Optional<DjisdkTopic> parsedKey = Arrays.stream(DjisdkTopic.values())
                .filter(topic -> topic.pattern.matcher(key).matches()).findAny();
        return parsedKey.orElse(DjisdkTopic.UNKNOWN);
    }

    public static DjisdkTopic parseValue(String value) {
        DjisdkTopic parsedValue = RestValue.parseValue(DjisdkTopic.class, value);
        return RestOptional.ofNullable(parsedValue).orElse(DjisdkTopic.UNKNOWN);
    }
}
