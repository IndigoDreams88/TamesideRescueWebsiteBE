package com.guineapigsanctuary.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GuineapigsanctuaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuineapigsanctuaryApplication.class, args);
	}

	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {

			registry.addMapping("/api/**")
					.allowedOrigins("https://guineapig-sanctuary.herokuapp.com/api/v1/animal")
					.allowedMethods("PUT", "DELETE", "GET", "POST")
					.allowedHeaders("header1", "header2", "header3")
					.exposedHeaders("header1", "header2")
					.allowCredentials(true).maxAge(3600);

		}
	}


}
