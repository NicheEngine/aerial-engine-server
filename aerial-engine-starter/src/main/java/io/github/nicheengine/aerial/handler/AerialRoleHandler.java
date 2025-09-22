package io.github.nicheengine.aerial.handler;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.service.AerialTokenService;
import io.github.nicheengine.aerial.stereotype.RestRole;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestHttpRequest;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.RestReckon;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import io.github.nichetoolkit.rice.RestAfterLoginAdvice;
import io.github.nichetoolkit.rice.error.TokenPermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Component
public class AerialRoleHandler implements RestAfterLoginAdvice<RestRole> {

    private final AerialTokenService tokenService;

    @Autowired
    public AerialRoleHandler(AerialTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public int order() {
        return 97;
    }

    @Override
    public void doAnnotationHandle(RestHttpRequest request, HttpServletResponse response, HandlerMethod handlerMethod, RestRole role) throws RestException {
        UserModel userModel = tokenService.resolveUserInfo(request);
        /* custom key mode check*/
        roleKeysCheck(userModel,RestRole.Role.keys(role));
        /* custom value mode check*/
        roleValuesCheck(userModel,RestRole.Role.values(role));
    }

    private void roleKeysCheck(UserModel userModel,List<String> roleKeys) throws RestException {
        List<String> userRoleKeys = userModel.getRoleKeys();
        if (GeneralUtils.isNotEmpty(roleKeys)) {
            RestOptional.ofEmptyable(userRoleKeys).orElseThrow(TokenPermissionException::new);
            OptionalUtils.ofFalse(new HashSet<>(roleKeys).containsAll(userRoleKeys),log,TokenPermissionException::new);
        }
    }

    private void roleValuesCheck(UserModel userModel,List<Long> roleValues) throws RestException {
        Long userRoleValue = userModel.getRoleValue();
        if (GeneralUtils.isNotEmpty(roleValues)) {
            RestOptional.ofEmptyable(userRoleValue).orElseThrow(TokenPermissionException::new);
            Number annexValue = RestReckon.annexNumber(roleValues);
            OptionalUtils.ofFalse(RestReckon.reachNumber(annexValue,userRoleValue),log,TokenPermissionException::new);
        }
    }
}
