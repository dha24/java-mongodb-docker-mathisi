package com.automorfosi.mathisi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Monitor Health",
        description = "Monitor application status"
)
@CrossOrigin
@RestController
@RequestMapping("/healthCheckApi/v1/")
public class HealthCheckController {
    private static final Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @Operation(
            summary = "Monitor Health",
            description = "It is used to return pong in request of a ping"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/ping")
    public ResponseEntity<String> getStatus() {
        logger.debug("Healthcheck validation!!");
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

}
