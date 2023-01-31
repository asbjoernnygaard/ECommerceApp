package se.salt.ecommerceback.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.salt.ecommerceback.cart.model.Cart;
import se.salt.ecommerceback.user.model.User;

import java.util.NoSuchElementException;

@Repository
public class UserRepository {

    @Autowired
    UserJPARepository repo;

    public User getUserByName(String name) {
        return repo.findUserByUsername(name);
    }

    public void save(User user) {
        User usr1 = repo.save(user);
        System.out.println(usr1);
    }

}
