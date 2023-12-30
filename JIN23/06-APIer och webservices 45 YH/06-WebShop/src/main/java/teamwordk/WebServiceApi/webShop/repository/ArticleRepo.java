package teamwordk.WebServiceApi.webShop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamwordk.WebServiceApi.webShop.model.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {


}
