package se.salt.ecommerceback.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.salt.ecommerceback.user.model.User;

public interface UserJPARepository extends JpaRepository<User, String> {
    User findUserByUsername(String name);
}
