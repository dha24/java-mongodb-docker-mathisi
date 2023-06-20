package com.automorfosi.mathisi.services;

import com.automorfosi.mathisi.models.AuthToken;
import com.automorfosi.mathisi.models.JwtToken;
import com.automorfosi.mathisi.models.User;
import com.automorfosi.mathisi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    //adjust the page and size parameters according to your need
    public Page<User> getEnabledUsers(int page, int size) {
        logger.debug("fetching enabled users");
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAllByEnabledTrue(pageable);
    }
    public AuthToken authenticate(JwtToken jwtTokenRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtTokenRequest.getEmail(),
                        jwtTokenRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(jwtTokenRequest.getEmail())
                .orElseThrow();
        var jwtToken  = jwtService.generateToken(user);
        //todo implement logic for the refresh token
        var message  = "Token Generated!!";
        return AuthToken.builder().jwtToken(jwtToken).build();
    }


}
