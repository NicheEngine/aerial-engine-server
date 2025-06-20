package io.github.nicheengine.aerial.model.device.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.PayloadPosition;
import io.github.nicheengine.aerial.enums.device.DeviceCamera;
import io.github.nicheengine.aerial.enums.device.DeviceSubtype;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PayloadIndex extends AerialDjisdkModel {
    @NotNull
    private DeviceCamera type;
    @NotNull
    private DeviceSubtype subType;
    @NotNull
    private PayloadPosition position;

    @JsonCreator
    public PayloadIndex(String payloadIndex) throws AerialServerErrorException {
        Objects.requireNonNull(payloadIndex);
        int[] payloadIndexArr = Arrays.stream(payloadIndex.split("-")).mapToInt(Integer::parseInt).toArray();
        if (payloadIndexArr.length != 3) {
            throw new AerialServerErrorException(AerialErrorStatus.AERIAL_PARAM_ERROR);
        }
        this.type = DeviceCamera.parseKey(payloadIndexArr[0]);
        this.subType = DeviceSubtype.parseKey(payloadIndexArr[1]);
        this.position = PayloadPosition.parseKey(payloadIndexArr[2]);
    }

    @Override
    @JsonValue
    public String toString() {
        return String.format("%s-%s-%s", type.getType(), subType.getSubtype(), position.getPosition());
    }
}
