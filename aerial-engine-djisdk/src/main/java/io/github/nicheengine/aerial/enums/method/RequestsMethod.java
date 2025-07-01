package io.github.nicheengine.aerial.enums.method;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.model.config.RequestsConfigRequest;
import io.github.nicheengine.aerial.model.flightarea.FlightAreasGetRequest;
import io.github.nicheengine.aerial.model.media.StorageConfigGet;
import io.github.nicheengine.aerial.model.offlinemap.OfflineMapGetRequest;
import io.github.nicheengine.aerial.model.organization.AirportBindStatusRequest;
import io.github.nicheengine.aerial.model.organization.AirportOrganizationBindRequest;
import io.github.nicheengine.aerial.model.organization.AirportOrganizationGetRequest;
import io.github.nicheengine.aerial.model.wayline.FlighttaskResourceGetRequest;
import io.github.nicheengine.aerial.mqtt.MqttMethod;
import io.github.nicheengine.aerial.mqtt.channel.MqttChannels;
import io.github.nicheengine.aerial.mqtt.channel.RequestsChannels;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

public enum RequestsMethod implements MqttMethod {
    STORAGE_CONFIG_GET("storage_config_get", RequestsChannels.INBOUND_REQUESTS_STORAGE_CONFIG_GET, StorageConfigGet.class),

    AIRPORT_BIND_STATUS("airport_bind_status", RequestsChannels.INBOUND_REQUESTS_AIRPORT_BIND_STATUS, AirportBindStatusRequest.class),

    AIRPORT_ORGANIZATION_BIND("airport_organization_bind", RequestsChannels.INBOUND_REQUESTS_AIRPORT_ORGANIZATION_BIND, AirportOrganizationBindRequest.class),

    AIRPORT_ORGANIZATION_GET("airport_organization_get", RequestsChannels.INBOUND_REQUESTS_AIRPORT_ORGANIZATION_GET, AirportOrganizationGetRequest.class),

    FLIGHT_TASK_RESOURCE_GET("flighttask_resource_get", RequestsChannels.INBOUND_REQUESTS_FLIGHTTASK_RESOURCE_GET, FlighttaskResourceGetRequest.class),

    CONFIG("config", RequestsChannels.INBOUND_REQUESTS_CONFIG, RequestsConfigRequest.class),

    FLIGHT_AREAS_GET("flight_areas_get", RequestsChannels.INBOUND_REQUESTS_FLIGHT_AREAS_GET, FlightAreasGetRequest.class),

    OFFLINE_MAP_GET("offline_map_get", RequestsChannels.INBOUND_REQUESTS_OFFLINE_MAP_GET, OfflineMapGetRequest.class),

    UNKNOWN("", MqttChannels.DEFAULT, Object.class)
    ;

    @Getter
    private final String method;
    @Getter
    private final String channel;

    private final Class<?> type;

    RequestsMethod(String method, String channel, Class<?> type) {
        this.method = method;
        this.channel = channel;
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> getType() {
        return (Class<T>) this.type;
    }

    @Override
    @JsonValue
    public String getKey() {
        return this.method;
    }

    @JsonCreator
    public static RequestsMethod parseKey(String key) {
        RequestsMethod parsedKey = RestKey.parseKey(RequestsMethod.class, key);
        return Optional.ofNullable(parsedKey).orElse(RequestsMethod.UNKNOWN);
    }

    public static RequestsMethod parseValue(String value) {
        RequestsMethod parsedValue = RestValue.parseValue(RequestsMethod.class, value);
        return Optional.ofNullable(parsedValue).orElse(RequestsMethod.UNKNOWN);
    }


}
