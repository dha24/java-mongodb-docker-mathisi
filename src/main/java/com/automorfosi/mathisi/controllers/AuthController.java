package com.automorfosi.mathisi.controllers;

import com.automorfosi.mathisi.models.JwtToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Tag(
        name = "Grant identity",
        description = "For generating JWT token, for generating refresh token, for invalidating refresh token"
)
@RestController
@RequestMapping("/identityProvider/v1")
@RequiredArgsConstructor
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Operation(
            summary = "Get JWT token and Refresh token",
            description = "It is used to return JWT token and Refresh token"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PostMapping("/getIdentity")
    public ResponseEntity<String> authenticate(@RequestBody JwtToken request) {
        logger.debug("Granting Identity!");
        return new ResponseEntity<String>("Token Implementation in progress", HttpStatus.OK); //todo identity needs to be implemented
    }
}
