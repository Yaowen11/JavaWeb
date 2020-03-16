package web.flux.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.flux.entity.Product;
import web.flux.repository.ProductRepository;

/**
 * @author z
 */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public Flux<Product> index() {
//        return productRepository.findAll().take(10);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<Product> store(@RequestBody Mono<Product> productMono) {
//        return productRepository.saveAll(productMono).next();
//    }
}
