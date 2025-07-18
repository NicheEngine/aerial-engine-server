package io.github.nicheengine.aerial.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@AutoConfiguration
@ImportAutoConfiguration(DatasourceAutoConfigure.class)
@AutoConfigureAfter(AerialStarterAutoConfigure.class)
@ComponentScan("io.github.nicheengine.aerial")
public class AerialServerAutoConfigure {
    public AerialServerAutoConfigure() {
        log.debug("The auto configuration for [aerial-server] initiated");
    }
}
