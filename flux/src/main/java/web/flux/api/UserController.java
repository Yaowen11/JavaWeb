package web.flux.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.flux.entity.User;
import web.flux.repository.UserRepository;

/**
 * @author z
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Flux<User> index() {
        return Flux.fromIterable(userRepository.findAll()).take(10);
    }

    @PostMapping
    public Mono<User> store(User user) {
        return Mono.just(userRepository.save(user));
    }

    @GetMapping("/{id}")
    public Mono<User> show(@PathVariable Long id) {
        return Mono.just(userRepository.findById(id).get());
    }
}
