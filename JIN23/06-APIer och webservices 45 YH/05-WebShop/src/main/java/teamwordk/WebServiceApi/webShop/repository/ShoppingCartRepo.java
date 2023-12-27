package teamwordk.WebServiceApi.webShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamwordk.WebServiceApi.webShop.model.ShoppingCart;


@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {


}
