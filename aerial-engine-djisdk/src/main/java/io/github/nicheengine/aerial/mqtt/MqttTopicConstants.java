package io.github.nicheengine.aerial.mqtt;

public interface MqttTopicConstants {
    String BASIC_PRE = "sys/";

    String THING_MODEL_PRE = "thing/";

    String PRODUCT = "product/";

    String STATUS_SUF = "/status";

    String _REPLY_SUF = "_reply";

    String OSD_SUF = "/osd";

    String STATE_SUF = "/state";

    String SERVICES_SUF = "/services";

    String REQUESTS_SUF = "/requests";

    String EVENTS_SUF = "/events";

    String PROPERTY_SUF = "/property";

    String SET_SUF = "/set";

    String REGEX_SN = "[A-Za-z0-9]+";

    String DRC = "/drc";

    String UP = "/up";

    String DOWN = "/down";
}
