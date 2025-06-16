package co.scastillos.microservices.curse_microservice.domain.lesson;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddLessonRequest(

        @NotBlank(message = "curseId cannot be null")
        String curseId,

        @NotBlank(message = "title of lesson is required")
        String title,

        @NotBlank(message = "description of curse is required")
        String description,
        Integer order
) {
}
