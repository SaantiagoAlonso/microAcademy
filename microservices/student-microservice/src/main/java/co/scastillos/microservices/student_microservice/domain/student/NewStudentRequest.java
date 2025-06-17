package co.scastillos.microservices.student_microservice.domain.student;

import lombok.Builder;

@Builder
public record NewStudentRequest (

        String username,
        String name,
        String lastname,
        String email

) {
}
