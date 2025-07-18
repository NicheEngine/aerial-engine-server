package io.github.nicheengine.aerial;

import io.github.nichetoolkit.mybatis.scan.EnableMybatisConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <code>AerialEngineServerApplication</code>
 * <p>The aerial engine server application class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 * @see io.github.nichetoolkit.mybatis.scan.EnableMybatisConfiguration
 * @since Jdk1.8
 */
@SpringBootApplication
@EnableMybatisConfiguration
public class AerialEngineServerApplication extends SpringBootServletInitializer {

    /**
     * <code>main</code>
     * <p>The entry point of application.</p>
     * @param args {@link java.lang.String} <p>The input arguments.</p>
     * @see java.lang.String
     */
    public static void main(String[] args) {
        SpringApplication.run(AerialEngineServerApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AerialEngineServerApplication.class);
    }
}
