package com.johnny.vis.cloud.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Johnny
 * @date 2020-12-24
 *
 * swagger2的配置文件，在项目的启动类的同级文件建立
 */
@Configuration
@EnableSwagger2
//@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.johnny.vis.cloud.article.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("VIS CLOUD SWAGGER")
                // 创建人信息
                .contact(new Contact("Johnny", "", "1249864985@qq.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }
}
