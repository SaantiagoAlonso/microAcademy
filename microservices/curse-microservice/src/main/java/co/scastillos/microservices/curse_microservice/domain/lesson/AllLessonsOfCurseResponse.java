package co.scastillos.microservices.curse_microservice.domain.lesson;

import co.scastillos.microservices.curse_microservice.domain.curse.CurseResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record AllLessonsOfCurseResponse(
        CurseResponse curse,
        List<LessonResponse> lessons
) {
}
