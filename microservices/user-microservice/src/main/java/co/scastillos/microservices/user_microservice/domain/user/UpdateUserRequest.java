package co.scastillos.microservices.user_microservice.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UpdateUserRequest(

        @NotNull Long id,
        String username,
        String password,
        String name,
        String lastname,
        @Email String email,
        Integer age,
        Integer phone

) {
}
