package cn.dbdj1201.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-24 15:01
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("**平台对外接口")
                        .description("1.提供**后台使用的接口 2.提供对其他服务调用的服务")
                        .contact(new Contact("yz1201", "https://github.com/yz1201", "15957121194@163.com"))
                        .version("1.0-SNAPSHOT")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.dbdj1201.exam.controller"))
                .build();
    }
}
