package br.com.rhssolutions.projetoTarefas.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfig {

    private Contact contato(){
         return new Contact()
                .name("RHSSolutions")
                .email("rhssolutions@gmail.com")
                .url("https://rhssolutions.com.br");
    }
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Projeto Tarefas")
                        .version("1.0.0")
                        .description("Projeto Tarefas")
                        .termsOfService("https://rhssolutions.com.br")
                        .contact(contato()));
    }
}
