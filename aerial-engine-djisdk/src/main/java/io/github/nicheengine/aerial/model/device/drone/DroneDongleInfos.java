package io.github.nicheengine.aerial.model.device.drone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.debug.SimSlot;
import io.github.nicheengine.aerial.enums.device.DongleType;
import io.github.nicheengine.aerial.enums.device.EsimActivateState;
import io.github.nicheengine.aerial.enums.device.SimCardState;
import io.github.nicheengine.aerial.model.device.info.EsimInfo;
import io.github.nicheengine.aerial.model.device.info.SimInfo;
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
public class DroneDongleInfos extends AerialDjisdkModel {
    private String imei;
    private DongleType dongleType;
    private String eid;
    private EsimActivateState esimActivateState;
    private SimCardState simCardState;
    private SimSlot simSlot;
    private List<EsimInfo> esimInfos;
    private SimInfo simInfo;
}
