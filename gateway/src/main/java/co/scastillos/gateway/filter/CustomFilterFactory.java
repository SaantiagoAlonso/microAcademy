package co.scastillos.gateway.filter;

import co.scastillos.gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class CustomFilterFactory extends AbstractGatewayFilterFactory<CustomFilterFactory.Config> {

    @Autowired
    private JwtUtil jwtUtil;

    public CustomFilterFactory(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(CustomFilterFactory.Config config) {
        return (exchange, chain) -> {

            String headerToken = exchange.getRequest().getHeaders().getFirst("Authorization");


            if(headerToken == null){
                return unauthorized(exchange);
            }

            String accessToken = headerToken.substring(7);

            if(!jwtUtil.isTokenValid(accessToken)){
                return unauthorized(exchange);
            }

            if (jwtUtil.isTokenValid(accessToken)){
                return chain.filter(exchange);
            }

            return unauthorized(exchange);

        };
    }

    public Mono<Void> unauthorized(ServerWebExchange exchange){
        var response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        String error = "unauthorized";
        DataBuffer buffer = response.bufferFactory().wrap(error.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(buffer));

    }


    public static class Config {}

}
