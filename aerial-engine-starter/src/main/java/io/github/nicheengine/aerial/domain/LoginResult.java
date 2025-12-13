package io.github.nicheengine.aerial.domain;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nichetoolkit.rice.RestLoginResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class LoginResult extends RestLoginResult<LoginResult> {
    private String userId;
    private UserModel user;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoginResult that = (LoginResult) o;
        return Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUserId());
    }
}
