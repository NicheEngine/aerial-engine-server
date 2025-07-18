package io.github.nicheengine.aerial.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <code>AerialExecutorProperties</code>
 * <p>The aerial executor properties class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.Getter
 * @see lombok.Setter
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 * @since Jdk1.8
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "nicheengine.aerial.executor")
public class AerialExecutorProperties {
    /**
     * <code>corePoolSize</code>
     * {@link java.lang.Integer} <p>The <code>corePoolSize</code> field.</p>
     * @see java.lang.Integer
     */
    private Integer corePoolSize = 10;
    /**
     * <code>maxPoolSize</code>
     * {@link java.lang.Integer} <p>The <code>maxPoolSize</code> field.</p>
     * @see java.lang.Integer
     */
    private Integer maxPoolSize = 20;
    /**
     * <code>keepaliveTime</code>
     * {@link java.lang.Long} <p>The <code>keepaliveTime</code> field.</p>
     * @see java.lang.Long
     */
    private Long keepaliveTime = 60L;
    /**
     * <code>queueCapacity</code>
     * {@link java.lang.Integer} <p>The <code>queueCapacity</code> field.</p>
     * @see java.lang.Integer
     */
    private Integer queueCapacity = 1000;

}
