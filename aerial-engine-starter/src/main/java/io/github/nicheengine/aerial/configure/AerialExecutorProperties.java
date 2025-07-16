package io.github.nicheengine.aerial.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "nicheengine.aerial.executor")
public class AerialExecutorProperties {
    private Integer corePoolSize = 10;
    private Integer maxPoolSize = 20;
    private Long keepaliveTime = 60L;
    private Integer queueCapacity = 1000;

}
