package com.bookstoreonline.bookstore.security.jwt;

import com.bookstoreonline.bookstore.dao.account.AccountRepository;
import com.bookstoreonline.bookstore.entity.account.Account;
import com.bookstoreonline.bookstore.security.utils.JwtServiceImpl;
import com.bookstoreonline.bookstore.security.utils.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RestController
public class AuthApi {

    @Autowired
    private JwtServiceImpl service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountRepository accountRepository;


    @PostMapping("/auth/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            String username = authRequest.getUsername();
            String password = authRequest.getPassword();
            System.out.println(username);
            System.out.println(password);
            authenticate(username , password);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Account account = (Account) authentication.getPrincipal();

            UserDetails userDetails = service.loadUserByUsername(authRequest.getUsername());
            String accessToken = jwtTokenUtil.generateToken(account);

            Account account1 = accountRepository.findAccountByUsername(authRequest.getUsername());

            return ResponseEntity.ok(new JwtResponse(account1,accessToken));
        } catch (BadCredentialsException exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    private void authenticate(String username , String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username , password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED" , e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS" , e);
        }
    }
}

