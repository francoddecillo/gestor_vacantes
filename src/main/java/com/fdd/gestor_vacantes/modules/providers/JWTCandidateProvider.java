package com.fdd.gestor_vacantes.modules.providers;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTCandidateProvider {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    public DecodedJWT validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        token = token.replace("Bearer ", "");
        try {
            var tokenDecoded = JWT.require(algorithm).build().verify(token);
            return tokenDecoded;
        }catch (JWTVerificationException e){
            e.printStackTrace();
            return null;
        }
    }
}
