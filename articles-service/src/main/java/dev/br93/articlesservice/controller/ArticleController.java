package dev.br93.articlesservice.controller;

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

import dev.br93.articlesservice.data.ArticleDTO;
import dev.br93.articlesservice.service.ArticleService;
import dev.br93.articlesservice.service.RandomTextService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("articles")
public class ArticleController {
    
    private final ArticleService articleService;
    private final RandomTextService randomTextService;

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> findAll(){
        return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<ArticleDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(articleService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO dto){
        return new ResponseEntity<>(articleService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody ArticleDTO dto){
        articleService.updateById(id, dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("random")
    public String getRandom(){
        return randomTextService.getRandomText();
    }
}
