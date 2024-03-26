package com.possistemaecommerc.controllers.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition
public class SwaggerConfiguration {
    //método para configurar a geração da documentação..
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Projeto fase 5 para pós graduação em Arquitetura de Sistemas Java");


        Info information = new Info()
                .title("Projeto PosTech Fiap Fase-5")
                .version("1.0.0")
                .description("Esta aplicação expõe os endpoints para gerenciamento da Api.");
        return new OpenAPI().components(new Components()).info(information).servers(List.of(server));
    }
}
