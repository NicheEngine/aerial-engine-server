package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.error.ServerErrorStatus;
import io.github.nichetoolkit.rest.RestResult;
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
        return RestResult.mistake(ServerErrorStatus.HELLO_MESSAGE);
    }
}
