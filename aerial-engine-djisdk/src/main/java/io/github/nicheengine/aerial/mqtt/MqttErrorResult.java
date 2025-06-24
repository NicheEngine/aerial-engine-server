package io.github.nicheengine.aerial.mqtt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.enums.ErrorSource;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
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
public class MqttErrorResult implements AerialErrorStatus {
    private static final int MOD = 100_000;

    private ErrorSource source;
    private AerialErrorStatus errorCode;
    private boolean success;
    private Integer sourceCode;

    @JsonCreator
    public MqttErrorResult(Integer errorCode) {
        this.sourceCode = errorCode;
        if (MqttReplyResult.CODE_SUCCESS == errorCode) {
            this.success = true;
            this.errorCode = DjisdkErrorStatus.AERIAL_SUCCESS;
        } else {
            this.source = ErrorSource.parseKey(errorCode / MOD);
            this.errorCode = AerialErrorStatus.parseKey(errorCode);
        }
    }

    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }

    @JsonValue
    public Integer getCode() {
        return sourceCode;
    }
}
