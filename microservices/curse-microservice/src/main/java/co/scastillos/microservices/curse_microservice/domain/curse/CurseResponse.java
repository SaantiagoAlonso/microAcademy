package co.scastillos.microservices.curse_microservice.domain.curse;

import lombok.Builder;

import java.util.Date;

@Builder
public record CurseResponse(

        String name,
        String description,
        Date creationDate,
        String teacherName,
        String imageCurseURL

) {
}
