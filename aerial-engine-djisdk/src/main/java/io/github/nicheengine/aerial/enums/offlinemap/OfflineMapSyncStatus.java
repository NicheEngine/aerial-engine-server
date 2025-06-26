package io.github.nicheengine.aerial.enums.offlinemap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum OfflineMapSyncStatus implements RestKey<String>{

    WAIT_SYNC("wait_sync"),

    SYNCHRONIZING("synchronizing"),

    SYNCHRONIZED("synchronized"),

    FAIL("fail"),

    SWITCH_FAIL("switch_fail"),

    UNKNOWN(""),

    ;
    private final String status;

    OfflineMapSyncStatus(String status) {
        this.status = status;
    }

    @JsonValue
    @Override
    public String getKey() {
        return status;
    }

    @JsonCreator
    public static OfflineMapSyncStatus parseKey(String key) {
        OfflineMapSyncStatus parsedKey = RestKey.parseKey(OfflineMapSyncStatus.class, key);
        return Optional.ofNullable(parsedKey).orElse(OfflineMapSyncStatus.UNKNOWN);
    }

}
