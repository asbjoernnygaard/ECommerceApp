package se.salt.ecommerceback.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.salt.ecommerceback.cart.model.Cart;
import se.salt.ecommerceback.user.model.User;
import se.salt.ecommerceback.user.model.UserResponseDTO;
import se.salt.ecommerceback.user.service.UserService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    ResponseEntity<String> hello () {
        return ResponseEntity.ok("Hello!");
    }

    //@PreAuthorize("#username == principal.username")
    @GetMapping("/{username}")
    ResponseEntity<UserResponseDTO> getUserById(@PathVariable String username) {
        try {
            UserResponseDTO dto = service.getUserByName(username);
            // USER IS SOMEHOW UNABLE TO DESERIALIZE BACK TO USER WHAT LOL
            return ResponseEntity.ok(dto);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
