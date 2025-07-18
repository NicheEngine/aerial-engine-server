package io.github.nicheengine.aerial.domain;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nichetoolkit.rice.RestLoginResult;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class LoginResult extends RestLoginResult<LoginResult> {
    private String userId;
    private UserModel user;

    public LoginResult() {
    }

    public LoginResult(String accessToken) {
        super(accessToken);
    }

}
