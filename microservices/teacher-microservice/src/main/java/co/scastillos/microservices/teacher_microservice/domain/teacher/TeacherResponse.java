package co.scastillos.microservices.teacher_microservice.domain.teacher;

import lombok.Builder;

@Builder
public record TeacherResponse(

        String username,
        String name,
        String lastname,
        String aboutMe,
        String email
) {
}
