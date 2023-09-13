package dev.br93.blogservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticlesResponse {

    private String title;
    private String author;
    private String content;
    
}
