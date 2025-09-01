package io.github.nicheengine.aerial.handler;

import io.github.nichetoolkit.rest.RestControllerHandler;
import io.github.nichetoolkit.rest.configure.RestExceptionProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@CrossOrigin
@RestControllerAdvice
public class AerialControllerHandler extends RestControllerHandler {
    @Autowired
    public AerialControllerHandler(RestExceptionProperties exceptionProperties) {
        super(exceptionProperties);
    }
}
