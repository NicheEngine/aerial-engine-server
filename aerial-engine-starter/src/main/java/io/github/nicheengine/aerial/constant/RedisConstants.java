package io.github.nicheengine.aerial.constant;

public interface RedisConstants {
    int WAYLINE_JOB_BLOCK_TIME = 600;

    String DELIMITER = ":";

    Integer DEVICE_ALIVE_SECOND = 60;

    Integer WEBSOCKET_ALIVE_SECOND = 60 * 60 * 24;

    String DEVICE_ONLINE_PREFIX = "online" + DELIMITER;

    String WEBSOCKET_PREFIX = "webSocket" + DELIMITER;

    String WEBSOCKET_ALL = WEBSOCKET_PREFIX + "all";

    String HMS_PREFIX = "hms" + DELIMITER;

    String FIRMWARE_UPGRADING_PREFIX = "upgrading" + DELIMITER;

    String STATE_PAYLOAD_PREFIX = "payload" + DELIMITER;

    String LOGS_FILE_PREFIX = "logs_file" + DELIMITER;

    String WAYLINE_JOB_TIMED_EXECUTE = "wayline_job_timed_execute";

    String WAYLINE_JOB_CONDITION_PREPARE = "wayline_job_condition_prepare";

    String WAYLINE_JOB_CONDITION_PREFIX = WAYLINE_JOB_CONDITION_PREPARE + DELIMITER;

    String WAYLINE_JOB_BLOCK_PREFIX = "wayline_job_block" + DELIMITER;

    String WAYLINE_JOB_RUNNING_PREFIX = "wayline_job_running" + DELIMITER;

    String WAYLINE_JOB_PAUSED_PREFIX = "wayline_job_paused" + DELIMITER;

    String OSD_PREFIX = "osd" + DELIMITER;

    String MEDIA_FILE_PREFIX = "media_file" + DELIMITER;

    String MEDIA_HIGHEST_PRIORITY_PREFIX = "media_highest_priority" + DELIMITER;

    String LIVE_CAPACITY = "live_capacity";


    String EASY_GBS_TOKEN = "easygbs_token";

    String AI_WARN_TOKEN = "ai_warn_token";

    String DRC_PREFIX = "drc" + DELIMITER;

    Integer DRC_MODE_ALIVE_SECOND = 3600;

    String MQTT_ACL_PREFIX = "mqtt_acl" + DELIMITER;

    String FILE_UPLOADING_PREFIX = "file_uploading" + DELIMITER;

    String DRONE_CONTROL_PREFiX = "control_source" + DELIMITER;
}