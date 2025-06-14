package co.scastillos.microservices.curse_microservice.domain.curse;

import lombok.Builder;

@Builder
public record NewCurseRequest(

        String name,
        String description

) {
}
