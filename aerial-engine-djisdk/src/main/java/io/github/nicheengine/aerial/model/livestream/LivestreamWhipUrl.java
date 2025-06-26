package io.github.nicheengine.aerial.model.livestream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class LivestreamWhipUrl extends AerialDjisdkModel implements LivestreamUrl {
    @NotNull
    private String url;

    @Override
    public String toString() {
        return url;
    }

    @Override
    public LivestreamWhipUrl clone() {
        try {
            return (LivestreamWhipUrl) super.clone();
        } catch (CloneNotSupportedException e) {
            return LivestreamWhipUrl.builder().url(url).build();
        }
    }
}
