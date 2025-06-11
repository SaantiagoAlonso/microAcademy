package co.scastillos.microservices.user_microservice.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record NewUserRequest(

        @NotNull(message = "the username is required")
        @NotBlank(message = " the username cannot be blank")
        String username,

        @NotNull(message = "the password is requited")
        @NotBlank(message = "the password cannot be blank")
        String password,

        @NotNull(message = "the name is required")
        @NotBlank(message = "the name cannot be blank")
        String name,

        @NotNull(message = "the lastname is required")
        @NotBlank(message = "the lastname cannot be blank")
        String lastname,

        @NotNull(message = "the email is required")
        @NotBlank(message = "the email cannot be blank")
        @Email
        String email,

        @NotNull(message = "the age is required")
        Integer age,

        Integer phone
) {
}
