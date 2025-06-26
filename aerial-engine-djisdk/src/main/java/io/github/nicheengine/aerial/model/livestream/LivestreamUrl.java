package io.github.nicheengine.aerial.model.livestream;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public interface LivestreamUrl extends Serializable {
    @JsonValue
    String toString();

    LivestreamUrl clone();
}
