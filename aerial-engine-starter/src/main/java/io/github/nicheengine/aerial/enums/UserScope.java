package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nichetoolkit.rest.RestKey;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum UserScope implements RestValue<Integer,String> {

    WEB(1,"Web"),

    PILOT(2,"Pilot"),

    UNKNOWN(-1,"Unknown"),
    ;

    private final Integer scope;

    private final String value;

    UserScope(Integer scope, String value) {
        this.scope = scope;
        this.value = value;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.scope;
    }

    @JsonCreator
    public static UserScope parseKey(Integer key) {
        UserScope parsedKey = RestKey.parseKey(UserScope.class, key);
        return Optional.ofNullable(parsedKey).orElse(UserScope.UNKNOWN);
    }
}
