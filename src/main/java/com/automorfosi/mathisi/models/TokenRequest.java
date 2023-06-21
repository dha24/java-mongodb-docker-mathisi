package com.automorfosi.mathisi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Schema(
        description = "JwtToken Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {

    @Schema(description = "For which organization this token belongs to")
    @NotEmpty(message = "Subject shouldn't be Null")

    private String subject;
    private String issuer;
    private int validityInHour;
    private Date issuedAt;
    private String audience;
    private String organization;
    private String role;
    @Schema(description = "For which user this token belongs to")
    // User email should not be null or empty
    // Email address should be valid
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email; //todo user will request the token based on the email provided, its roles needs to be checked from DB and token would be generated with that role
    private String password; //todo token should be generated for authenticated users this password needs to share

}
