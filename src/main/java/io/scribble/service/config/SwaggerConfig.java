package io.scribble.service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${info.group}")
    private String group;

    @Value("${info.title}")
    private String title;

    @Value("${info.description}")
    private String description;

    @Value("${info.version}")
    private String version;

    @Value("${server.servlet.context-path}")
    private String serverServletContextPath;

    @Bean
    public GroupedOpenApi groupedOpenApi() {

        return GroupedOpenApi.builder()
                .group(group)
                .packagesToScan("io.scribble.service")
                .build();
    }

    @Bean
    public OpenAPI openApi() {

        return new OpenAPI().addServersItem(new Server().url(serverServletContextPath))
                .info(new Info().title(title)
                        .description(description)
                        .version(version));
    }
}
