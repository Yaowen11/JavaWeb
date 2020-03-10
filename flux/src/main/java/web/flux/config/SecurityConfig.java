package web.flux.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;


/**
 * @author z
 */
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private DataSource dataSource;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("admin")
//                .password(new BCryptPasswordEncoder().encode("secret"))
//                .authorities("ROLE_USER");
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select name, password, state from user where state = 0 and username = ?")
//                .authoritiesByUsernameQuery("select username, authority from user_auth where username = ?")
//                .passwordEncoder(new BCryptPasswordEncoder());
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
