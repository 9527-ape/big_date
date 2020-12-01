package com.hongxing.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Title: SwaggerConfig.java
 * Description: Swagger配置类
 * Copyright: Copyright (c) 2020
 *
 * @author jsj
 * @date 2020.11.25
 */
@Configuration//申明是一个配置类
@EnableSwagger2//Swagger注解
public class SwaggerConfig {

    //Swagger插件
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()

                //设置，文档中不显示包含的admin内容
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                //设置，文档中不显示包含的错误的内容
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站-数据中心API文档")
                .description("本文档描述了数据中心微服务接口定义")
                .version("1.0")
                .contact(new Contact("JiaJia", "http://hx.com", "1597822458@qq.com"))
                .build();
    }
}
