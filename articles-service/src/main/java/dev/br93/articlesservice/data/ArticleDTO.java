package dev.br93.articlesservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDTO {
    
    private String title;
    private String author;
    private String content;
}
