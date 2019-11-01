package com.produtos.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

// indica ao spring que essa é uma classe de configuração
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				// pacote base do projeto
				.apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
				// vai pegar td a partir do /api
				.paths(regex("/api.*"))
				.build()
				// indica quem criou a api
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Produtos API REST",
				"API REST de cadastro de produtos.",
				"1.0",
				"Terms of Service",
				new Contact("Michelli Brito",
					"https://www.youtube.com/michellibrito",
					"michellidibrito@gmail.com"),
					"Apache License Version 2.0",
					"https://www.apache.org/licesen.html",
					new ArrayList<VendorExtension>());

		return apiInfo;
	}
}
