package io.github.nicheengine.aerial.service;


import io.github.nicheengine.aerial.domain.LoginBody;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import io.github.nichetoolkit.rest.worker.sha.ShaWorker;
import io.github.nichetoolkit.rice.error.LoginInfoException;
import io.github.nichetoolkit.rice.error.LoginPasswordException;
import io.github.nichetoolkit.rice.error.TokenInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AerialLoginService {

    private final AerialUserService userService;
    private final AerialTokenService tokenService;

    @Autowired
    public AerialLoginService(AerialUserService userService, AerialTokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }


    public UserModel loginWithToken(LoginBody loginBody) throws RestException {
        String token = loginBody.getToken();
        UserModel localUser = tokenService.resolveUserInfo(token);
        String userId = localUser.getId();
        OptionalUtils.ofFalse(GeneralUtils.isNotEmpty(userId), log, TokenInvalidException::new);
        return localUser;
    }

    public UserModel loginWithPassword(LoginBody loginBody) throws RestException {
        String account = loginBody.getAccount();
        String password = loginBody.getPassword();
        OptionalUtils.ofFalse(GeneralUtils.isNotEmpty(account) && GeneralUtils.isNotEmpty(password), log,LoginInfoException::new);
        List<UserModel> modelList = userService.queryByName(account);
        OptionalUtils.ofFalse(GeneralUtils.isNotEmpty(modelList), log, LoginInfoException::new);
        Optional<UserModel> firstOptional = modelList.stream().findFirst();
        UserModel localUser = firstOptional.orElseThrow(LoginInfoException::new);
        String localPassword = localUser.password();
        if (GeneralUtils.isNotEmpty(localPassword)) {
            String encryptPassword = ShaWorker.encrypts(password);
            OptionalUtils.ofFalse(encryptPassword.equals(localPassword), log, LoginPasswordException::new);
        }
        return localUser;
    }

}
