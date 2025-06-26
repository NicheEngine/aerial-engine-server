package io.github.nicheengine.aerial.aspect;

import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.error.AerialDeviceErrorException;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.status.DjisdkErrorStatus;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AerialDjisdkAspect {

    @Before("execution(public * io.github.nicheengine.aerial.service.*.*(io.github.nicheengine.aerial.manager.GatewayManager, ..))")
    public void beforeOfDjisdkVersion(JoinPoint point) throws RestException {
        GatewayManager gatewayManager = (GatewayManager) point.getArgs()[0];
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        DjisdkVersion djisdkVersion = methodSignature.getMethod().getDeclaredAnnotation(DjisdkVersion.class);
        if (GeneralUtils.isNotEmpty(djisdkVersion)) {
            OptionalUtils.ofFalse(gatewayManager.isTypeSupport(djisdkVersion), () -> new AerialDeviceErrorException(DjisdkErrorStatus.AERIAL_DEVICE_TYPE_UNSUPPORTED));
            OptionalUtils.ofFalse(gatewayManager.isVersionSupport(djisdkVersion), () -> new AerialDeviceErrorException(DjisdkErrorStatus.AERIAL_DEVICE_VERSION_UNSUPPORTED));
        }
    }

    @Before("execution(public * io.github.nicheengine.aerial.service.*.*(io.github.nicheengine.aerial.manager.GatewayManager, io.github.nicheengine.aerial.AerialDjisdkModel+))")
    public void beforeOfDjisdkModel(JoinPoint point) throws RestException {
        GatewayManager gatewayManager = (GatewayManager) point.getArgs()[0];
        AerialDjisdkModel djisdkModel = (AerialDjisdkModel) point.getArgs()[1];
        OptionalUtils.ofEmpty(djisdkModel,() -> new AerialServerErrorException(DjisdkErrorStatus.AERIAL_PARAM_ERROR));
        djisdkModel.verify(gatewayManager);
    }
}
