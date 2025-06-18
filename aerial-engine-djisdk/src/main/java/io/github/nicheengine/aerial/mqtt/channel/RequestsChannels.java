package io.github.nicheengine.aerial.mqtt.channel;

public interface RequestsChannels {
    String INBOUND_REQUESTS_STORAGE_CONFIG_GET = "inboundRequestsStorageConfigGet";

    String INBOUND_REQUESTS_AIRPORT_BIND_STATUS = "inboundRequestsAirportBindStatus";

    String INBOUND_REQUESTS_AIRPORT_ORGANIZATION_GET = "inboundRequestsAirportOrganizationGet";

    String INBOUND_REQUESTS_AIRPORT_ORGANIZATION_BIND = "inboundRequestsAirportOrganizationBind";

    String INBOUND_REQUESTS_CONFIG = "inboundRequestsConfig";

    String INBOUND_REQUESTS_FLIGHTTASK_RESOURCE_GET = "inboundRequestsFlightTaskResourceGet";

    String INBOUND_REQUESTS_FLIGHT_AREAS_GET = "inboundRequestsFlightAreasGet";

    String INBOUND_REQUESTS_OFFLINE_MAP_GET = "inboundRequestsOfflineMapGet";

}
