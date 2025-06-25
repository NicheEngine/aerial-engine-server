package io.github.nicheengine.aerial.model.device.rc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RcPayloadFirmwareVersion extends AerialDjisdkModel {
    private PayloadPosition position;
    private String firmwareVersion;

    @JsonCreator
    public RcPayloadFirmwareVersion(Map<String, Object> paramsMap) {
        paramsMap.entrySet().stream().findFirst().ifPresent(entry -> {
            String[] split = entry.getKey().split("-");
            if (GeneralUtils.isNotEmpty(split) && split.length > 1) {
                this.position = PayloadPosition.parseKey(Integer.parseInt(split[1]));
            }
            Map<String, String> entryValue = JsonUtils.parseConvert(entry.getValue(), new TypeReference<Map<String, String>>() {});
            if (GeneralUtils.isNotEmpty(entryValue) && GeneralUtils.isNotEmpty(entryValue.values())) {
                entryValue.values().stream().findFirst().ifPresent(value -> this.firmwareVersion = value);
            }
        });
    }

}
