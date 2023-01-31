package se.salt.ecommerceback.cart.model;

import lombok.Value;

import java.util.List;

@Value
public class CartResponseDTO {
    String id;
    List<CartProduct> cartProducts;
}
