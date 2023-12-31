package dev.br93.articlesservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    
    @Bean
    RestClient restClient(RestClient.Builder builder) {
        return builder.baseUrl("https://loripsum.net/api/").build();
    } 
}
