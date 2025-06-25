package io.github.nicheengine.aerial.model.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.livestream.VideoQuality;
import io.github.nicheengine.aerial.enums.livestream.VideoType;
import io.github.nicheengine.aerial.mqtt.MqttErrorResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LiveStatus extends AerialDjisdkModel {
    private Boolean status;
    private VideoId videoId;
    private VideoQuality videoQuality;
    private VideoType videoType;
    private MqttErrorResult errorStatus;
}
