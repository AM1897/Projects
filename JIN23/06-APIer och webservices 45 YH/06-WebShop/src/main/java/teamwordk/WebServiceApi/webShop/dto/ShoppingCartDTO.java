package teamwordk.WebServiceApi.webShop.dto;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO {

    private Long id;
    private List<ArticleDTO> articles = new ArrayList<>();
    private double totalPrice;

    // Konstruktörer, getters och setters

    public ShoppingCartDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Hjälpmetoder om så behövs
    public void addArticle(ArticleDTO article) {
        this.articles.add(article);
        this.totalPrice += article.getPrice();
    }

    public void removeArticle(ArticleDTO article) {
        this.articles.remove(article);
        this.totalPrice -= article.getPrice();
    }
}
