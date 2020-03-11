package web.flux.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.flux.entity.Product;
import web.flux.repository.ProductRepository;

import java.util.List;

/**
 * @author z
 */
@RepositoryRestController
public class DefineProductController {

    private ProductRepository productRepository;

    @Autowired
    public DefineProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/{title}")
    public ResponseEntity<List<Product>> findByName(@PathVariable String title, @RequestParam int page) {
        return new ResponseEntity<>(productRepository.search(title, (page - 1) * 10), HttpStatus.OK);
    }
}
