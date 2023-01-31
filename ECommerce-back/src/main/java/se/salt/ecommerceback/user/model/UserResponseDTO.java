package se.salt.ecommerceback.user.model;

import lombok.Value;
import se.salt.ecommerceback.cart.model.CartResponseDTO;

@Value
public class UserResponseDTO {
    String username;
    Role role;
    CartResponseDTO cart;
}
