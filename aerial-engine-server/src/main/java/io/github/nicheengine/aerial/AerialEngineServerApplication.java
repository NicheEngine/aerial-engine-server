package io.github.nicheengine.aerial;

import io.github.nichetoolkit.mybatis.scan.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MybatisAutoConfiguration
@ComponentScan(basePackages = {"io.github.nichetoolkit","io.github.nicheengine"})
public class AerialEngineServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AerialEngineServerApplication.class, args);
    }

}
