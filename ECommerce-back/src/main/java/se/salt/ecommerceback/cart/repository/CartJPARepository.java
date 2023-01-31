package se.salt.ecommerceback.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.salt.ecommerceback.cart.model.Cart;

public interface CartJPARepository extends JpaRepository<Cart, String> {
}
