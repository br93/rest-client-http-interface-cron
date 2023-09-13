package dev.br93.blogservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.br93.blogservice.client.ArticlesClient;
import dev.br93.blogservice.client.ArticlesRequest;
import dev.br93.blogservice.client.ArticlesResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("blog")
@RequiredArgsConstructor
public class BlogController {

    private final ArticlesClient articlesClient;

    @GetMapping
    public ResponseEntity<List<ArticlesResponse>> findAllArticles(){
        return new ResponseEntity<>(articlesClient.findAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticlesResponse> findArticleById(@PathVariable Long id){
        return new ResponseEntity<>(articlesClient.findArticleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArticlesResponse> createArticle(@RequestBody ArticlesRequest request){
        return new ResponseEntity<>(articlesClient.createArticle(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArticleById(@PathVariable Long id, @RequestBody ArticlesRequest request){
        articlesClient.updateArticleById(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id){
        articlesClient.deleteArticleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
