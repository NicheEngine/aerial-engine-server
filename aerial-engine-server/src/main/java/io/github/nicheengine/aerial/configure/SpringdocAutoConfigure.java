package io.github.nicheengine.aerial.configure;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;

/**
 * <code>SpringdocAutoConfigure</code>
 * <p>The springdoc auto configure class.</p>
 * @see  lombok.extern.slf4j.Slf4j
 * @see  org.springframework.boot.autoconfigure.AutoConfiguration
 * @see  org.springframework.boot.autoconfigure.AutoConfigureAfter
 * @author Cyan (snow22314@outlook.com)
 * @since Jdk1.8
 */
@Slf4j
@AutoConfiguration
@AutoConfigureAfter(DatasourceAutoConfigure.class)
public class SpringdocAutoConfigure {

    /**
     * <code>SpringdocAutoConfigure</code>
     * <p>Instantiates a new springdoc auto configure.</p>
     */
    public SpringdocAutoConfigure() {
        log.debug("The auto configuration for [aerial-springdoc] initiated");
    }

    /**
     * <code>aerialSpringdocOpenAPI</code>
     * <p>The aerial springdoc open api method.</p>
     * @return  {@link io.swagger.v3.oas.models.OpenAPI} <p>The aerial springdoc open api return object is <code>OpenAPI</code> type.</p>
     * @see  io.swagger.v3.oas.models.OpenAPI
     * @see  org.springframework.context.annotation.Bean
     */
    @Bean
    public OpenAPI aerialSpringdocOpenAPI() {
        final String securitySchemeName = "OAuth 2.0";
        return new OpenAPI()
                .info(new Info()
                        .title("aerial-engine-server")
                        .description("Aerial engine server project for Spring Boot")
                        .version("v1.0.0")
                        .license(new License()
                                .name("The Apache License (Apache-2.0)")
                                .url("https://github.com/NicheEngine/aerial-engine-server/blob/master/LICENSE"))
                        .contact(new Contact()
                                .name("Cyan (snow22314@outlook.com)")
                                .email("snow22314@outlook.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("NicheEngine")
                        .url("https://github.com/NicheEngine"))
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
