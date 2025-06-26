package io.github.nicheengine.aerial.stereotype;


import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.version.CloudsdkVersion;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface DjisdkVersion {

    CloudsdkVersion since() default CloudsdkVersion.V0_0_1;

    CloudsdkVersion deprecated() default CloudsdkVersion.V_MAX_99;

    GatewayThing[] include() default {};

    GatewayThing[] exclude() default {};
}
