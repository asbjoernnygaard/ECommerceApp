package se.salt.ecommerceback.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.salt.ecommerceback.user.model.User;

@Repository
public class UserRepository {

    @Autowired
    UserJPARepository repo;

    public User getUserByName(String name) {
        return repo.findUserByUsername(name);
    }

    public void save(User user) {
        repo.save(user);
    }
}
