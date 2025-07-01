package io.github.nicheengine.aerial.enums.flightarea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FlightAreaSyncReason implements RestKey<Integer>{

    FLIGHT_AREA_SYNC_SUCCESS(0),

    FLIGHT_AREA_SYNC_PARSE_FILE_FAILED(1),

    FLIGHT_AREA_SYNC_RETRIEVE_FILE_FAILED(2),

    FLIGHT_AREA_SYNC_DOWNLOAD_FILE_FAILED(3),

    FLIGHT_AREA_SYNC_LINK_FLIPPING_FAILED(4),

    FLIGHT_AREA_SYNC_FILE_TRANSMISSION_FAILED(5),

    FLIGHT_AREA_SYNC_DISABLE_FAILED(6),

    FLIGHT_AREA_SYNC_FILE_DELETION_FAILED(7),

    FLIGHT_AREA_SYNC_FILE_LOADING_FAILED(8),

    FLIGHT_AREA_SYNC_ENABLE_FAILED(9),

    FLIGHT_AREA_SYNC_TURN_OFF_ENHANCED_FAILED(10),

    FLIGHT_AREA_SYNC_POWER_ON_FAILED(11),

    FLIGHT_AREA_SYNC_CHECK_FAILED(12),

    FLIGHT_AREA_SYNC_SYNCHRONIZATION_TIMED_OUT(13),

    FLIGHT_AREA_SYNC_UNKNOWN(-1),

    ;
    private final Integer reason;

    FlightAreaSyncReason(Integer reason) {
        this.reason = reason;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return reason;
    }

    @JsonCreator
    public static FlightAreaSyncReason parseKey(Integer key) {
        FlightAreaSyncReason parsedKey = RestKey.parseKey(FlightAreaSyncReason.class, key);
        return Optional.ofNullable(parsedKey).orElse(FlightAreaSyncReason.FLIGHT_AREA_SYNC_UNKNOWN);
    }

}
