package web.flux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.flux.entity.User;
import web.flux.repository.UserRepository;

/**
 * @author z
 */
@Service
public class UserRepositoryDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    UserRepositoryDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User" + username + "not found");
    }
}
