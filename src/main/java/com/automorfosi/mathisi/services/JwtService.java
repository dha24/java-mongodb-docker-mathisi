package com.automorfosi.mathisi.services;

import com.automorfosi.mathisi.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    private static final String SECRET_KEY = "25432AA@@!!!OINJA~SKET~54@#$56A586E3L876FMESTD2723575387(8^D#LO82F413F4{,}";
    //todo Implement KMS

    private Key getSignInKey(){

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(User userInfo){
        HashMap<String, String> extraClaims = new HashMap<String, String>(); //todo all extra claims where you can update other required claims.
        extraClaims.put("orgId", userInfo.getOrgId());
        extraClaims.put("orgName", userInfo.getOrgName());
        extraClaims.put("userRole", userInfo.getRole().name()); //todo Make this role as an array
        return generateToken(extraClaims, userInfo);
    }

    public String generateToken(
            Map<String, String> extraClaims,
            User userInfo
    ){
        return Jwts.
                builder().
                setClaims(extraClaims).
                setSubject(userInfo.getEmail()).
                setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2 )). //todo currently 2 hr, change it to the 30 mins
                        signWith(getSignInKey(), SignatureAlgorithm.HS256).
                compact();
    }



}
