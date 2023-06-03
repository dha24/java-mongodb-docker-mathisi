package com.automorfosi.mathisi.models;

import java.util.Date;

public class JwtToken {
    private String subject;
    private String issuer;
    private Date expirationTime;
    private Date issuedAt;
    private String audience;
    private String organization;
    private String role;

    private String email; //todo user will request the token based on the email provided, its roles needs to be checked from DB and token would be generated with that role
}
