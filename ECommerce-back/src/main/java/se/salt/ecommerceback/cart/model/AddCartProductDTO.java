package se.salt.ecommerceback.cart.model;

import lombok.Value;

@Value
public class AddCartProductDTO {
    String productId;
    Integer quantity;
}
