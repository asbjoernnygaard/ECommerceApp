package se.salt.ecommerceback.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.salt.ecommerceback.cart.model.Cart;
import se.salt.ecommerceback.cart.service.CartService;

import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cart")
public class CartController {

    /* MOVE ALL OF THIS LOGIC TO USER/USERID/CART IN USERCONTROLLER */


    @Autowired
    CartService service;

    @GetMapping
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello!");
    }

    //Username is also cart_id, they have a OneToOne relationship
    @PreAuthorize("#cartid == principal.username")
    @GetMapping("/{cartid}")
    ResponseEntity<Cart> getById(@PathVariable String cartid){
        System.out.println(cartid);
        System.out.println();
        try {
            Cart cart = service.getById(cartid);
            return ResponseEntity.ok(cart);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
