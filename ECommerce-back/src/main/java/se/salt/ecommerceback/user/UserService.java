package se.salt.ecommerceback.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.ecommerceback.user.model.User;
import se.salt.ecommerceback.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User getUserByName (String name) {
        return repo.getUserByName(name);
    }
}
