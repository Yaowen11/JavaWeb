package web.flux.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.flux.entity.Product;

import java.math.BigInteger;
import java.util.List;

/**
 * @author z
 */
public interface ProductRepository extends JpaRepository<Product, BigInteger> {
    /**
     * search
     * @param title tile
     * @param size limit
     * @return list
     */
    @Query(nativeQuery = true, value = "select * from product where title like concat('%', :title, '%') order by id desc limit :size, 10")
    List<Product> search(@Param("title") String title, int size);
}
