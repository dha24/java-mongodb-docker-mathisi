package com.automorfosi.mathisi.services;

import com.automorfosi.mathisi.models.AuthToken;
import com.automorfosi.mathisi.models.TokenRequest;
import com.automorfosi.mathisi.models.User;
import com.automorfosi.mathisi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    //adjust the page and size parameters according to your need
    public Page<User> getEnabledUsers(int page, int size) {
        logger.info("fetching enabled users");
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAllByEnabledTrue(pageable);
    }
    public AuthToken authenticate(TokenRequest authTokenRequest){

        logger.info("authentication manager validating user!!"+authTokenRequest.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authTokenRequest.getEmail(),
                        authTokenRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(authTokenRequest.getEmail())
                .orElseThrow();
        var jwtToken  = jwtService.generateToken(user);
        //todo implement logic for the refresh token
        return AuthToken.builder().jwtToken(jwtToken).build();
    }


}
