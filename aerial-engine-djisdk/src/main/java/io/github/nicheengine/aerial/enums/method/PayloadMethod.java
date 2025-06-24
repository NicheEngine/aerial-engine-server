package io.github.nicheengine.aerial.enums.method;

import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.model.control.GimbalResetRequest;
import io.github.nicheengine.aerial.model.control.VideoStorageSetRequest;
import io.github.nicheengine.aerial.model.control.camera.*;
import io.github.nicheengine.aerial.model.control.irmetering.IrMeteringAreaSetRequest;
import io.github.nicheengine.aerial.model.control.irmetering.IrMeteringModeSetRequest;
import io.github.nicheengine.aerial.model.control.irmetering.IrMeteringPointSetRequest;
import io.github.nicheengine.aerial.model.control.photo.PhotoStorageSetRequest;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

@Getter
public enum PayloadMethod implements RestValue<ControlMethod,Class<? extends AerialDjisdkModel>> {

    CAMERA_MODE_SWITCH(ControlMethod.CAMERA_MODE_SWITCH, CameraModeSwitchRequest.class),

    CAMERA_PHOTO_TAKE(ControlMethod.CAMERA_PHOTO_TAKE, CameraPhotoTakeRequest.class),

    CAMERA_PHOTO_STOP(ControlMethod.CAMERA_PHOTO_STOP, CameraPhotoStopRequest.class),

    CAMERA_RECORDING_START(ControlMethod.CAMERA_RECORDING_START, CameraRecordingStartRequest.class),

    CAMERA_RECORDING_STOP(ControlMethod.CAMERA_RECORDING_STOP, CameraRecordingStopRequest.class),

    CAMERA_AIM(ControlMethod.CAMERA_AIM, CameraAimRequest.class),

    CAMERA_FOCAL_LENGTH_SET(ControlMethod.CAMERA_FOCAL_LENGTH_SET, CameraFocalLengthSetRequest.class),

    CAMERA_SCREEN_DRAG(ControlMethod.CAMERA_SCREEN_DRAG, CameraScreenDragRequest.class),

    GIMBAL_RESET(ControlMethod.GIMBAL_RESET, GimbalResetRequest.class),

    CAMERA_LOOK_AT(ControlMethod.CAMERA_LOOK_AT, CameraLookAtRequest.class),

    CAMERA_SCREEN_SPLIT(ControlMethod.CAMERA_SCREEN_SPLIT, CameraScreenSplitRequest.class),

    PHOTO_STORAGE_SET(ControlMethod.PHOTO_STORAGE_SET, PhotoStorageSetRequest.class),

    VIDEO_STORAGE_SET(ControlMethod.VIDEO_STORAGE_SET, VideoStorageSetRequest.class),

    CAMERA_EXPOSURE_SET(ControlMethod.CAMERA_EXPOSURE_SET, CameraExposureSetRequest.class),

    CAMERA_EXPOSURE_MODE_SET(ControlMethod.CAMERA_EXPOSURE_MODE_SET, CameraExposureModeSetRequest.class),

    CAMERA_FOCUS_MODE_SET(ControlMethod.CAMERA_FOCUS_MODE_SET, CameraFocusModeSetRequest.class),

    CAMERA_FOCUS_VALUE_SET(ControlMethod.CAMERA_FOCUS_VALUE_SET, CameraFocusValueSetRequest.class),

    IR_METERING_MODE_SET(ControlMethod.IR_METERING_MODE_SET, IrMeteringModeSetRequest.class),

    IR_METERING_POINT_SET(ControlMethod.IR_METERING_POINT_SET, IrMeteringPointSetRequest.class),

    IR_METERING_AREA_SET(ControlMethod.IR_METERING_AREA_SET, IrMeteringAreaSetRequest.class),

    CAMERA_POINT_FOCUS_ACTION(ControlMethod.CAMERA_POINT_FOCUS_ACTION, CameraPointFocusActionRequest.class),

    UNKNOWN(ControlMethod.UNKNOWN,AerialDjisdkModel.class),

    ;

    private final ControlMethod payloadMethod;

    private final Class<? extends AerialDjisdkModel> type;

    PayloadMethod(ControlMethod payloadMethod, Class<? extends AerialDjisdkModel> type) {
        this.payloadMethod = payloadMethod;
        this.type = type;
    }
    
    @Override
    public Class<? extends AerialDjisdkModel> getValue() {
        return this.type;
    }

    @Override
    public ControlMethod getKey() {
        return this.payloadMethod;
    }
}
