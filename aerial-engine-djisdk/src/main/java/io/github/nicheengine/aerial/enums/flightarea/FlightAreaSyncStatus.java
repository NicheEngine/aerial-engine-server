package io.github.nicheengine.aerial.enums.flightarea;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum FlightAreaSyncStatus implements RestKey<String> {

    WAIT_SYNC("wait_sync", false),

    SWITCH_FAIL("switch_fail", false),

    SYNCHRONIZING("synchronizing", false),

    SYNCHRONIZED("synchronized", true),

    FAIL("fail", true),

    UNKNOWN("", true),
    ;

    private final String status;

    private final boolean end;

    FlightAreaSyncStatus(String status, boolean end) {
        this.status = status;
        this.end = end;
    }

    @Override
    public String getKey() {
        return this.status;
    }

    @JsonCreator
    public static FlightAreaSyncStatus parseKey(String key) {
        FlightAreaSyncStatus parsedKey = RestKey.parseKey(FlightAreaSyncStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(FlightAreaSyncStatus.UNKNOWN);
    }
}
