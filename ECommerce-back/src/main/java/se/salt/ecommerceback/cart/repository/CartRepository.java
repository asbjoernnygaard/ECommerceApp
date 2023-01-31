package se.salt.ecommerceback.cart.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.salt.ecommerceback.cart.model.Cart;

import java.util.NoSuchElementException;

@Repository
public class CartRepository {

    @Autowired
    CartJPARepository repo;

    public Cart getById(String id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
