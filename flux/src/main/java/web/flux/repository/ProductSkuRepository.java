package web.flux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.flux.entity.ProductSku;

import java.math.BigInteger;

/**
 * @author z
 */
public interface ProductSkuRepository extends JpaRepository<ProductSku, BigInteger> {
}
