package se.salt.ecommerceback.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.salt.ecommerceback.cart.model.AddCartProductDTO;
import se.salt.ecommerceback.cart.model.CartResponseDTO;
import se.salt.ecommerceback.cart.service.CartService;

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
    ResponseEntity<CartResponseDTO> getById(@PathVariable String cartid){
        try {
            CartResponseDTO responseDTO = service.getById(cartid);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("#cartid == principal.username")
    @PostMapping("/{cartid}")
    ResponseEntity<CartResponseDTO> addCartProductToCart(@PathVariable String cartid, @RequestBody AddCartProductDTO dto){
        try {
            CartResponseDTO cart = service.addCartProductToCart(cartid, dto);
            return ResponseEntity.ok(cart);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
