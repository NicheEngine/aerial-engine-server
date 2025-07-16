package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.constant.I18nConstants;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.util.I18nUtils;
import io.github.nichetoolkit.rice.stereotype.RestSkip;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api_v1")
public class AerialHelloController {

    @RestSkip
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public RestResult<?> hello() {
        return RestResult.success(I18nUtils.message("AERIAL_DJISDK_ERROR_312015"));
    }
}
