package web.flux.repository;

import web.flux.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

/**
 * @author z
 */
public interface UserRepository extends JpaRepository<User, BigInteger>{
    /**
     * spring security
     * @param username username
     * @return user
     */
    User findByName(String username);
}
