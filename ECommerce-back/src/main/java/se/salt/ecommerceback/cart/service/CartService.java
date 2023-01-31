package se.salt.ecommerceback.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.ecommerceback.cart.model.Cart;
import se.salt.ecommerceback.cart.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    CartRepository repo;

    public Cart getById(String cartid) {
        return repo.getById(cartid);
    }
}
