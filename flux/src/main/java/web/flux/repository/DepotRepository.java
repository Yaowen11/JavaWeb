package web.flux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.flux.entity.Depot;

/**
 * @author z
 */
public interface DepotRepository extends JpaRepository<Depot, Integer> {
}
