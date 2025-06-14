package co.scastillos.microservices.teacher_microservice.domain.teacher;

import lombok.Builder;

@Builder
public record UpdateTeacherRequest(

        String teacherId,
        String aboutMe

) {
}
