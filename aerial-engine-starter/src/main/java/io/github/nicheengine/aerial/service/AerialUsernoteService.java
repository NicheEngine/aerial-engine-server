package io.github.nicheengine.aerial.service;


import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.domain.model.UserlogModel;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestHttpRequest;
import io.github.nichetoolkit.rice.defaults.DefaultUsernoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>UsernoteService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version v1.0.0
 */
@Slf4j
@Service
public class AerialUsernoteService extends DefaultUsernoteService<UserlogModel> {

    private final AerialUserlogService userlogService;

    private final AerialTokenService tokenService;

    @Autowired
    public AerialUsernoteService(AerialUserlogService userlogService, AerialTokenService tokenService) {
        this.userlogService = userlogService;
        this.tokenService = tokenService;
    }

    @Override
    public UserModel resolveUserInfo(RestHttpRequest httpRequest) throws RestException {
        return tokenService.resolveUserInfo(httpRequest);
    }

    @Async
    @Override
    public void doUsernoteHandle(UserlogModel userlogModel) throws RestException {
        userlogService.save(userlogModel);
    }
}
