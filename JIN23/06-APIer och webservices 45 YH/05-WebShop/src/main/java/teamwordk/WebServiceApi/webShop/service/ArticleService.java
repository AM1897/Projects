package teamwordk.WebServiceApi.webShop.service;


import teamwordk.WebServiceApi.webShop.model.Article;
import teamwordk.WebServiceApi.webShop.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepo articleRepo;

    @Autowired
    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public List<Article> getAllArticles() {
        return articleRepo.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepo.findById(id);
    }

    public Article createArticle(Article article) {
        return articleRepo.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        return articleRepo.findById(id)
                .map(article -> {
                    article.setName(updatedArticle.getName());
                    article.setDescription(updatedArticle.getDescription());
                    article.setPrice(updatedArticle.getPrice());
                    return articleRepo.save(article);
                })
                .orElseGet(() -> {
                    updatedArticle.setId(id);
                    return articleRepo.save(updatedArticle);
                });
    }

    public void deleteArticle(Long id) {
        articleRepo.deleteById(id);
    }
}