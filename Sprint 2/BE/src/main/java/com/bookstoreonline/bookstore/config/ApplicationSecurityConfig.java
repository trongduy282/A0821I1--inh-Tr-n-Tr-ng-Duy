package com.bookstoreonline.bookstore.config;

import com.bookstoreonline.bookstore.dao.account.AccountRepository;
import com.bookstoreonline.bookstore.security.utils.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.http.HttpServletResponse;
import static org.springframework.http.HttpMethod.GET;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private UserDetailsService jwtService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> accountRepository.findAllByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User" + username + "not found"))
        );
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();

//        http.cors();
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/books","/api/books/book-search", "/api/books/checkBook",
//                        "/api/account/create-Account","/api/books/detail/{id}",
//                        "/api/cart/addBookIntoCart/{id}","/api/cart/list/{id}",
//                        "/api/cart/delete/{cartId}","/api/cart/findCartIdExists/{id}",
//                        "/api/cart/changeQuantityCart").permitAll();

//        http.authorizeRequests().antMatchers("/auth/login").permitAll()
//                .antMatchers(HttpHeaders.ALLOW).permitAll()
//                .antMatchers(GET,"/api/books/**").hasAuthority("ROLE_ADMIN")
//                .anyRequest().authenticated();


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests().anyRequest().permitAll();
        http.exceptionHandling().authenticationEntryPoint(
                (request, response, ex) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                            ex.getMessage());
                }
        );

//        http.authorizeRequests()
//            .antMatchers("/auth/login").permitAll()
//            .anyRequest().authenticated();

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
