package web.flux.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import web.flux.api.ProductController;
import web.flux.entity.Product;
import web.flux.repository.ProductRepository;
import java.net.URI;

import static org.springframework.web.servlet.function.RequestPredicates.*;

/**
 * @author z
 */
@Configuration
public class ProductRouterConfig {

    public ProductRepository productRepository;

    @Autowired
    public ProductRouterConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Bean
//    public RouterFunction<?> routerFunction() {
//        return RouterFunctions.route(GET("/router/products"), this::index)
//                .andRoute(POST("/router/products"), this::store);
//    }

//    public Mono<ServerResponse> index(ServerRequest request) {
//        return ServerResponse.ok()
//                .body(productRepository.findAll(), Product.class);
//    }
//
//    public Mono<ServerResponse> store(ServerRequest request) {
//        Mono<Product> productMono = request.bodyToMono(Product.class);
//        Mono<Product> savedProduct = productRepository.save(productMono.block());
//        return ServerResponse.created(URI.create("http://localhost:8080/show/" + savedProduct.block().getId()))
//                .body(savedProduct, Product.class);
//    }
}
