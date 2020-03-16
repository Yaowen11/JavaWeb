package web.flux.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

/**
 * @author z
 */
@Configuration
public class RouterFunctionConfig {
    @Bean
    public RouterFunction<?> helloRouterFunction() {
        return RouterFunctions.route(GET("/hello"), serverRequest -> ServerResponse.ok().body(Mono.just("Hello World!"), String.class))
                .andRoute(GET("/bye"), serverRequest -> ServerResponse.ok().body(Mono.just("See ya!"), String.class));
    }
}
