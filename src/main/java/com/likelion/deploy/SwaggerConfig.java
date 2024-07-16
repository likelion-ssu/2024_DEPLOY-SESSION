package com.likelion.deploy;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("프로젝트 이름")
                        .version("1.0")
                        .description("배포 세션 demo swagger-ui 화면입니다."));


    }

    @Bean
    public GroupedOpenApi api() {
        String[] paths = {"/**"};
        String[] packagesToScan = {"com.likelion.deploy"};
        return GroupedOpenApi.builder()
                .group("group-name")
                .pathsToMatch(paths)
                .packagesToScan(packagesToScan)
                .build();
    }
}
