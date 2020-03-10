package web.flux.repository;

import web.flux.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author z
 */
public interface UserRepository extends JpaRepository<User, Long>{
    /**
     * spring security
     * @param username username
     * @return user
     */
    User findByName(String username);
}
