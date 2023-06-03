package com.automorfosi.mathisi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/healthCheckApi/v1/")
public class HealthCheckController {
    private static final Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @GetMapping("/ping")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

}
