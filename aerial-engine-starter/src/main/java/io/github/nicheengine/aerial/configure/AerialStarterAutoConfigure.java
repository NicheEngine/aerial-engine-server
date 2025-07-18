package io.github.nicheengine.aerial.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

@Slf4j
@AutoConfiguration
@AutoConfigureAfter(AerialDjisdkAutoConfigure.class)
@ImportAutoConfiguration({AerialRedisAutoConfigure.class})
public class AerialStarterAutoConfigure {
    public AerialStarterAutoConfigure() {
        log.debug("The auto configuration for [aerial-starter] initiated");
    }
}
