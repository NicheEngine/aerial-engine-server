package io.github.nicheengine.aerial.enums.flightarea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FlightAreaSyncReason implements RestKey<Integer>{
    //TODO

    FLIGHT_AREA_SUCCESS(0, "success"),

    FLIGHT_AREA_PARSE_FILE_FAILED(1, "Failed to parse file information returned from the cloud."),

    FLIGHT_AREA_RETRIEVE_FILE_FAILED(2, "Failed to retrieve file information from the aircraft's end."),

    FLIGHT_AREA_DOWNLOAD_FILE_FAILED(3, "Failed to download the file from the cloud."),

    FLIGHT_AREA_LINK_FLIPPING_FAILED(4, "Link flipping failed."),

    FLIGHT_AREA_FILE_TRANSMISSION_FAILED(5, "File transmission failed."),

    FLIGHT_AREA_DISABLE_FAILED(6, "Filed to disable."),

    FLIGHT_AREA_FILE_DELETION_FAILED(7, "File deletion failed."),

    FLIGHT_AREA_FILE_LOADING_FAILED(8, "Failed to load file on drone."),

    FLIGHT_AREA_ENABLE_FAILED(9, "Filed to enable."),

    FLIGHT_AREA_TURN_OFF_ENHANCED_FAILED(10, "Failed to turn off enhanced image transmission."),

    FLIGHT_AREA_POWER_ON_FAILED(11, "Failed to power on the drone."),

    FLIGHT_AREA_CHECK_FAILED(12, "The checksum check failed."),

    FLIGHT_AREA_SYNCHRONIZATION_TIMED_OUT(13, "Synchronization exception timed out."),

    UNKNOWN(-1),

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
        return Optional.ofNullable(parsedKey).orElse(FlightAreaSyncReason.UNKNOWN);
    }

}
