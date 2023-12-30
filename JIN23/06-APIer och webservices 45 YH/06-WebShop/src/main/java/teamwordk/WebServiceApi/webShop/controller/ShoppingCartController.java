package teamwordk.WebServiceApi.webShop.controller;

import teamwordk.WebServiceApi.webShop.model.ShoppingCart;
import teamwordk.WebServiceApi.webShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart() {
        ShoppingCart newCart = shoppingCartService.createShoppingCart();
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }    // Här skapar vi en ny kundvagn och returnerar den till klienten (eller någon annan lämplig HTTP-statuskod)

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable Long id) {
        return shoppingCartService.getShoppingCartById(id)
                .map(cart -> new ResponseEntity<>(cart, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }    // Här hämtar vi en kundvagn baserat på ID och returnerar den till klienten (eller någon annan lämplig HTTP-statuskod)


    @PostMapping("/{cartId}/article/{articleId}") // Detta är en POST-metod eftersom vi skapar en ny artikel i kundvagnen
    public ResponseEntity<ShoppingCart> addArticleToShoppingCart(@PathVariable Long cartId, @PathVariable Long articleId) { // @PathVariable används för att hämta parametrar från URL:en och skicka in dem som argument till metoden (i detta fall cartId och articleId)
        try { // Vi använder try-catch för att hantera eventuella undantag som kan kastas från service-lagret (t.ex. om kundvagnen eller artikeln inte hittas) och returnera en lämplig HTTP-statuskod till klienten (t.ex. 404 Not Found)
            ShoppingCart updatedCart = shoppingCartService.addArticleToShoppingCart(cartId, articleId); // Anropa metoden i service-lagret för att lägga till artikeln i kundvagnen
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);  // Returnera den uppdaterade kundvagnen till klienten (eller någon annan lämplig HTTP-statuskod)
        } catch (IllegalArgumentException e) { // Om vi fångar ett IllegalArgumentException-undantag betyder det att kundvagnen eller artikeln inte hittades
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returnera 404 Not Found till klienten om kundvagnen eller artikeln inte hittades (eller någon annan lämplig HTTP-statuskod)
        }
    }

    @DeleteMapping("/{cartId}/article/{articleId}")
    public ResponseEntity<ShoppingCart> removeArticleFromShoppingCart(@PathVariable Long cartId, @PathVariable Long articleId) {
        try {
            ShoppingCart updatedCart = shoppingCartService.removeArticleFromShoppingCart(cartId, articleId);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } // Här tar vi bort en artikel från kundvagnen och returnerar den uppdaterade kundvagnen till klienten (eller någon annan lämplig HTTP-statuskod)

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable Long id) {
        shoppingCartService.deleteShoppingCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } // Här tar vi bort en kundvagn och returnerar 204 No Content till klienten (eller någon annan lämplig HTTP-statuskod) om kundvagnen togs bort, eller 404 Not Found om kundvagnen inte hittades i databasen
}
