package com.tse.cost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * @author liangw
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfiguration {


    @Bean(value = "webGroup")
    public Docket webGroup() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("1.管理后台")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.seedxion.worker.controller.web"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    @Bean(value = "miniProgramGroup")
    public Docket miniProgramGroup() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.小程序")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.seedxion.worker.controller.applet"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    @Bean(value = "commonGroup")
    public Docket commonGroup() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("3.公共接口")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.seedxion.worker.controller.common"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("工单系统接口文档")
                .description("工单系统接口文档")
                .termsOfServiceUrl("")
                .contact("seedxion")
                .version("1.0")
                .build();
    }

}
