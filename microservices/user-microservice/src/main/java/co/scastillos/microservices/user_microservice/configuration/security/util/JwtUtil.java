package co.scastillos.microservices.user_microservice.configuration.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private String privateKey = "test_secret_key";
    private String userGenerator = "backend_user";

    public String createToken(Authentication authentication){

        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);
        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        String username = authentication.getPrincipal().toString();

        String token = JWT.create()
                .withIssuer(userGenerator)
                .withSubject(username)
                .withClaim("authorities",authorities)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1800000))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);

        return token;

    }


}
