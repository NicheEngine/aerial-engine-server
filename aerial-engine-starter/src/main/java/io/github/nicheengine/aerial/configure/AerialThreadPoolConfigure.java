package io.github.nicheengine.aerial.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

@Slf4j
@EnableAsync
@AutoConfiguration
@EnableConfigurationProperties(AerialExecutorProperties.class)
public class AerialThreadPoolConfigure {

    private final AerialExecutorProperties executorProperties;

    public AerialThreadPoolConfigure(AerialExecutorProperties executorProperties) {
        log.debug("The auto configuration for [thread-pool] initiated");
        this.executorProperties = executorProperties;
    }

    @Bean
    @ConditionalOnMissingBean(ThreadPoolExecutor.class)
    public ThreadPoolExecutor threadPool() {
        return new ThreadPoolExecutor(executorProperties.getCorePoolSize(),
                executorProperties.getMaxPoolSize(), executorProperties.getKeepaliveTime(),
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(executorProperties.getQueueCapacity()),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
