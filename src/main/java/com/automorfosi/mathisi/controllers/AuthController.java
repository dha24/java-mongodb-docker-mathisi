package com.automorfosi.mathisi.controllers;

import com.automorfosi.mathisi.models.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/identityProvider/v1")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/getIdentity")
    public ResponseEntity<String> authenticate(@RequestBody JwtToken request) {
        return new ResponseEntity<String>("Token Implementation in progress", HttpStatus.OK); //todo identity needs to be implemented
    }
}
