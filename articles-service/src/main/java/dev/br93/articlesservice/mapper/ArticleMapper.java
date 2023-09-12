package dev.br93.articlesservice.mapper;

import java.util.List;

import dev.br93.articlesservice.data.ArticleDTO;
import dev.br93.articlesservice.data.ArticleModel;

public class ArticleMapper {

    private ArticleMapper(){}

    public static ArticleModel toModel(List<ArticleModel> articles, ArticleDTO dto) {
        Long newId = Long.valueOf(articles.size() + 1);

        return new ArticleModel(newId, dto.getTitle(), dto.getAuthor(), dto.getContent());
    }

    public static ArticleDTO toDTO(ArticleModel model){
        return new ArticleDTO(model.getTitle(), model.getAuthor(), model.getContent());
    }

}
