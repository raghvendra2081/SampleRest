package com.example.sampleRest;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = testController.class)

public class SwaggerConfiguration {
	private static final String swagger_api_version = "1.0";
	private static final String license_text = "License";
	private static final String title = "Greeting Rest API";
	private static final String description = "Rest API for greeting";
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
			.title(title)
			.description(description)
			.license(license_text)
			.version(swagger_api_version)
			.build();
		
	}
	@Bean
	public Docket testApi(){
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo())
			.pathMapping("/")
			
			.select().apis(RequestHandlerSelectors.basePackage("com.example.sampleRest"))
			//.paths(PathSelectors.any())
			.paths(PathSelectors.regex("api/*"))
			.build();
	}
	
}
