package io.github.nicheengine.aerial.stereotype;


import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.version.CloudSdkVersion;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface DjisdkVersion {

    CloudSdkVersion since() default CloudSdkVersion.V0_0_1;

    CloudSdkVersion deprecated() default CloudSdkVersion.V_MAX_99;

    GatewayThing[] include() default {};

    GatewayThing[] exclude() default {};
}
