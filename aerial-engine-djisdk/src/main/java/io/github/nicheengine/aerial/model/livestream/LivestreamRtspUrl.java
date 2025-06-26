package io.github.nicheengine.aerial.model.livestream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LivestreamRtspUrl extends AerialDjisdkModel implements LivestreamUrl {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Integer port;

    @Override
    public String toString() {
        return "userName=" + username +
                "&password=" + password +
                "&port=" + port;
    }

    @Override
    public LivestreamRtspUrl clone() {
        try {
            return (LivestreamRtspUrl) super.clone();
        } catch (CloneNotSupportedException e) {
            return LivestreamRtspUrl.builder().username(username).password(password).port(port).build();
        }
    }
}
