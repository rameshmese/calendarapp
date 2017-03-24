package com.ramesh.calendarapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableSwagger2
public class CalendarappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarappApplication.class, args);
	}
	
	/**
	 * @return Docket
	 */
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.groupName("Calendar App").apiInfo(apiInfo()).select()
				.paths(PathSelectors.any()).build();
	}
	
	/**
	 * @return apiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Calendar App MicroService")
				.description("Calendar App MicroService With Swagger").build();
	}
}