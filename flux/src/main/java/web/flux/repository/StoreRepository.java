package web.flux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.flux.entity.Store;

/**
 * @author z
 */
public interface StoreRepository extends JpaRepository<Store, Integer> {
}
