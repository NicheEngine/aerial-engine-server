package io.github.nicheengine.aerial.enums.offlinemap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum OfflineMapSyncReason implements RestKey<Integer>{
    //TODO

    OFFLINE_MAP_SYNC_SUCCESS(0, "success"),

    OFFLINE_MAP_SYNC_PARSE_FILE_FAILED(1, "Failed to parse the file information returned by the cloud."),

    OFFLINE_MAP_SYNC_OBTAIN_DRONE_FILE_FAILED(2, "Failed to obtain aircraft file information."),

    OFFLINE_MAP_SYNC_DOWNLOAD_FILE_FAILED(3, "Failed to download file from cloud."),

    OFFLINE_MAP_SYNC_LINK_ROLLOVER_FAILED(4, "Failed to rollover the link."),

    OFFLINE_MAP_SYNC_FILE_TRANSFER_FAILED(5, "Failed to transfer file."),

    OFFLINE_MAP_SYNC_DISABLE_OFFLINE_MAP_FAILED(6, "Failed to disable offline map."),

    OFFLINE_MAP_SYNC_DELETE_FILE_FAILED(7, "Failed to delete file."),

    OFFLINE_MAP_SYNC_LOAD_FILE_FAILED(8, "Failed to load the file on the device side."),

    OFFLINE_MAP_SYNC_ENABLE_OFFLINE_MAP_FAILED(9, "Failed to enable offline map."),

    UNKNOWN(-1),

    ;
    private final Integer reason;

    OfflineMapSyncReason(Integer reason) {
        this.reason = reason;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return reason;
    }

    @JsonCreator
    public static OfflineMapSyncReason parseKey(Integer key) {
        OfflineMapSyncReason parsedKey = RestKey.parseKey(OfflineMapSyncReason.class, key);
        return Optional.ofNullable(parsedKey).orElse(OfflineMapSyncReason.UNKNOWN);
    }

}
