package io.github.nicheengine.aerial.handler;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.enums.PurviewType;
import io.github.nicheengine.aerial.service.AerialTokenService;
import io.github.nicheengine.aerial.stereotype.RestPurview;
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
public class AerialPurviewHandler implements RestAfterLoginAdvice<RestPurview> {

    private final AerialTokenService tokenService;

    @Autowired
    public AerialPurviewHandler(AerialTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public int order() {
        return 98;
    }

    @Override
    public void doAnnotationHandle(RestHttpRequest request, HttpServletResponse response, HandlerMethod handlerMethod, RestPurview purview) throws RestException {
        UserModel userModel = tokenService.resolveUserInfo(request);
        /* custom key mode check*/
        purviewKeysCheck(userModel,RestPurview.Purview.keys(purview));
        /* custom value mode check*/
        purviewValuesCheck(userModel,RestPurview.Purview.values(purview));
    }

    private void purviewKeysCheck(UserModel userModel,List<String> purviewKeys) throws RestException {
        List<String> userPurviewKeys = userModel.getPurviewKeys();
        if (GeneralUtils.isNotEmpty(purviewKeys)) {
            RestOptional.ofEmptyable(userPurviewKeys).orElseThrow(TokenPermissionException::new);
            OptionalUtils.ofFalse(new HashSet<>(purviewKeys).containsAll(userPurviewKeys),log,TokenPermissionException::new);
        }
    }

    private void purviewValuesCheck(UserModel userModel,List<Long> purviewValues) throws RestException {
        Long userPurviewValue = userModel.getPurviewValue();
        if (GeneralUtils.isNotEmpty(purviewValues)) {
            RestOptional.ofEmptyable(userPurviewValue).orElseThrow(TokenPermissionException::new);
            Number annexValue = RestReckon.annexNumber(purviewValues);
            OptionalUtils.ofFalse(RestReckon.reachNumber(annexValue,userPurviewValue),log,TokenPermissionException::new);
        }
    }
}
