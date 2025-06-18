package io.github.nicheengine.aerial.mqtt.channel;

public interface EventsChannels {
    String INBOUND_EVENTS_DEVICE_EXIT_HOMING_NOTIFY = "inboundEventsDeviceExitHomingNotify";

    String INBOUND_EVENTS_FLIGHTTASK_PROGRESS = "inboundEventsFlighttaskProgress";

    String INBOUND_EVENTS_FLIGHTTASK_READY = "inboundEventsFlighttaskReady";

    String INBOUND_EVENTS_FILE_UPLOAD_CALLBACK = "inboundEventsFileUploadCallback";

    String INBOUND_EVENTS_HMS = "inboundEventsHms";

    String INBOUND_EVENTS_CONTROL_PROGRESS = "inboundEventsControlProgress";

    String INBOUND_EVENTS_OTA_PROGRESS = "inboundEventsOtaProgress";

    String INBOUND_EVENTS_FILEUPLOAD_PROGRESS = "inboundEventsFileUploadProgress";

    String INBOUND_EVENTS_FLY_TO_POINT_PROGRESS = "inboundEventsFlyToPointProgress";

    String INBOUND_EVENTS_TAKEOFF_TO_POINT_PROGRESS = "inboundEventsTakeoffToPointProgress";

    String INBOUND_EVENTS_DRC_STATUS_NOTIFY = "inboundEventsDrcStatusNotify";

    String INBOUND_EVENTS_JOYSTICK_INVALID_NOTIFY = "inboundEventsJoystickInvalidNotify";

    String INBOUND_EVENTS_HIGHEST_PRIORITY_UPLOAD_FLIGHT_TASK_MEDIA = "inboundEventsHighestPriorityUploadFlightTaskMedia";

    String INBOUND_EVENTS_RETURN_HOME_INFO = "inboundEventsReturnHomeInfo";

    String INBOUND_EVENTS_CUSTOM_DATA_TRANSMISSION_FROM_ESDK = "inboundEventsCustomDataTransmissionFromEsdk";

    String INBOUND_EVENTS_CUSTOM_DATA_TRANSMISSION_FROM_PSDK = "inboundEventsCustomDataTransmissionFromPsdk";

    String INBOUND_EVENTS_AIRSENSE_WARNING = "inboundEventsAirsenseWarning";

    String INBOUND_EVENTS_FLIGHT_AREAS_SYNC_PROGRESS = "inboundEventsFlightAreasSyncProgress";

    String INBOUND_EVENTS_FLIGHT_AREAS_DRONE_LOCATION = "inboundEventsFlightAreasDroneLocation";

    String INBOUND_EVENTS_OFFLINE_MAP_SYNC_PROGRESS = "inboundEventsOfflineMapSyncProgress";

    String INBOUND_EVENTS_POI_STATUS_NOTIFY = "inboundEventsPoiStatusNotify";

    String INBOUND_EVENTS_CAMERA_PHOTO_TAKE_PROGRESS = "inboundEventsCameraPhotoTakeProgress";

}
