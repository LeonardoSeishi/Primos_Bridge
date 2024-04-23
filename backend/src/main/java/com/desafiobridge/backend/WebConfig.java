package com.desafiobridge.backend;

// Importações necessárias para configuração do MVC e CORS
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//arquivo necessario para integrar o back-end e o front-end de maneira correta
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // Metodo sobreescrito da interface WebMvcConfigurer que me permite personalizar as configurações do CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                                          // Define um mapeamento de CORS para todas as rotas ('/**')
                .allowedOrigins("http://localhost:3000")                    // Permite requisições de CORS vindas especificamente do endereço do frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permite metodos HTTP específicos nas requisiçoes de CORS
                .allowedHeaders("*")                                        // Permite todos os cabeçalhos nas requisições de CORS
                .allowCredentials(true);                                    // Habilita o envio de credenciais como cookies na requisição de CORS
    }
}