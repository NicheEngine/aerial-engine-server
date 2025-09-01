package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.error.ServerErrorStatus;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.error.natives.UnsupportedErrorException;
import io.github.nichetoolkit.rice.stereotype.RestSkip;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>AerialHelloController</code>
 * <p>The aerial hello controller class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.RequestMapping
 * @since Jdk1.8
 */
@RestController
@RequestMapping("/aerial/v1.0.0")
public class AerialHelloController {

    /**
     * <code>hello</code>
     * <p>The hello method.</p>
     * @return {@link io.github.nichetoolkit.rest.RestResult} <p>The hello return object is <code>RestResult</code> type.</p>
     * @see io.github.nichetoolkit.rest.RestResult
     * @see io.github.nichetoolkit.rice.stereotype.RestSkip
     * @see org.springframework.web.bind.annotation.RequestMapping
     */
    @RestSkip
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public RestResult<?> hello() {
        return RestResult.mistake(ServerErrorStatus.HELLO_MESSAGE);
    }

    @RestSkip
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public RestResult<?> test() throws UnsupportedErrorException {
        throw new UnsupportedErrorException();
    }
}
