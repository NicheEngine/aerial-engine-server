package io.github.nicheengine.aerial.handler;


import io.github.nicheengine.aerial.domain.LoginResult;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.service.AerialTokenService;
import io.github.nichetoolkit.rest.*;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.JsonUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import io.github.nichetoolkit.rice.TokenContext;
import io.github.nichetoolkit.rice.advice.LoginAdvice;
import io.github.nichetoolkit.rice.configure.RiceLoginProperties;
import io.github.nichetoolkit.rice.error.TokenPermissionException;
import io.github.nichetoolkit.rice.stereotype.RestLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class AerialLoginHandler implements LoginAdvice {

    private final RiceLoginProperties loginProperties;

    private final StringRedisTemplate redisTemplate;

    private final AerialTokenService tokenService;

    @Autowired
    public AerialLoginHandler(RiceLoginProperties loginProperties, StringRedisTemplate redisTemplate, AerialTokenService tokenService) {
        this.loginProperties = loginProperties;
        this.redisTemplate = redisTemplate;
        this.tokenService = tokenService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object doLoginHandle(RestHttpRequest httpRequest, Object body, MethodParameter returnType, TokenContext context) throws RestException {
        if (doResponseHandle(body)) {
            return null;
        }
        RestResult<Object> restResult = (RestResult<Object>) body;
        restResult.setMessage(RestErrorStatus.SUCCESS.getMessage());
        Object data = restResult.getData();
        if (GeneralUtils.isEmpty(data) || !(data instanceof LoginResult)) {
            data = new LoginResult();
            restResult.setData(data);
        }
        LoginResult loginResult = (LoginResult) data;
        RestLogin restLogin = returnType.getMethodAnnotation(RestLogin.class);
        String token;
        if (GeneralUtils.isNotEmpty(restLogin)) {
            String userId = String.valueOf(context.get(UserModel.LOGIN_USER_ID));
            loginResult.setUserId(userId);

            String userJson = String.valueOf(context.get(UserModel.LOGIN_USER_INFO));
            context.remove(UserModel.LOGIN_USER_INFO);
            UserModel user = JsonUtils.parseBean(userJson, UserModel.class);

            loginResult.setUser(user);
            token = tokenService.resolveToken(context, restLogin, loginResult);
            redisTemplate.opsForValue().set(UserModel.LOGIN_TOKEN + userId, userJson, loginProperties.getTokenExpiration(), loginProperties.getTokenTimeUnit());
            loginResult.setToken(token);
        }
        return body;
    }

    @Override
    public void doLogoutHandle(RestHttpRequest request, Object body, MethodParameter returnType, TokenContext context) throws RestException {
        UserModel userModel = tokenService.resolveUserInfo(request);
        RestOptional.ofNullable(userModel).isNotEmpty(user -> {
            String userId = user.getId();
            Object accessToken = redisTemplate.opsForValue().get(UserModel.LOGIN_TOKEN + userId);
            if (GeneralUtils.isNotEmpty(accessToken)) {
                redisTemplate.delete(UserModel.LOGIN_TOKEN + userId);
            }
        });
    }

    @Override
    public boolean preHandle(RestHttpRequest httpRequest, HttpServletResponse response, HandlerMethod handlerMethod) throws RestException {
        if (isSkipApi(httpRequest, handlerMethod)) {
            return true;
        }
        if (!doHeaderHandle(httpRequest, loginProperties.getTokenHeaders())) {
            return false;
        }
        UserModel user = tokenService.resolveUserInfo(httpRequest);
        OptionalUtils.ofNull(user, log, TokenPermissionException::new);
        return true;
    }

}
