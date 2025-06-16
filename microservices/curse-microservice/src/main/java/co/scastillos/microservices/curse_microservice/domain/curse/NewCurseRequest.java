package co.scastillos.microservices.curse_microservice.domain.curse;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record NewCurseRequest(

        @NotBlank(message = "name of curse is required")
        String name,

        @NotBlank(message = "description of curse is required")
        String description,
        String imageCurseURL

) {
}
