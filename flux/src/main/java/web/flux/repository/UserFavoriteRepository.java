package web.flux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.flux.entity.UserFavorite;

import java.math.BigInteger;

/**
 * @author z
 */
public interface UserFavoriteRepository extends JpaRepository<UserFavorite, BigInteger> {
}
