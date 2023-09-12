package dev.br93.articlesservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RandomTextService {
    
    private final RestClient loripsumClient;

    public String getRandomTitle() {
        return loripsumClient.get().uri("1/short/plaintext").retrieve().body(String.class);
    }

    public String getRandomText(){
        return loripsumClient.get().uri("2/medium/plaintext").retrieve().body(String.class);
    }
}
