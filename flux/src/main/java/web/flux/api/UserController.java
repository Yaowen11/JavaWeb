package web.flux.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.flux.entity.User;
import web.flux.repository.UserRepository;

/**
 * @author z
 */
@RestController
@Slf4j
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

    @PostMapping(value = "/store", consumes = {"application/json"})
    public Mono<User> store(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return Mono.just(userRepository.save(user));
    }

    @GetMapping("/{id}")
    public Mono<User> show(@PathVariable Long id) {
        return Mono.just(userRepository.findById(id).get());
    }
}
