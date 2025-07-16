package io.github.nicheengine.aerial.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@AutoConfiguration
@ComponentScan(basePackages = {"io.github.nicheengine.aerial"})
public class AerialStarterAutoConfigure {
    public AerialStarterAutoConfigure() {
        log.debug("The auto configuration for [aerial-starter] initiated");
    }
}
