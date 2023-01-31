package se.salt.ecommerceback.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.ecommerceback.cart.model.Cart;
import se.salt.ecommerceback.cart.model.CartResponseDTO;
import se.salt.ecommerceback.user.model.User;
import se.salt.ecommerceback.user.model.UserResponseDTO;
import se.salt.ecommerceback.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public UserResponseDTO getUserByName (String name) {
        //This logic really ought to be inside a converter class
        User user = repo.getUserByName(name);
        Cart cart = user.getCart();

        CartResponseDTO cartDto = new CartResponseDTO(
                cart.getId(),
                cart.getCartProducts()
        );

        UserResponseDTO userDto = new UserResponseDTO(
                user.getUsername(),
                user.getRole(),
                cartDto);
        System.out.println(userDto);
        return userDto;
    }

}
