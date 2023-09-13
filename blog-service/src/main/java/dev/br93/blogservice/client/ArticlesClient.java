package dev.br93.blogservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

public interface ArticlesClient {

    @GetExchange
    List<ArticlesResponse> findAllArticles();

    @GetExchange("/{id}")
    ArticlesResponse findArticleById(@PathVariable Long id);

    @PostExchange
    ArticlesResponse createArticle(@RequestBody ArticlesRequest request);

    @PutExchange("/{id}")
    void updateArticleById(@PathVariable Long id, @RequestBody ArticlesRequest request);

    @DeleteExchange("/{id}")
    void deleteArticleById(@PathVariable Long id);
    
}
