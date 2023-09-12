package dev.br93.articlesservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import dev.br93.articlesservice.data.ArticleDTO;
import dev.br93.articlesservice.data.ArticleModel;
import dev.br93.articlesservice.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    
    private final List<ArticleModel> articles = new ArrayList<>();
    private final RandomTextService randomTextService;

    @Scheduled(fixedRate = 10000L) //every 10s
    public void scheduledCreate(){

        Long id = Long.valueOf(articles.size()) + 1L ;
        String title = randomTextService.getRandomTitle();
        String content = randomTextService.getRandomText();

        ArticleModel article = new ArticleModel(id, title, "admin", content);
        articles.add(article);
    }

    public List<ArticleDTO> findAll(){
        return articles.stream().map(ArticleMapper::toDTO).collect(Collectors.toList());
    }

    public ArticleDTO findById(Long id){
        ArticleModel article = articles.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Article not found"));
    
        return ArticleMapper.toDTO(article);
    }

    public ArticleDTO create(ArticleDTO dto){
        ArticleModel newArticle = ArticleMapper.toModel(articles, dto);
        articles.add(newArticle);

        return ArticleMapper.toDTO(newArticle);
    }

    public void deleteById(Long id){
        articles.stream().filter( x -> x.getId().equals(id)).findFirst().ifPresent(x -> articles.remove(x));
    }

    public void updateById(Long id, ArticleDTO dto){
        ArticleModel updatedArticle = ArticleMapper.toModel(articles, dto);
        updatedArticle.setId(id);

        articles.stream().filter(x -> x.getId().equals(id)).findFirst().ifPresent(x -> articles.set( (int) id.longValue(), updatedArticle));

    }
}
