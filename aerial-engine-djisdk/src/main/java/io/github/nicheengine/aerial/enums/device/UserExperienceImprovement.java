package io.github.nicheengine.aerial.enums.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum UserExperienceImprovement implements RestKey<Integer> {

    INITIAL(0),

    REFUSE(1),

    AGREE(2),

    UNKNOWN(-1),
    ;

    private final Integer state;

    UserExperienceImprovement(Integer state) {
        this.state = state;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.state;
    }

    @JsonCreator
    public static UserExperienceImprovement parseKey(Integer key) {
        UserExperienceImprovement parsedKey = RestKey.parseKey(UserExperienceImprovement.class, key);
        return Optional.ofNullable(parsedKey).orElse(UserExperienceImprovement.UNKNOWN);
    }
}
