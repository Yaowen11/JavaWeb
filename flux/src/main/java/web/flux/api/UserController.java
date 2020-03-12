package web.flux.api;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import web.flux.config.JsonViewInterface;
import web.flux.entity.User;
import web.flux.repository.UserRepository;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    public List<User> index(@RequestParam int page, @RequestParam int size) {
        return userRepository.findAll().subList((page - 1) * 10, (page - 1) * 10 + size);
    }

    @PostMapping(value = "/store", consumes = {"application/json"})
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    public User store(@RequestBody User user) {
        log.debug(String.valueOf(user));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return userRepository.save(user);
    }

    @PutMapping
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    public User replace(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViewInterface.Video.ViewHot.class)
    public ResponseEntity<User> show(@PathVariable BigInteger id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable BigInteger id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignore) {

        }
    }

}
