package io.github.nicheengine.aerial.handler;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.service.AerialTokenService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestHttpRequest;
import io.github.nichetoolkit.rice.RestUserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class AerialUserResolver implements RestUserResolver {

    private final AerialTokenService tokenService;

    @Autowired
    public AerialUserResolver(AerialTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @NonNull
    @Override
    public UserModel resolveUser(MethodParameter parameter, RestHttpRequest httpRequest) throws RestException {
        return tokenService.resolveUserInfo(httpRequest);
    }
}
