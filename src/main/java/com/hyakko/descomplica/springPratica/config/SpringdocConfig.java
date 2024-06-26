package com.hyakko.descomplica.springPratica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringdocConfig {
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Exercício prático API Restful com Documentação")
	              .description("Exercício de API Restful utilizando Springdoc para documentação.")
	              .version("1.0.0")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Link do Repositório da Aplicação - APIRestful Documentation")
	              .url("https://github.com/SilverScreamBr/springPratica.git"));
	  }
}