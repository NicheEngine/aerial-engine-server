package io.github.nicheengine.aerial.service;


import io.github.nicheengine.aerial.domain.LoginBody;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import io.github.nichetoolkit.rest.worker.sha.ShaWorker;
import io.github.nichetoolkit.rice.error.LoginInfoException;
import io.github.nichetoolkit.rice.error.LoginPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AerialLoginService {

    private final AerialUserService userService;

    @Autowired
    public AerialLoginService(AerialUserService userService) {
        this.userService = userService;
    }

    public UserModel loginWithPassword(LoginBody loginBody) throws RestException {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        OptionalUtils.ofFalse(GeneralUtils.isNotEmpty(username) && GeneralUtils.isNotEmpty(password), log,LoginInfoException::new);
        List<UserModel> modelList = userService.queryByName(username, RestLoad.of("loadBase",false),RestLoad.of("loadDetail",false));
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
