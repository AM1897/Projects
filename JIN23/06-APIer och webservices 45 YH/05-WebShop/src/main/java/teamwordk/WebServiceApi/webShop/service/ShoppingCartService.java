package teamwordk.WebServiceApi.webShop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamwordk.WebServiceApi.webShop.model.ShoppingCart;
import teamwordk.WebServiceApi.webShop.repository.ShoppingCartRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepo shoppingCartRepo;
    private final ArticleService articleService;

    @Autowired
    public ShoppingCartService(ShoppingCartRepo shoppingCartRepo, ArticleService articleService) {
        this.shoppingCartRepo = shoppingCartRepo;
        this.articleService = articleService;
    }

    public ShoppingCart createShoppingCart() {
        ShoppingCart newCart = new ShoppingCart();
        return shoppingCartRepo.save(newCart);
    }

    public Optional<ShoppingCart> getShoppingCartById(Long id) {
        return shoppingCartRepo.findById(id);
    }

    public ShoppingCart addArticleToShoppingCart(Long cartId, Long articleId) {
        ShoppingCart shoppingCart = shoppingCartRepo.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));

        articleService.getArticleById(articleId)
                .ifPresent(shoppingCart::addArticle);

        return shoppingCartRepo.save(shoppingCart);
    }

    public ShoppingCart removeArticleFromShoppingCart(Long cartId, Long articleId) {
        ShoppingCart shoppingCart = shoppingCartRepo.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));

        shoppingCart.getArticles().removeIf(article -> article.getId().equals(articleId));

        return shoppingCartRepo.save(shoppingCart);
    }

    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepo.findAll();
    }

    public void deleteShoppingCart(Long id) {
        shoppingCartRepo.deleteById(id);
    }
}
