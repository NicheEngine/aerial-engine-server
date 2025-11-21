package io.github.nicheengine.aerial.configure;

import io.github.nichetoolkit.rest.resource.RestI18nResources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <code>AerialStarterAutoConfigure</code>
 * <p>The aerial starter auto configure class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.boot.autoconfigure.AutoConfiguration
 * @see org.springframework.boot.autoconfigure.AutoConfigureAfter
 * @see org.springframework.boot.autoconfigure.ImportAutoConfiguration
 * @since Jdk1.8
 */
@Slf4j
@AutoConfiguration
@AutoConfigureAfter(AerialDjisdkAutoConfigure.class)
@ImportAutoConfiguration({AerialRedisAutoConfigure.class})
public class AerialStarterAutoConfigure {

    /**
     * <code>AERIAL_I18N</code>
     * {@link java.lang.String} <p>The constant <code>AERIAL_I18N</code> field.</p>
     * @see java.lang.String
     */
    private static final String AERIAL_I18N = "aerial-i18n/messages";

    /**
     * <code>AerialStarterAutoConfigure</code>
     * <p>Instantiates a new aerial starter auto configure.</p>
     */
    public AerialStarterAutoConfigure() {
        log.debug("The auto configuration for [aerial-starter] initiated");
    }

    /**
     * <code>aerialI18nResources</code>
     * <p>The aerial i 18 n resources method.</p>
     * @return {@link io.github.nichetoolkit.rest.resource.RestI18nResources} <p>The aerial i 18 n resources return object is <code>RestI18nResources</code> type.</p>
     * @see io.github.nichetoolkit.rest.resource.RestI18nResources
     * @see org.springframework.context.annotation.Bean
     */
    @Bean
    public RestI18nResources aerialI18nResources() {
        return RestI18nResources.of(AERIAL_I18N);
    }
}
