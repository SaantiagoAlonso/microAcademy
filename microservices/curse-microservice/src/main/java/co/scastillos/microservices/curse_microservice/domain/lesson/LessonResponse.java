package co.scastillos.microservices.curse_microservice.domain.lesson;

import lombok.Builder;

@Builder
public record LessonResponse(

        String title,
        String description,
        String videoUrl,
        Integer order
) {
}
