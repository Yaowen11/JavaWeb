package web.flux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.flux.entity.Product;

import java.math.BigInteger;

/**
 * @author z
 */
public interface ProductRepository extends JpaRepository<Product, BigInteger> {
}
