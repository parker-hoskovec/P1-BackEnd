package dev.hoskovec.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    private static final String secret = "totally secret the secretest secret!";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    public static String generate(String role, String employeeName){

        String token = JWT.create()
        .withClaim("role",role)
                .withClaim("empName", employeeName)
                .sign(algorithm);
        return token;
    }

    public static DecodedJWT isValidJWT(String token){
        DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
        return jwt;
    }

}
