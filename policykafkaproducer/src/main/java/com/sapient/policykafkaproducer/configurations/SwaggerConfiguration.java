package com.sapient.policykafkaproducer.configurations;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
@Configuration
@EnableSwagger2WebMvc
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	
	 @Bean
	    public Docket apiDocketcategoryparamv10() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.groupName("policy-api-1.0")
	                .select()
	                .apis(RequestHandlerSelectors
	                        .basePackage("com.sapient.policykafkaproducer"))
	                .paths(PathSelectors.regex("/policies/v1.0.*"))
	                .build()
	                .apiInfo(getApiInfo())
	                .forCodeGeneration(true)
	                .genericModelSubstitutes(ResponseEntity.class)
	                .ignoredParameterTypes(Pageable.class)
	                .ignoredParameterTypes(java.sql.Date.class)
	                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
	                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
	              
	                .useDefaultResponseMessages(false);
	    }
   
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Policy API",
                "App to demonstrate API Documentation",
                "0.0.1-SNAPSHOT",
                "Terms of Service",
                new Contact("Parameswari",
                        "https://blog.eswari.in",
                        "parameswaribala@gmail.com"),
                "OSS License",
                "https://blog.eswari.in",
                Collections.emptyList());
    }
    
	
}