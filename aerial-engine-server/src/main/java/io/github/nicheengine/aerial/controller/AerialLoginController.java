package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.LoginBody;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.service.AerialLoginService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.userlog.stereotype.RestNotelog;
import io.github.nichetoolkit.rest.userlog.stereotype.RestUserlog;
import io.github.nichetoolkit.rest.util.JsonUtils;
import io.github.nichetoolkit.rice.TokenContext;
import io.github.nichetoolkit.rice.stereotype.RestLogin;
import io.github.nichetoolkit.rice.stereotype.RestLogout;
import io.github.nichetoolkit.rice.stereotype.RestUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RestNotelog(loggingKey = "login", notelog = "登录接口")
@RequestMapping("/aerial/v1.0.0")
public class AerialLoginController {

    private final AerialLoginService loginService;

    @Autowired
    public AerialLoginController(AerialLoginService loginService) {
        this.loginService = loginService;
    }

    @RestLogin
    @PostMapping("/login/password")
    @RestUserlog(loggingType = LoggingType.USER_LOGIN, userlog = "密码登陆")
    public RestResult<UserModel> loginWithPassword(TokenContext context, @RequestBody LoginBody loginBody) throws RestException {
        UserModel user = loginService.loginWithPassword(loginBody);
        return buildLoginResult(context, user);
    }

    @RestLogin
    @PostMapping("/login/token")
    @RestUserlog(loggingType = LoggingType.USER_LOGIN, userlog = "访问令牌登录")
    public RestResult<UserModel> loginWithAccessToken(TokenContext context, @RequestBody LoginBody loginBody) throws RestException {
        UserModel user = loginService.loginWithToken(loginBody);
        return buildLoginResult(context, user);
    }

    @RestLogout
    @GetMapping("/logout")
    @RestUserlog(loggingType = LoggingType.USER_LOGOUT, userlog = "用户登出")
    public RestResult<?> logout() throws RestException {
        return RestResult.success();
    }

    @GetMapping("/info")
    @RestUserlog(loggingType = LoggingType.USER, userlog = "用户信息")
    public RestResult<UserModel> info(@RestUser UserModel user) throws RestException {
        return RestResult.success(user);
    }

    private RestResult<UserModel> buildLoginResult(TokenContext context, UserModel user) {
        context.put(UserModel.LOGIN_USER_INFO, JsonUtils.parseJson(user));
        context.put(UserModel.LOGIN_USER_ID, user.getId());
        return RestResult.success(user);
    }

}
