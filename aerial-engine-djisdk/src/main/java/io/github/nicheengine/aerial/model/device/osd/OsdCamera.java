package io.github.nicheengine.aerial.model.device.osd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.control.*;
import io.github.nicheengine.aerial.enums.device.*;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;
import io.github.nicheengine.aerial.model.device.IrMeteringArea;
import io.github.nicheengine.aerial.model.device.IrMeteringPoint;
import io.github.nicheengine.aerial.model.device.LiveviewWorldRegion;
import io.github.nicheengine.aerial.model.device.payload.PayloadIndex;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OsdCamera extends AerialDjisdkModel {
    private CameraMode cameraMode;
    private LiveviewWorldRegion liveviewWorldRegion;
    private PayloadIndex payloadIndex;
    private CameraState photoState;
    private Integer recordTime;
    private CameraState recordingState;
    private Long remainPhotoNum;
    private Integer remainRecordDuration;
    private Float zoomFactor;
    private Float irZoomFactor;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    private Boolean screenSplitEnable;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    private List<LensStorageSettings> photoStorageSettings;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_0)
    private List<LensStorageSettings> videoStorageSettings;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private ExposureMode wideExposureMode;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private CameraIso wideIso;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private ShutterSpeed wideShutterSpeed;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private ExposureValue wideExposureValue;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private ExposureMode zoomExposureMode;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private CameraIso zoomIso;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private ShutterSpeed zoomShutterSpeed;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private ExposureValue zoomExposureValue;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private FocusMode zoomFocusMode;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private Integer zoomFocusValue;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private Integer zoomMaxFocusValue;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private Integer zoomMinFocusValue;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private MeteringMode irMeteringMode;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private IrMeteringPoint irMeteringPoint;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private IrMeteringArea irMeteringArea;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private Integer zoomCalibrateFarthestFocusValue;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private Integer zoomCalibrateNearestFocusValue;
    @DjisdkVersion(since = CloudSdkVersion.V1_0_2)
    private FocusState zoomFocusState;

}
